package com.ado.exportzip.util;

import com.ado.exportzip.util.enums.ResultEnum;

/**
 * @author jinweiwei
 * @date 2018/6/4
 */
public class ResultUtil {

    /**
     * 当正确时返回的值
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    /**
     * 当错误时返回的值
     * @param code
     * @param msg
     * @return
     */
    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static Result error(ResultEnum resultEnum, String message) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(message);
        return result;
    }

}
