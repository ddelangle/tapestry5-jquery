package org.got5.tapestry5.jquery.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.tapestry5.services.HttpServletRequestFilter;
import org.apache.tapestry5.services.HttpServletRequestHandler;

public class AjaxUploadServletRequestFilter implements HttpServletRequestFilter {

    private AjaxUploadDecoder decoder;

    public AjaxUploadServletRequestFilter(AjaxUploadDecoder decoder) {

        this.decoder = decoder;
    }

    public boolean service(HttpServletRequest request, HttpServletResponse response, HttpServletRequestHandler handler) throws IOException {

        if (decoder.isAjaxUploadRequest(request)) {
            decoder.setupUploadedFile(request);
        }

        return handler.service(new HttpServletRequestWrapper(request) {
        	@Override
        	public void setCharacterEncoding(String enc)
        			throws UnsupportedEncodingException {
        		try {
        			super.setCharacterEncoding(enc);
        		} catch(Exception e) {
        			
        		}
        	}
        }, response);
    }

}
