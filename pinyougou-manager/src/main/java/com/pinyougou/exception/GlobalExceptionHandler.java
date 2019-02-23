package com.pinyougou.exception;

import com.pinyougou.common.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(GlobalException.class)
	public Result handleRRException(GlobalException e){
		Result result = new Result();
		result.put("code", e.getCode());
		result.put("msg", e.getMessage());
		return result;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Result handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return Result.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthenticationException.class)
	public Result handleAuthorizationException(AuthenticationException e){
		logger.error(e.getMessage(), e);
		return Result.error(HttpStatus.FORBIDDEN.value(),e.getMessage());
	}

}
