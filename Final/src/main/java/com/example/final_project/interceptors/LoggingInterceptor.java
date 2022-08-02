package com.example.final_project.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

public class LoggingInterceptor implements HandlerInterceptor {
    private final Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("PREHANDLE");
        LOG.info(request.getRequestURL() + " " + request.getMethod());
        Iterator<String> iter = request.getHeaderNames().asIterator();
        while (iter.hasNext()) {
            String headerName = iter.next();
            String headerValue = request.getHeader(headerName);
            LOG.info(headerName + ": " + headerValue);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("POSTHANDLE");
        if (modelAndView == null) {
            return;
        }
        for (String entry : modelAndView.getModel().keySet()) {
            LOG.info(entry + ": " + modelAndView.getModel().get(entry));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("AFTERCOMPLETION");
        if (ex != null) {
            ex.printStackTrace();
        }
        response.setStatus(200);
    }
}
