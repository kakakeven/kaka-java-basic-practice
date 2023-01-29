package com.lintrip.java8;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.lintrip.java8.domain.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author gyt
 * @date 2022/9/28 17:19
 */
public class BeanToMapTest {

    public Employee employee = new Employee();

    @Before
    public void setUp() {
        employee.setAge(11);
        employee.setName("天下第二");
        employee.setSalary(10000);
    }

    @Test
    public void testHutool() {
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> result = BeanUtil.beanToMap(employee);
        }
    }

    @Test
    public void testFastJson() {
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> result = JSON.parseObject(JSON.toJSONString(employee));
        }
    }

}
