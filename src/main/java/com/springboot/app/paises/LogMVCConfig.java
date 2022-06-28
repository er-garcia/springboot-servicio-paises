package com.springboot.app.paises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.app.paises.models.service.LogConsultasRequestInterceptor;

//WebMvcConfigurer agrega LogConsultasRequestInterceptor dentro del ciclo de vida de Spring MVC al invocar el método addInterceptors().
@Configuration
public class LogMVCConfig implements WebMvcConfigurer {
	
	@Autowired
    private LogConsultasRequestInterceptor LogRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(LogRequestInterceptor)
          .addPathPatterns("/api/v1/*/");
    }

}
