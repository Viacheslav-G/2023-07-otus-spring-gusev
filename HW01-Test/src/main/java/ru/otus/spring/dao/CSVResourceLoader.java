package ru.otus.spring.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;

public class CSVResourceLoader implements ResourceLoader {

    private String fileName;

    public CSVResourceLoader() {
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Resource getResource() {
        return new ClassPathResource(fileName, this.getClassLoader());

    }

    @Override
    public Resource getResource(String location) {
        return new ClassPathResource(location, this.getClassLoader());

    }

    @Override
    public ClassLoader getClassLoader() {
        return ClassUtils.getDefaultClassLoader();
    }
}
