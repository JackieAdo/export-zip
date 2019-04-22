package com.ado.exportzip.util.enums;

/**
 * 状态
 *
 * @author Jackie
 **/
public enum StatusEnum {

    /**
     * 启用
     */
    ENABLE(1, "启用"),
    /**
     * 禁用
     */
    DISABLE(2, "禁用");

    private Integer statusValue;

    private String statusType;

    StatusEnum(Integer statusValue, String statusType) {
        this.statusValue = statusValue;
        this.statusType = statusType;
    }

    public Integer getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(Integer statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public static String getStatusType(Integer statusValue) {
        String statusType = "";
        if (statusValue == null) {
            return statusType;
        }
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getStatusValue().equals(statusValue)) {
                return statusEnum.getStatusType();
            }
        }
        return statusType;
    }
}
