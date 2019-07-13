package cn.cyf.config;

import cn.cyf.common.ErrorCodeEnum;
import cn.cyf.common.ResponseData;
import cn.cyf.exception.IllegalValidateException;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    protected Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseData exception(Exception ex) {
        logger.error("铺货异常信息,", ex);
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
