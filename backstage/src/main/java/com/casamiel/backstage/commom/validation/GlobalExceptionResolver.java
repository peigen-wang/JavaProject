package com.casamiel.backstage.commom.validation;


import com.casamiel.backstage.commom.emun.ErrorCodeEnum;
import com.casamiel.backstage.dto.base.BaseModelRsp;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.validation.BindException;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionResolver {

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public BaseModelRsp BindExceptionHandler(BindException e) {
        FieldError fieldError = e.getFieldError();
        return processBindingError(fieldError);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseModelRsp ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return new BaseModelRsp(ErrorCodeEnum.ParamError, message);
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseModelRsp MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        return processBindingError(fieldError);
    }

    /**
     * 根据spring binding 错误信息自定义返回错误码和错误信息
     *
     * @param fieldError
     * @return
     */
    private BaseModelRsp processBindingError(FieldError fieldError) {
        String code = fieldError.getCode();
        switch (code) {
            case "NotEmpty":
            case "NotBlank":
            case "NotNull":
                return new BaseModelRsp(ErrorCodeEnum.ParamEmpty, fieldError.getDefaultMessage());
            case "Pattern":
            case "Min":
            case "Max":
            case "Length":
            case "Range":
            case "Email":
            case "DecimalMin":
            case "DecimalMax":
            case "Size":
            case "Digits":
            case "Past":
            case "Future":
                return new BaseModelRsp(ErrorCodeEnum.ParamError, fieldError.getDefaultMessage());
            default:
                return new BaseModelRsp(ErrorCodeEnum.UnKnownError, fieldError.getDefaultMessage());
        }
    }


}
