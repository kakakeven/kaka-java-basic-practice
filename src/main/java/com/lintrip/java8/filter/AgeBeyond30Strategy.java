package com.lintrip.java8.filter;

import com.lintrip.java8.domain.Employee;

public class AgeBeyond30Strategy implements CustomPredictStrategy<Employee> {
    @Override
    public boolean match(Employee o) {
        return o.getAge() > 30;
    }
}
