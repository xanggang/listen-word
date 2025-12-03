//package com.listen.interceptor;
//
//import com.common.context.BaseContext;
//import com.common.properties.JwtProperties;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//@Slf4j
//@Component
//public class JWTAdminTokenInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private JwtProperties jwtProperties;
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        BaseContext.setCurrentId(1999L);
//        return true;
////        //判断当前拦截到的是Controller的方法还是其他资源
////        if (!(handler instanceof HandlerMethod)) {
////            //当前拦截到的不是动态方法，直接放行
////            return true;
////        }
////
////        //1、从请求头中获取令牌
////        String token = request.getHeader(jwtProperties.getAdminTokenName());
////
////        if (token == null) {
////            response.setStatus(401);
////            return false;
////        }
////
////        //2、校验令牌
////        try {
////            log.info("jwt校验:{}", token);
////            Claims claims = JwtUtil.parseToken(token);
////            Long id = Long.valueOf(claims.get("id").toString());
////            log.info("当前员工id:{}", id);
////            BaseContext.setCurrentId(id);
////            //3、通过，放行
////            return true;
////        } catch (Exception ex) {
////            //4、不通过，响应401状态码
////            response.setStatus(401);
////            return false;
////        }
//    }
//
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
////        log.info("postHandle:");
//    }
//
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
////        log.info("afterCompletion:");
//    }
//}
