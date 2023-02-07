package org.east.laugh.app.controller;


import org.east.laugh.app.domain.User;
import org.east.laugh.app.exception.BusinessException;
import org.east.laugh.app.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
//    @ExceptionHandler(SystemException.class)
//    public Result<User> doSystemException(SystemException ex){
//        return new Result<>(null,ex.getCode(),ex.getMessage());
//    }
//
//    @ExceptionHandler(BusinessException.class)
//    public Result<User> doSystemException(BusinessException ex){
//        return new Result<>(null,ex.getCode(),ex.getMessage());
//    }
    @ExceptionHandler(Exception.class)
    public Result<User> doException(Exception ex){
        System.out.println("嘿嘿，小异常~");
        return new Result<>(null,Code.UNKNOWN_ERR,ex.getLocalizedMessage());
    }

}
