/**
 * 
 */
package com.poc.pet.cms.app.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author Eraine
 *
 */
@Configuration
public class WebConfig {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

	  return new EmbeddedServletContainerCustomizer() {
	    @Override
	    public void customize(ConfigurableEmbeddedServletContainer container)       
	    {
	      ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.html");
	      ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
	      ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");

	      container.addErrorPages(error401Page, error404Page, error500Page);
	    }
	  };
	}
}
