package com.github.ericmoshare.adc.webapp.vo;

import com.github.ericmoshare.adc.enums.MessageCode;
import lombok.Data;
import lombok.ToString;

/**
 * @author eric.mo
 * @since 2018/6/30
 */
@Data
@ToString
public class Resp {

    private String respCode;
    private String respMsg;
    private Object data;

    public Resp() {
    }

    public Resp(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public Resp(String respCode, String respMsg, Object data) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.data = data;
    }

    public Resp(MessageCode messageCode) {
        this.respCode = messageCode.getCode();
        this.respMsg = messageCode.getMessage();
    }

    public Resp(String message, MessageCode messageCode) {
        this.respCode = messageCode.getCode();
        this.respMsg = message;
    }

    public Resp(MessageCode messageCode, Object data) {
        this.respCode = messageCode.getCode();
        this.respMsg = messageCode.getMessage();
        this.data = data;
    }

    public Resp(MessageCode messageCode, String message, Object data) {
        this.respCode = messageCode.getCode();
        this.respMsg = message;
        this.data = data;
    }

}
