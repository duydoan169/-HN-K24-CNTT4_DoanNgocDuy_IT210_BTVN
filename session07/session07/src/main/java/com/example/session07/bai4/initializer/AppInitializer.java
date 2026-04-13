package com.example.session07.bai4.initializer;
import com.example.session07.config.AppConfiguration;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        String uploadDir = "C:/RikkeiFood_Temp/";
        long maxFileSize = 2 * 1024 * 1024;
        long maxRequestSize = 2 * 1024 * 1024;
        int fileSizeThreshold = 0;

        MultipartConfigElement config =
                new MultipartConfigElement(uploadDir, maxFileSize, maxRequestSize, fileSizeThreshold);

        registration.setMultipartConfig(config);
    }
}