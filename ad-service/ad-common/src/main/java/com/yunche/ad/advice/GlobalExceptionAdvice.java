package com.yunche.ad.advice;

import com.yunche.ad.exception.AdExecption;
import com.yunche.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理自定义的异常
 * @author yunche
 * @date 2019/03/19
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    public CommonResponse<String> handlerAdException(HttpServletRequest request, AdExecption ex) {
        CommonResponse<String> response = new CommonResponse<>(-1, "服务器忙，请稍后~");
        response.setData(ex.getMessage());
        return response;
    }
}
