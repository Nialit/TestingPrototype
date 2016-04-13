package ru.ddg.prototype.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by Natal on 12.04.2016.
 */
@Accessors
@ToString
@AllArgsConstructor
public class TestEntity {

    public final String value, comment;

}
