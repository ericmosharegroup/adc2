package com.github.ericmoshare.adc.exception;

import com.github.ericmoshare.adc.enums.MessageCode;

/**
 * @author eric.mo
 * @since 2018/6/30
 */
public class AdcException extends Exception {

    private static final long serialVersionUID = 7882201535453604217L;

    private MessageCode messageCode = MessageCode.connectionError;

    public AdcException() {
        super();
    }

    public AdcException(String message) {
        super(message);
    }

    public AdcException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdcException(Throwable cause) {
        super(cause);
    }

    public AdcException(MessageCode messageCode) {
        super();
        this.messageCode = messageCode;
    }

    public AdcException(MessageCode messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
    }

    public AdcException(String message, Throwable cause, MessageCode messageCode) {
        super(message, cause);
        this.messageCode = messageCode;
    }

    public MessageCode getResponse() {
        return messageCode;
    }

}
