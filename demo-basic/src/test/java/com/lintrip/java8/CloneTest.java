package com.lintrip.java8;

import com.lintrip.java8.domain.EmployeeDetail;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author gyt
 * @date 2022/9/13 14:48
 */
public class CloneTest {

    @Test
    public void testClone() throws CloneNotSupportedException {
        EmployeeDetail e1 = new EmployeeDetail();
        e1.setId(1);
        e1.setAge(20);
        e1.setName("拉布拉多");
        e1.setSalary(1000);

        EmployeeDetail e2 = (EmployeeDetail) e1.clone();
        e2.setId(2);
        Assert.assertFalse(e2.getId() == e1.getId());
        Assert.assertFalse(e2.getAge().equals(e1.getAge()));
    }

}
