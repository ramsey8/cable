package cn.cyf.aspectj;

import cn.cyf.exception.IllegalValidateException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.lang.reflect.Field;
import java.util.HashMap;

@Aspect
@Slf4j
@Component
public class HibernateValidatorAspect implements Ordered {

    @Around(value = "within(cn.cyf.*.controller.*) " +
            "&& (@annotation(org.springframework.web.bind.annotation.ResponseBody) " +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                throwIfInvalidModel((BindingResult) arg);
            }
        }
        return joinPoint.proceed();
    }

    private void throwIfInvalidModel(BindingResult br){

        int errorCount = br.getErrorCount();
        if (errorCount > 0) {
            Class<?> clazz = br.getTarget().getClass();
            final HashMap<Object, Object> errorMap = Maps.newHashMap();
            for (FieldError fieldError : br.getFieldErrors()) {
                try {
                    String errorFieldName = fieldError.getField();
                    Field errorField = clazz.getDeclaredField(errorFieldName);
                    JSONField jsonProperty = errorField.getAnnotation(JSONField.class);
                    if (jsonProperty != null) {
                        errorFieldName = jsonProperty.name();
                    }
                    log.debug("request error field: {}, error msg: {}",
                            errorFieldName, fieldError.getDefaultMessage());
                    errorMap.put(errorFieldName, fieldError.getDefaultMessage());
                } catch (NoSuchFieldException e) {
                    log.error("反射字段名时抛出异常: {}", e.getMessage());
                }
            }
            throw new IllegalValidateException(JSONObject.toJSONString(errorMap));
        }
    }

    @Override
    public int getOrder() {
        return Byte.MAX_VALUE + 2;
    }
}
