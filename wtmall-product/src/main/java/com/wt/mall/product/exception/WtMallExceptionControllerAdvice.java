package com.wt.mall.product.exception;

import com.wt.common.exception.BizCodeEnum;
import com.wt.common.utils.R;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//统一异常处理的类
//basePackages指定哪个包下的异常交给这个类来处理
@RestControllerAdvice(basePackages = "com.wt.mall.product.controller")
public class WtMallExceptionControllerAdvice {

    //表示这个方法处理MethodArgumentNotValidException类型的异常，就是数据校验错误异常
    //如果com.wt.mall.product.controller出现异常并抛出，会被抛到这里
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        //拿到JSR303校验的错误信息
        BindingResult bindingResult = e.getBindingResult();

        //将校验结果放到R中响应给前端
        //这个map用来放校验信息
        Map<String,String> map = new HashMap<>();
        //遍历每一个出错的校验字段
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            //获取字段名
            String field = fieldError.getField();
            //获取字段上的校验message
            String message = fieldError.getDefaultMessage();
            map.put(field,message);
        }

        //return R.error(400,"提交的数据不合法").put("data",map);
        //使用枚举类统一代替自己写的状态码与提示信息
        return R.error(BizCodeEnum.VAILD_EXCEPTION.getCode(), BizCodeEnum.VAILD_EXCEPTION.getMsg()).put("data",map);
    }

    //如果其他类型异常匹配不了，就走这个处理方法
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        //return R.error();
        //使用枚举类统一代替自己写的状态码与提示信息
        return R.error(BizCodeEnum.UNKONW_EXCEPTION.getCode(), BizCodeEnum.UNKONW_EXCEPTION.getMsg());
    }

}
