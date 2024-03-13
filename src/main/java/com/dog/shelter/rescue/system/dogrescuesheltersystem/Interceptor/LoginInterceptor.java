package com.dog.shelter.rescue.system.dogrescuesheltersystem.Interceptor;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.utils.JwtUtils;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String url = request.getRequestURL().toString();
        log.info("Request URL: {}", url);

        if (url.contains("login")){
            return true;
        }

        String jwt = request.getHeader("token");


        if (!StringUtils.hasLength(jwt)){
            log.info("Token is empty, return un-login");
            Result error = Result.error("NOT_LOGIN");
            response.sendError(404, "NOT_LOGIN");
            return false;
        }

        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(404, "NOT_LOGIN");
            log.info("Failed in parsing JWT");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Interceptor post-handling...");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Interceptor after-handling...");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
