package com.ado.exportzip.exception;

import com.ado.exportzip.util.enums.ResultEnum;

/**
 *
 * @author jinweiwei
 * @date 2018/6/4
 */
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    public BusinessException() {}

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.msg = resultEnum.getMsg();
        this.code = resultEnum.getCode();
    }

    public BusinessException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException(String msg){
        super(msg);
        this.msg = msg;
        this.code = ResultEnum.UNKONW_ERROR.getCode();
    }
}
