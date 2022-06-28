package com.springboot.app.paises.models.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Component
public class LogConsultasRequestInterceptor implements HandlerInterceptor{

	/*
	 * Para evitar que se genere un error despues de leer el flujo de entrada por primera vez (la aplicación lanzará una excepción) 
	 * se puede aprovechar el almacenamiento en caché para almacenar el flujo de solicitudes y usarlo para el registro. 
	 * Se ajusta el preHandle() de esta clase para almacenar en caché el objeto de solicitud
	 * usando la clase ContentCachingRequestWrapper
	 */

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    	HttpServletRequest requestCacheWrapperObject = new ContentCachingRequestWrapper(request);
    	requestCacheWrapperObject.getParameterMap();
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, 
      HttpServletResponse response, Object handler, 
      Exception ex) {
        //
    }
	
}
