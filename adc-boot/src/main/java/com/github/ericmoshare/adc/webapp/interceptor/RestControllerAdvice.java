package com.github.ericmoshare.adc.webapp.interceptor;

import com.github.ericmoshare.adc.enums.MessageCode;
import com.github.ericmoshare.adc.exception.AdcException;
import com.github.ericmoshare.adc.webapp.vo.Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestControllerAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerAdvice.class);

    /**
     * Controller 所有异常捕获
     *
     * @param request
     * @param throwable
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Resp> error(HttpServletRequest request, Throwable throwable) {
        Resp resp = new Resp();

        ResponseEntity<Resp> responseEntity = null;

        // 请求参数错误返回
        if (throwable instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) throwable;
            LOGGER.error("Invalid arguments {}", e.getMessage());
            StringBuilder message = new StringBuilder();
            message.append(e.getBindingResult().getErrorCount()).append(" error(s): ");
            for (ObjectError error : e.getBindingResult().getAllErrors()) {
                if (error instanceof FieldError) {
                    FieldError fieldError = (FieldError) error;
                    message.append("[").append(fieldError.getField()).append("=").append(fieldError.getRejectedValue())
                            .append(",").append(error.getDefaultMessage()).append("]");
                } else {
                    message.append("[").append(error.getDefaultMessage()).append("]");
                }
            }
            return new ResponseEntity<Resp>(new Resp(MessageCode.paramError, message.toString()), HttpStatus.OK);

        } else if (throwable instanceof AdcException) {
            AdcException e = (AdcException) throwable;
            LOGGER.error("catch AdcException {}", e.getMessage());

            return new ResponseEntity<Resp>(new Resp(e.getMessage(), e.getResponse()), HttpStatus.OK);

        }

        // 系统出错返回
        LOGGER.error("Undefined exception, {}", throwable.getMessage(), throwable);
        return new ResponseEntity<Resp>(new Resp(MessageCode.systemError), HttpStatus.OK);
    }

    @Override
    public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
        // TODO 自动生成的方法存根
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }
}
