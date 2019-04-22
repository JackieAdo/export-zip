package com.ado.exportzip.util.enums;

/**
 * @author jinweiwei
 * @date 2018/6/4
 */
public enum ResultEnum {
    /**
     * 返回对象code，返回msg
     */
    UNKONW_ERROR(2000, "服务器内部错误"),
    SUCCESS(1000, "成功"),
    REQUIRED_PARAMETER_MISSING(2100, "缺少必要的参数"),
    USER_ERROR(3000, "用户异常"),
    SAVE_FAILED(2200, "保存失败"),
    REQUEST_METHOD_ERROR(2300, "请求方法不支持");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
