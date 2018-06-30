package com.github.ericmoshare.adc.enums;

/**
 * 对账状态枚举
 *
 * @author eric.mo
 * @since 2018/5/9
 */
public enum MessageCode {

    success("SUCCESS", "success"),
    paramError("PARAM_ERROR", "param error"),
    systemError("SYSTEM_ERROR", "ststem error"),
    connectionError("CONNECTION_ERROR", "connection error"),
    userError("USER_ERROR", "user error"),
    duplicateUser("DUPLICATE_USER", "duplicate user");

    private final String code;

    private final String message;

    MessageCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static MessageCode findByValue(String code) {

        for (MessageCode index : MessageCode.values()) {
            if (index.getCode().equalsIgnoreCase(code)) {
                return index;
            }
        }
        return null;

    }

}