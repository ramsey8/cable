package cn.cyf.common.enums;

public enum  UserStatusEnum {
    
    NORMAL(1),
    LOCK(0);


    private final int code;

    UserStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
