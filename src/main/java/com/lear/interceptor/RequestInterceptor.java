package com.lear.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * 请求拦截器
 * @author 天狗
 */
@Slf4j
@Component
public class RequestInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<Long> startTimeThreadLocal =
            new NamedThreadLocal<Long>("ThreadLocal StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (log.isDebugEnabled()) {
            long beginTime = System.currentTimeMillis();//1、开始时间
            startTimeThreadLocal.set(beginTime);        //线程绑定变量（该数据只有当前请求的线程可见）
            log.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
                    .format(beginTime), request.getRequestURI());
        }

        // 访问uri
        log.info("访问后端: {}", request.getRequestURI());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 打印JVM信息
        if (log.isDebugEnabled()) {
            // 删除线程变量中的数据，防止内存泄漏
            startTimeThreadLocal.remove();
        }
    }
}
