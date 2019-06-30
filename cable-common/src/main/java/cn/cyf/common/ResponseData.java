package cn.cyf.common;

import lombok.*;

import java.io.Serializable;

/**
 * controller接口返回对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseData implements Serializable {

    private static final long serialVersionUID = -7865406515928789694L;
    private String message;
    private String code;
    private Object data;

    public static ResponseData ok(Object data) {
        return ResponseData.builder().code(ErrorCodeEnum.C00000000.getCode()).message(ErrorCodeEnum.C00000000.getMessage()).data(data).build();
    }

    public static ResponseData ok() {
        return ok(null);
    }

    public static ResponseData fail(ErrorCodeEnum code) {
        return ResponseData.builder().code(code.getCode()).message(code.getMessage()).build();
    }
}
