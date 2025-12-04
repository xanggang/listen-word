package com.listen.config;

import com.common.json.JacksonObjectMapper;
import com.common.properties.ConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Component
@Configurable
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

//    @Autowired
//    private JWTAdminTokenInterceptor jwtTokenAdminInterceptor;
//
//    @Autowired
//    private JwtTokenUserInterceptor jwtTokenUserInterceptor;

    @Autowired
    private ConfigProperties configProperties;

    /**
     * 注册自定义拦截器
     * @param registry
     */
//    protected void addInterceptors(InterceptorRegistry registry) {
//        log.info("开始注册自定义拦截器...");
//        registry.addInterceptor(jwtTokenAdminInterceptor)
//                .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin/login");
//
//        registry.addInterceptor(jwtTokenUserInterceptor)
//                .addPathPatterns("/user/**")
//                .excludePathPatterns("/user/user/login")
//                .excludePathPatterns("/user/shop/status");
//    }


//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 将物理路径 "file:D:/uploads/" 映射为 Web 访问路径 "/uploads/**":cite[6]
//        log.info("开始设置静态资源映射...");
//        log.info("代理地址{}", "file:" + configProperties.getUploadPath());
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:" + configProperties.getUploadPath()); // "file:" 表示指向本地文件系统:cite[6]
//    }


    /**
     * 扩展Spring MVC框架的消息转化器
     * @param converters
     */
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器...");
        //创建一个消息转换器对象
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        //需要为消息转换器设置一个对象转换器，对象转换器可以将Java对象序列化为json数据
        converter.setObjectMapper(new JacksonObjectMapper());
        //将自己的消息转化器加入容器中
        converters.add(0,converter);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 配置针对哪些接口路径
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
