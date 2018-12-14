package com.tencent.xuanfeng.libInterface;

public interface newInterface {

    public enum ERROR_DEF {
        ERROR_OK,
        ERROR_DLSVRTIMEOUT,
        ERROR_DLCONNECTFAIL,
        ERROR_INITFILE,
        ERROR_STARTHTTP,
        ERROR_WRITEFAIL,
        ERROR_STARTP2P,
        ERROR_LOGIN,
        ERROR_NETWORK,
        ERROR_REDIRECT,
        ERROR_COMMUNICATION,
        ERROR_TASK_LIST_FULL,
        ERROR_TASK_ALREADY_EXISTS,
        ERROR_TASK_PROTOCOL_UNREACHABLE,
        ERROR_TASK_SERVICE_DISABLED,
        ERROR_TASK_SERVICE_NOT_FOUND,
        ERROR_RESUME_FILE_CHANGED,
        ERROR_FILE_GARUD_TIME_OUT,
        ERROR_SERVER_LIMIT,
        ERROR_STATE_FORBIDDEN
    }

    TASKINFO GetProjectInfo(String str);

    void ModTaskInfo(String str, String str2, TASKINFO taskinfo);

    int PauseTask(String str);

    boolean RemoveItemRelated(String str, String str2);

    void SetAutoLimitSpeed(long j);

    void SetDownloadMode(int i, int i2);

    void SetDownloadSpeed(long j);

    void SetTaskPriority(String str, int i);

    int StartTask(String str);

    int addTaskInQueue(int i, TASKINFO taskinfo);

    void cleanQueue(int i);

    int createQueue();

    void onDownloadStart(int i);

    void onErrorInfo(int i, int i2);

    int removeTaskInQueue(int i);

    void setConfig(int i, Config config);
}
