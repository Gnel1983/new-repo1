package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;

    }


    @Override
    protected String[] getServletMappings() {

        String[] mappings = {"/"};
        return mappings;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] configFiles = {MyAppConfiguration.class};

        return configFiles;
    }
}
