package com.ado.exportzip.exception;

import com.ado.exportzip.util.enums.ResultEnum;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jinweiwei
 * @date 2018/6/4
 */
@ControllerAdvice
public class GlobalDefultExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalDefultExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public <T> void defultExcepitonHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.info(e.getMessage());
        try {
            response.setCharacterEncoding("utf-8");


            response.setContentType("application/json; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            Map<String, String> map = new HashMap<>(16);
            map.put("code", ResultEnum.UNKONW_ERROR.getCode() + "");
            map.put("msg", "系统异常");

            if (e instanceof BusinessException) {
                logger.error("业务异常：" + e.getMessage(), e);
                BusinessException businessException = (BusinessException) e;
                map.put("msg", businessException.getMsg());
            } else if (e instanceof HttpRequestMethodNotSupportedException) {
                map.put("msg", ResultEnum.REQUEST_METHOD_ERROR.getMsg());
                map.put("code", ResultEnum.REQUEST_METHOD_ERROR.getCode() + "");
            }
            logger.error(e.getMessage(), e);
            writer.append(JSON.toJSONString(map));
            writer.close();
            return;
        } catch (IOException ioE) {
            logger.info(ioE.getMessage());
        }
    }
}
