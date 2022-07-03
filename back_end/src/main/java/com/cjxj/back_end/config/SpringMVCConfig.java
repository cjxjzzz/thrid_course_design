package com.cjxj.back_end.config;

import com.cjxj.back_end.filter.FilterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

@SuppressWarnings("deprecation")
@SpringBootConfiguration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private FilterConfig filterConfig;

    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(filterConfig);
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns(
                "/images/**" ,        //图片
                "/video/**"          //视频
        );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 资源映射路径
         * addResourceHandler：访问映射路径
         * addResourceLocations：资源绝对路径
         */
        // 保存文件的路径
        String url = System.getProperty("user.dir") + "\\images\\";
        File folder = new File(url);
        String str = folder.toString().replace("\\","/");
//        System.out.println(str);
//        registry.addResourceHandler("/images/**").addResourceLocations("file:/var/www/springBoot/images/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+str+"/");

        // 保存视频的路径
        url = System.getProperty("user.dir") + "\\video\\";
        folder = new File(url);
        str = folder.toString().replace("\\","/");
//        System.out.println(str);
//        registry.addResourceHandler("/images/**").addResourceLocations("file:/var/www/springBoot/images/");
        registry.addResourceHandler("/video/**").addResourceLocations("file:"+str+"/");
    }
}
