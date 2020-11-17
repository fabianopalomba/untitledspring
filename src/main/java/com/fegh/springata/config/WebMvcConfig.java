package com.fegh.springata.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.fegh.springata")
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/css");
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
/*
	@Bean
	public LocalValidatorFactoryBean validator(){
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages");
		return resource;
	}
	@Override
	public Validator getValidator(){
		return validator();
	}
*/
}
