package com.commom.utils;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * 获取请求参数
 */
public class WebUtil {
    public static ThreadLocal<HttpServletRequest> REQUEST = new NamedThreadLocal<HttpServletRequest>(
            "ThreadLocalRequest");

    /**
     * 获取 text/html 请求参数
     * @param request
     * @return
     */
    public static Map<String, Object> getParameters(ServletRequest request) {
        Map<String, Object> params = null;
        if (request != null) {
            //是html/text
            params = WebUtils.getParametersStartingWith(request, null);
        }
        return params;
    }

    /**
     * 获取 application/json 参数
     * @param request
     * @return
     */
    public static String getParametersJson(ServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        String body = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            char[] charBuffer = new char[128];
            int bytesRead = -1;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                stringBuilder.append(charBuffer, 0, bytesRead);
            }
        } catch (IOException ex) {
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                }
            }
        }
        body = stringBuilder.toString();
        return body;
    }

    public static String readPostJsonData(HttpServletResponse response) throws IOException
    {
        String result="";
        if (response instanceof ContentCachingResponseWrapper){
            ContentCachingResponseWrapper responseWrapper = (ContentCachingResponseWrapper) response;
            int contentSize = ((ContentCachingResponseWrapper) response).getContentSize();
            if (contentSize > 0) {
                byte[] bytes = new byte[contentSize];
                InputStream is = responseWrapper.getContentInputStream();
                for (int i = 0; i < contentSize; i++){
                    int value = is.read();
                    if (value == -1){
                        //is.reset();
                        break;
                    }
                    bytes[i] = (byte) value;
                }
                responseWrapper.getContentAsByteArray();//这里是为了测试
                result= new String(bytes);
            }
        }
        return result;
    }

    /**
     * 将ErrorStack转化为String.
     */
    public static String getStackTraceAsString(Throwable e) {
        if (e == null){
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        //e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
