package com.tencent.xuanfeng.downloadsdkkernel;

import android.content.Context;
import com.tencent.xuanfeng.libInterface.IKernel;
import com.tencent.xuanfeng.libInterface.OnFileDownloadListener;
import com.tencent.xuanfeng.libInterface.P2PInitParam;
import com.tencent.xuanfeng.libInterface.TASKINFO;
import java.io.File;
import java.util.ArrayList;

public class KernelImpl implements IKernel {
    public static final String TAG = "kernelimpl";
    static final String XUANFENGDIR = "/xuanfeng";
    private static KernelImpl instance = new KernelImpl();
    private Context context;
    private Kernel kernel = Kernel.getKernel();
    private OnFileDownloadListener listener;
    private boolean search;

    private KernelImpl() {
    }

    public static KernelImpl getInstance() {
        return instance;
    }

    public int CreateTask(TASKINFO taskinfo) {
        long j = 0;
        String str = null;
        if (taskinfo == null || taskinfo.strPathName == null) {
            return 0;
        }
        String str2 = taskinfo.xf_fid;
        if (taskinfo.xf_fid == null) {
            taskinfo.xf_fid = "";
        }
        int CreateHttpTask;
        ArrayList sDDir;
        Info maxSize;
        File file;
        if (StorageUntl.isDirCanWrite(taskinfo.strPathName)) {
            long cardAvailableSize = StorageUntl.getCardAvailableSize(taskinfo.strPathName);
            taskinfo.ailableSize = cardAvailableSize;
            if (cardAvailableSize > 0) {
                taskinfo.ailableSize = StorageUntl.getCardAvailableSize(taskinfo.strPathName);
                String str3 = taskinfo.strFileName;
                if (taskinfo.strFileName != null) {
                    taskinfo.strFileName = taskinfo.strPathName + "/" + taskinfo.strFileName;
                } else {
                    taskinfo.strFileName = taskinfo.strPathName;
                }
                new StringBuilder("Create时info.strFileName:").append(taskinfo.strFileName);
                new StringBuilder("Create时info.ailableSize:").append(taskinfo.ailableSize).append("   ").append(StorageUntl.getSize(taskinfo.ailableSize));
                CreateHttpTask = this.kernel.CreateHttpTask(taskinfo);
                taskinfo.strFileName = str3;
                taskinfo.xf_fid = str2;
                return CreateHttpTask;
            } else if (this.search) {
                sDDir = StorageUntl.getSDDir(this.context);
                if (sDDir != null && sDDir.size() > 0) {
                    maxSize = StorageUntl.getMaxSize(sDDir);
                    str = maxSize.path;
                    j = maxSize.size;
                }
                if (this.listener != null) {
                    this.listener.onStorageErrorInfo(taskinfo.uiTaskID, 102, str);
                }
                if (str == null) {
                    return 0;
                }
                file = new File(new StringBuilder(String.valueOf(str)).append(XUANFENGDIR).toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                taskinfo.strPathName = str;
                str = taskinfo.strFileName;
                if (taskinfo.strFileName != null) {
                    taskinfo.strFileName = taskinfo.strPathName + "/" + taskinfo.strFileName;
                } else {
                    taskinfo.strFileName = taskinfo.strPathName;
                }
                taskinfo.ailableSize = j;
                CreateHttpTask = this.kernel.CreateHttpTask(taskinfo);
                taskinfo.strFileName = str;
                taskinfo.xf_fid = str2;
                return CreateHttpTask;
            } else {
                if (this.listener != null) {
                    this.listener.onStorageErrorInfo(taskinfo.uiTaskID, 102, null);
                }
                return 0;
            }
        } else if (this.search) {
            Object obj;
            sDDir = StorageUntl.getSDDir(this.context);
            if (sDDir != null && sDDir.size() > 0) {
                maxSize = StorageUntl.getMaxSize(sDDir);
                obj = maxSize.path;
                j = maxSize.size;
            }
            if (obj == null) {
                return 0;
            }
            file = new File(new StringBuilder(String.valueOf(obj)).append(XUANFENGDIR).toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            taskinfo.strPathName = file.getPath();
            str = taskinfo.strFileName;
            if (taskinfo.strFileName != null) {
                taskinfo.strFileName = taskinfo.strPathName + "/" + taskinfo.strFileName;
            } else {
                taskinfo.strFileName = taskinfo.strPathName;
            }
            taskinfo.ailableSize = j;
            CreateHttpTask = this.kernel.CreateHttpTask(taskinfo);
            taskinfo.strFileName = str;
            taskinfo.xf_fid = str2;
            if (this.listener == null) {
                return CreateHttpTask;
            }
            this.listener.onStorageErrorInfo(taskinfo.uiTaskID, 101, taskinfo.strFileName);
            return CreateHttpTask;
        } else {
            if (this.listener != null) {
                this.listener.onStorageErrorInfo(taskinfo.uiTaskID, 101, null);
            }
            return 0;
        }
    }

    public int DelTask(String str) {
        return str == null ? -1 : this.kernel.DelTask(str);
    }

    public boolean KernelInit(Context context, P2PInitParam p2PInitParam) {
        this.context = context;
        return this.kernel.KernelInit(context, p2PInitParam);
    }

    public boolean KernelUnInit(Context context) {
        return this.kernel.KernelUnInit(context);
    }

    public int addTaskInQueue(TASKINFO taskinfo) {
        long j = 0;
        String str = null;
        if (taskinfo.priority > 2) {
            taskinfo.priority = 2;
        } else if (taskinfo.priority < 0) {
            taskinfo.priority = 0;
        }
        if (taskinfo.netDownloadType < 0) {
            taskinfo.netDownloadType = 0;
        } else if (taskinfo.netDownloadType > 1) {
            taskinfo.netDownloadType = 1;
        }
        if (taskinfo == null || taskinfo.strPathName == null) {
            return 0;
        }
        String str2 = taskinfo.xf_fid;
        if (taskinfo.xf_fid == null) {
            taskinfo.xf_fid = "";
        }
        int addTaskInQueue;
        ArrayList sDDir;
        Info maxSize;
        File file;
        if (StorageUntl.isDirCanWrite(taskinfo.strPathName)) {
            long cardAvailableSize = StorageUntl.getCardAvailableSize(taskinfo.strPathName);
            taskinfo.ailableSize = cardAvailableSize;
            if (cardAvailableSize > 0) {
                taskinfo.ailableSize = StorageUntl.getCardAvailableSize(taskinfo.strPathName);
                String str3 = taskinfo.strFileName;
                if (taskinfo.strFileName != null) {
                    taskinfo.strFileName = taskinfo.strPathName + "/" + taskinfo.strFileName;
                } else {
                    taskinfo.strFileName = taskinfo.strPathName;
                }
                addTaskInQueue = this.kernel.addTaskInQueue(taskinfo);
                taskinfo.strFileName = str3;
                taskinfo.xf_fid = str2;
                return addTaskInQueue;
            } else if (this.search) {
                sDDir = StorageUntl.getSDDir(this.context);
                if (sDDir != null && sDDir.size() > 0) {
                    maxSize = StorageUntl.getMaxSize(sDDir);
                    str = maxSize.path;
                    j = maxSize.size;
                }
                if (this.listener != null) {
                    this.listener.onStorageErrorInfo(taskinfo.uiTaskID, 102, str);
                }
                if (str == null) {
                    return 0;
                }
                file = new File(new StringBuilder(String.valueOf(str)).append(XUANFENGDIR).toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                taskinfo.strPathName = str;
                str = taskinfo.strFileName;
                if (taskinfo.strFileName != null) {
                    taskinfo.strFileName = taskinfo.strPathName + "/" + taskinfo.strFileName;
                } else {
                    taskinfo.strFileName = taskinfo.strPathName;
                }
                taskinfo.ailableSize = j;
                addTaskInQueue = this.kernel.addTaskInQueue(taskinfo);
                taskinfo.strFileName = str;
                taskinfo.xf_fid = str2;
                return addTaskInQueue;
            } else {
                if (this.listener != null) {
                    this.listener.onStorageErrorInfo(taskinfo.uiTaskID, 102, null);
                }
                return 0;
            }
        } else if (this.search) {
            Object obj;
            sDDir = StorageUntl.getSDDir(this.context);
            if (sDDir != null && sDDir.size() > 0) {
                maxSize = StorageUntl.getMaxSize(sDDir);
                obj = maxSize.path;
                j = maxSize.size;
            }
            if (obj == null) {
                return 0;
            }
            file = new File(new StringBuilder(String.valueOf(obj)).append(XUANFENGDIR).toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            taskinfo.strPathName = file.getPath();
            str = taskinfo.strFileName;
            if (taskinfo.strFileName != null) {
                taskinfo.strFileName = taskinfo.strPathName + "/" + taskinfo.strFileName;
            } else {
                taskinfo.strFileName = taskinfo.strPathName;
            }
            taskinfo.ailableSize = j;
            addTaskInQueue = this.kernel.addTaskInQueue(taskinfo);
            taskinfo.strFileName = str;
            taskinfo.xf_fid = str2;
            if (this.listener == null) {
                return addTaskInQueue;
            }
            this.listener.onStorageErrorInfo(taskinfo.uiTaskID, 101, taskinfo.strFileName);
            return addTaskInQueue;
        } else {
            if (this.listener != null) {
                this.listener.onStorageErrorInfo(taskinfo.uiTaskID, 101, null);
            }
            return 0;
        }
    }

    public void onComplete(int i, long j) {
        if (this.listener != null) {
            this.listener.onComplete(i, j);
        }
    }

    public void onFileName(int i, String str) {
        if (this.listener != null) {
            this.listener.onFileName(i, str);
        }
    }

    public void onTaskInfo(int i, int i2, int i3) {
        if (this.listener != null) {
            this.listener.onTaskInfo(i, i2, i3);
        }
    }

    public int removeTaskInQueue(int i) {
        return i < 3 ? 0 : this.kernel.removeTaskInQueue(i);
    }

    public void setIncrementFileSizeMB(int i) {
        this.kernel.setIncrementFileSizeMB(i);
    }

    public void setLibName(String str) {
        this.kernel.setLibName(str);
    }

    public void setLocalLogEnable(boolean z) {
        this.kernel.setLocalLogEnable(z);
    }

    public void setLogLevel(int i) {
        this.kernel.setLogLevel(i);
    }

    public void setLogPath(String str) {
        this.kernel.setLogPath(str);
    }

    public void setLogcatEnable(boolean z) {
        this.kernel.setLogcatEnable(z);
    }

    public void setOnFileDownloadListener(OnFileDownloadListener onFileDownloadListener) {
        this.listener = onFileDownloadListener;
        this.kernel.setOnFileDownloadListener(onFileDownloadListener);
    }

    public void setSmallFileStrategy(int i) {
        this.kernel.setSmallFileStrategy(i);
    }

    public void setUseSearchDir(boolean z) {
        this.search = z;
    }

    public void setUserInfo(String str, String str2) {
        this.kernel.setUserInfo(str, str2);
    }

    public void setUseragent(String str) {
        this.kernel.setUseragent(str);
    }
}
