package com.bsuir.max.hotel.specification;

import java.util.List;

public interface Specification {
    String toSql();

    List<Object> getParameters();
}
