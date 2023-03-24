package com.sazibkhan.backhandspringboot.dto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface I18NService {
    public String getMessage(String code);

    public String getMultipleMessage(List<String> codes);

    public String getMultipleMessageFromHeader(List<String> codes, HttpServletRequest request);

    public byte[] getBytes(String code);

    public HttpServletRequest getRequest();

}

