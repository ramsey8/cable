package cn.cyf.config;

import cn.cyf.common.ErrorCodeEnum;
import cn.cyf.common.ResponseData;
import cn.cyf.exception.IllegalValidateException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseData exception(Exception ex) {
        return ResponseData.builder().code(ErrorCodeEnum.C00000003.getCode())
                .message(ErrorCodeEnum.C00000003.getMessage())
                .data(ex.getMessage())
                .build();
    }
    @ExceptionHandler(IllegalValidateException.class)
    public ResponseData validationException(IllegalValidateException ex) {

        return ResponseData.builder().code(ErrorCodeEnum.C00000002.getCode())
                .message(ErrorCodeEnum.C00000002.getMessage())
                .data(ex.getMessage())
                .build();
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseData exception(UnauthorizedException ex) {
        return ResponseData.fail(ErrorCodeEnum.C00000005);
    }
}
