package com.lintrip.java8.filter;

import com.lintrip.java8.domain.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * 雇员过滤
 */
public class EmployeeFilter {

    /**
     * 过滤掉年龄小于 目标年
     *
     * @param originList
     * @param targetAge
     * @return
     */
    public static List<Employee> filterEmployeeUnderTargetAge(List<Employee> originList, Integer targetAge) {
        List<Employee> target = new ArrayList<>();
        for (Employee e : originList) {
            if (e.getAge() > targetAge) {
                target.add(e);
            }
        }
        return target;
    }

    /**
     * 过滤掉收入低于 4500 元
     *
     * @param originList
     * @return
     */
    public static List<Employee> filterEmployeeUnderTargetSalary(List<Employee> originList, double targetSalary) {
        List<Employee> target = new ArrayList<>();
        for (Employee e : originList) {
            if (e.getSalary() > targetSalary) {
                target.add(e);
            }
        }
        return target;
    }

    /**
     * 返回符合策略条件的对象
     *
     * @param originList
     * @param strategy
     * @return
     */
    public static List<Employee> filterEmployee(List<Employee> originList, CustomPredictStrategy<Employee> strategy) {
        List<Employee> target = new ArrayList<>();
        for (Employee e : originList) {
            if (strategy.match(e)) {
                target.add(e);
            }
        }
        return target;
    }
}
