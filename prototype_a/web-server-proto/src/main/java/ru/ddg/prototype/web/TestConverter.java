package ru.ddg.prototype.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Natal on 12.04.2016.
 */
@Component
public class TestConverter implements Converter<String, TestEntity> {

    @Override
    public TestEntity convert(String source) {
        return new TestEntity(source, "Converted");
    }
}
