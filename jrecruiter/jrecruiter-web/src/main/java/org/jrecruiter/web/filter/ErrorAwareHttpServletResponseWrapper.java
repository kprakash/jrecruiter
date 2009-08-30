package org.jrecruiter.web.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ErrorAwareHttpServletResponseWrapper extends HttpServletResponseWrapper {

     int errorCode;

     public ErrorAwareHttpServletResponseWrapper(HttpServletResponse httpServletResponse) {
            super(httpServletResponse);
     }

     @Override
    public void sendError(int errorCode) throws IOException {
        this.errorCode = errorCode;
        super.sendError(errorCode);
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

}
