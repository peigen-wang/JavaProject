package com.commom.filter;

import com.alibaba.fastjson.JSON;
import com.commom.utils.WebUtil;
import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);
    private StringBuffer content = new StringBuffer();
    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StartTime-EndTime");

    /**
     * 该方法将在请求处理之前进行调用。
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求路劲
        String url = request.getRequestURI();
        //获取请求参数信息
        String requestParams = JSON.toJSONString(WebUtil.getParameters(request));
        String requestBody = WebUtil.getParametersJson(request);
        //获取请求客户都IP
        String clientIp = request.getRemoteAddr();
        //请求方法
        String methodName = request.getMethod();
        content = new StringBuffer();
        content.append("url=" + url);
        content.append(" ,requestParams=").append(requestParams);
        content.append(" ,requestBody=").append(requestBody);
        content.append(", clientIp=").append(clientIp);
        content.append(" ,HttpMethod=").append(methodName);
        startTimeThreadLocal.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    /**
     * 在当前请求进行处理之后，也就是Controller 方法调用之后执行，但是它会在DispatcherServlet 进行视图返回渲染之前被调用，所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。这个方法的主要作用是用于进行资源清理工作的。
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        final Long startTime = startTimeThreadLocal.get();
        final Long endTime = System.currentTimeMillis();
        Long takeTime = endTime - startTime;
        content.append(" ,takeTime=" + takeTime);
        if (ex != null) {
            logger.debug("controller异常：" + WebUtil.getStackTraceAsString(ex));
        }
        String responseBody = String.valueOf(request.getAttribute("response"));
        content.append(" ,response=" + responseBody);
        logger.info(content.toString());
        System.out.println(content.toString());
        startTimeThreadLocal.remove();
        super.afterCompletion(request, response, handler, ex);
    }


}
