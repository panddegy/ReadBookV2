package com.biz.book.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		
		CharacterEncodingFilter filter=new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		return new Filter[] {filter};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		
		return new Class[] {AppServletConfig.class, MybatisConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		
		return new String[] {"/"};
	}

	
}
