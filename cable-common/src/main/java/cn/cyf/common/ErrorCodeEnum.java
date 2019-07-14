package cn.cyf.common;

public enum ErrorCodeEnum {

    C00000000("00000000", "success"),
    C00000001("00000001", "登陆已过期,请重新登陆"),
    C00000002("00000002", "参数异常"),
    C00000003("00000003", "unknow error"),
    C00000004("00000004", "用户名或密码错误"),
    C00000005("00000005", "权限不足"),
    C00000006("00000006", "账号被锁定");

    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
