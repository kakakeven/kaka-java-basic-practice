package com.lintrip.java8;

import com.lintrip.java8.domain.Employee;
import com.lintrip.java8.filter.AgeBeyond30Strategy;
import com.lintrip.java8.filter.CustomPredictStrategy;
import com.lintrip.java8.filter.EmployeeFilter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    List<Employee> employees = Arrays.asList(new Employee("张三", 58, 3333.33),
            new Employee("李四", 38, 4444.44),
            new Employee("王五", 28, 5555.55),
            new Employee("马六", 48, 6666.66));


    @Test
    public void testComparator() {
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() > o2.getAge() ? 1 : -1;
            }
        });
        printAll(employees);
    }

    @Test
    public void testLambdaComparator() {
        Collections.sort(employees, (o1, o2) -> o1.getAge() > o2.getAge() ? 1 : -1);
        printAll(employees);
    }

    @Test
    public void testFilterHelper() {
        // 过滤掉 30 岁以下的雇员
        List<Employee> employeeAgeBeyond30 = EmployeeFilter.filterEmployeeUnderTargetAge(employees, 30);
        printAll(employeeAgeBeyond30);
        System.out.println("--------------");
        List<Employee> employeeSalaryBeyond4500 = EmployeeFilter.filterEmployeeUnderTargetSalary(employees, 4500);
        printAll(employeeSalaryBeyond4500);
    }

    @Test
    public void testFilterStrategy() {
        // 策略模式的实现
        List<Employee> employeeAgeBeyond30 = EmployeeFilter.filterEmployee(employees, new AgeBeyond30Strategy());
        printAll(employeeAgeBeyond30);
        System.out.println("--------------");
        // 匿名内部类的实现
        List<Employee> employeeSalaryBeyond4500 = EmployeeFilter.filterEmployee(employees, new CustomPredictStrategy<Employee>() {
            @Override
            public boolean match(Employee o) {
                return o.getSalary() > 4500;
            }
        });
        printAll(employeeSalaryBeyond4500);
    }

    @Test
    public void testLambdaFilter() {
        // 策略模式的实现
        List<Employee> employeeAgeBeyond30 = EmployeeFilter.filterEmployee(employees, (x) -> x.getAge() > 30);
        printAll(employeeAgeBeyond30);
        System.out.println("--------------");
        // 终极的 Stream 模式
        employees.stream().filter((x) -> x.getAge() > 30).forEach(System.out::println);
    }

    private void printAll(List<Employee> employees) {
        employees.stream().forEach(System.out::println);
    }
}
