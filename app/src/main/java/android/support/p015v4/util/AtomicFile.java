package android.support.p015v4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: android.support.v4.util.AtomicFile */
public class AtomicFile {
    private final File mBackupName;
    private final File mBaseName;

    public AtomicFile(File file) {
        this.mBaseName = file;
        this.mBackupName = new File(file.getPath() + ".bak");
    }

    static boolean sync(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public void delete() {
        this.mBaseName.delete();
        this.mBackupName.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            AtomicFile.sync(fileOutputStream);
            try {
                fileOutputStream.close();
                this.mBaseName.delete();
                this.mBackupName.renameTo(this.mBaseName);
            } catch (IOException e) {
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            AtomicFile.sync(fileOutputStream);
            try {
                fileOutputStream.close();
                this.mBackupName.delete();
            } catch (IOException e) {
            }
        }
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public FileInputStream openRead() {
        if (this.mBackupName.exists()) {
            this.mBaseName.delete();
            this.mBackupName.renameTo(this.mBaseName);
        }
        return new FileInputStream(this.mBaseName);
    }

    public byte[] readFully() {
        int i = 0;
        FileInputStream openRead = openRead();
        try {
            Object obj = new byte[openRead.available()];
            while (true) {
                int read = openRead.read(obj, i, obj.length - i);
                if (read <= 0) {
                    break;
                }
                Object obj2;
                read += i;
                i = openRead.available();
                if (i > obj.length - read) {
                    obj2 = new byte[(i + read)];
                    System.arraycopy(obj, 0, obj2, 0, read);
                } else {
                    obj2 = obj;
                }
                obj = obj2;
                i = read;
            }
            return obj;
        } finally {
            openRead.close();
        }
    }

    public FileOutputStream startWrite() {
        if (this.mBaseName.exists()) {
            if (this.mBackupName.exists()) {
                this.mBaseName.delete();
            } else if (!this.mBaseName.renameTo(this.mBackupName)) {
                new StringBuilder("Couldn't rename file ").append(this.mBaseName).append(" to backup file ").append(this.mBackupName);
            }
        }
        try {
            return new FileOutputStream(this.mBaseName);
        } catch (FileNotFoundException e) {
            if (this.mBaseName.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(this.mBaseName);
                } catch (FileNotFoundException e2) {
                    throw new IOException("Couldn't create " + this.mBaseName);
                }
            }
            throw new IOException("Couldn't create directory " + this.mBaseName);
        }
    }
}
