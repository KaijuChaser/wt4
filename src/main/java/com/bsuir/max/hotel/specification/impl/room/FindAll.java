package com.bsuir.max.hotel.specification.impl.room;

import com.bsuir.max.hotel.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindAll implements Specification {

    @Override
    public String toSql() {
        return "";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.emptyList();
    }
}
