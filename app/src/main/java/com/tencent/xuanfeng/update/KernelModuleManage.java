package com.tencent.xuanfeng.update;

import com.tencent.xuanfeng.libInterface.UpdateListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class KernelModuleManage implements KernelInfoCallback {
    public static final String LibkernelFileName = "libqqdlkernel.so";
    private static final String default_version = "18";
    private static final String kernelCfg = "kernel_module.cfg";
    private static final String kernelCfg_comment = "download update config";
    private static final String kernelDownloadPath = "kernel_update";
    public static final String kernelInstallPath = "libs";
    private static final String kernelPackname = "qqdlkernel";
    private String appDataDir;
    private KernelDownload kernelDownload;
    private QueryUpdate kernelQuery;
    private UpdateListener updateCallback;

    public KernelModuleManage() {
        this.appDataDir = null;
        this.kernelQuery = null;
        this.kernelDownload = null;
        this.updateCallback = null;
        this.kernelQuery = new QueryUpdate();
        this.kernelDownload = new KernelDownload();
    }

    public void DownloadUpdateError(int i) {
        if (this.updateCallback != null) {
            this.updateCallback.UpdateError(16);
        }
    }

    public void DownloadUpdateSucess(KernelModuleInfo kernelModuleInfo) {
        saveDownloadUpdateKernel(kernelModuleInfo);
        if (!hasKernelInstalled()) {
            updateKernel();
            if (this.updateCallback != null) {
                this.updateCallback.UpdateSuccess();
            }
        } else if (this.updateCallback != null) {
            this.updateCallback.UpdateError(17);
        }
    }

    public void QueryUpadteNoUpdate() {
        if (this.updateCallback == null) {
            return;
        }
        if (hasKernelInstalled()) {
            this.updateCallback.UpdateSuccess();
        } else {
            this.updateCallback.UpdateError(16);
        }
    }

    public void QueryUpdateError(int i) {
        if (this.updateCallback != null) {
            this.updateCallback.UpdateError(16);
        }
    }

    public void QueryUpdateNeedUpdate(KernelModuleInfo kernelModuleInfo) {
        if (this.kernelDownload != null) {
            this.kernelDownload.startDownloadKernel(kernelModuleInfo, this.appDataDir + "/kernel_update", LibkernelFileName);
        }
        if (this.updateCallback != null) {
            this.updateCallback.UpdateStatus(1);
        }
    }

    public void deleteUpdateModule() {
        if (this.appDataDir != null) {
            File file = new File(this.appDataDir + kernelDownloadPath, LibkernelFileName);
            if (file.exists()) {
                file.delete();
            }
            file = new File(this.appDataDir + kernelDownloadPath, kernelCfg);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public boolean getInfo(String str, String str2, KernelModuleInfo kernelModuleInfo) {
        if (str == null || str2 == null) {
            return false;
        }
        try {
            File file = new File(str, str2);
            if (!file.exists()) {
                return false;
            }
            InputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            kernelModuleInfo.kernelVersion = properties.getProperty(KernelModuleInfo.CFG_KERNERVERSION);
            kernelModuleInfo.kernelMD5 = properties.getProperty(KernelModuleInfo.CFG_KERNERMD5);
            fileInputStream.close();
            if (kernelModuleInfo.kernelVersion == null || kernelModuleInfo.kernelMD5 == null) {
                file.delete();
            }
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public boolean getKernelInfo(KernelModuleInfo kernelModuleInfo) {
        boolean info = getInfo(this.appDataDir + kernelInstallPath, kernelCfg, kernelModuleInfo);
        kernelModuleInfo.kernelPackname = kernelPackname;
        kernelModuleInfo.kernelInstalled = true;
        if (!info) {
            kernelModuleInfo.kernelInstalled = false;
            kernelModuleInfo.kernelVersion = default_version;
        }
        return info;
    }

    public boolean getKernelUpdateInfo(KernelModuleInfo kernelModuleInfo) {
        kernelModuleInfo.kernelPackname = kernelPackname;
        return getInfo(this.appDataDir + kernelDownloadPath, kernelCfg, kernelModuleInfo);
    }

    public boolean hasKernelInstalled() {
        if (new File(this.appDataDir + kernelInstallPath, LibkernelFileName).exists()) {
            return true;
        }
        File file = new File(this.appDataDir + kernelInstallPath, kernelCfg);
        if (file.exists()) {
            file.delete();
        }
        return false;
    }

    public void init(String str) {
        this.kernelQuery.setModuleName(str);
        this.kernelQuery.setKernelInfoCallback(this);
        this.kernelDownload.setKernelInfoCallback(this);
    }

    public boolean needUpdate() {
        KernelModuleInfo kernelModuleInfo = new KernelModuleInfo();
        KernelModuleInfo kernelModuleInfo2 = new KernelModuleInfo();
        if (getKernelUpdateInfo(kernelModuleInfo2)) {
            if (!getKernelInfo(kernelModuleInfo)) {
                return true;
            }
            if (!kernelModuleInfo.kernelVersion.equals(kernelModuleInfo2.kernelVersion)) {
                if (verifyUpdateModule(this.appDataDir + "kernel_update/libqqdlkernel.so", kernelModuleInfo2.kernelMD5)) {
                    return true;
                }
                deleteUpdateModule();
            }
        }
        return false;
    }

    public void saveDownloadUpdateKernel(KernelModuleInfo kernelModuleInfo) {
        saveInfo(this.appDataDir + kernelDownloadPath, kernelCfg, kernelModuleInfo);
    }

    public boolean saveInfo(String str, String str2, KernelModuleInfo kernelModuleInfo) {
        if (str == null || str2 == null) {
            return false;
        }
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            OutputStream fileOutputStream = new FileOutputStream(file);
            Properties properties = new Properties();
            properties.put(KernelModuleInfo.CFG_KERNERVERSION, kernelModuleInfo.kernelVersion);
            properties.put(KernelModuleInfo.CFG_KERNERMD5, kernelModuleInfo.kernelMD5);
            properties.store(fileOutputStream, kernelCfg_comment);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public void saveUpdatedKernel(KernelModuleInfo kernelModuleInfo) {
        saveInfo(this.appDataDir + kernelInstallPath, kernelCfg, kernelModuleInfo);
    }

    public void setAppDataDir(String str) {
        this.appDataDir = str;
        if (this.appDataDir != null && this.appDataDir.length() != 0) {
            if (this.appDataDir.charAt(this.appDataDir.length() - 1) != '/') {
                this.appDataDir += "/";
            }
            UpdateUtility.makesureDirCreated(this.appDataDir);
            UpdateUtility.makesureDirCreated(this.appDataDir + kernelInstallPath);
            UpdateUtility.makesureDirCreated(this.appDataDir + kernelDownloadPath);
        }
    }

    public void setUpdateCallback(UpdateListener updateListener) {
        this.updateCallback = updateListener;
    }

    public void startQuery() {
        KernelModuleInfo kernelModuleInfo = new KernelModuleInfo();
        getKernelInfo(kernelModuleInfo);
        if (this.kernelQuery != null) {
            this.kernelQuery.startQueryUpdate(kernelModuleInfo);
        }
    }

    public boolean updateKernel() {
        if (needUpdate()) {
            KernelModuleInfo kernelModuleInfo = new KernelModuleInfo();
            getKernelUpdateInfo(kernelModuleInfo);
            kernelModuleInfo.kernelLocalPath = this.appDataDir + "kernel_update/libqqdlkernel.so";
            KernelModuleInfo kernelModuleInfo2 = new KernelModuleInfo();
            kernelModuleInfo2.kernelLocalPath = this.appDataDir + "libs/libqqdlkernel.so";
            if (UpdateUtility.installKernelModule(kernelModuleInfo, kernelModuleInfo2)) {
                saveUpdatedKernel(kernelModuleInfo);
                deleteUpdateModule();
                return true;
            }
        }
        return false;
    }

    public boolean verifyUpdateModule(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        String fileMD5 = UpdateUtility.getFileMD5(file);
        return fileMD5 != null && fileMD5.toLowerCase().equals(str2.toLowerCase());
    }
}
