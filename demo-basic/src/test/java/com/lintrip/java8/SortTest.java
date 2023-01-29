package com.lintrip.java8;

import com.lintrip.java8.domain.Employee;
import com.lintrip.java8.domain.Student;
import javafx.scene.control.TreeTableView;
import org.apache.commons.collections.MapUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stream 排序
 */
public class SortTest {

    private List<Student> studentList;

    private List<Employee> employeeList;

    @Before
    public void setUp() {
        studentList = new ArrayList<>();
        studentList.add(new Student("zhangsan", 80));
        studentList.add(new Student("wangwu", 55));
        studentList.add(new Student("lisi", 65));

        employeeList = new ArrayList<>();
        employeeList.add(new Employee("zhangsan", 80, 1300));
        employeeList.add(new Employee("lisi", 80, 1300));
        employeeList.add(new Employee("wangwu", 70, 1300));
        employeeList.add(new Employee("maliu", 80, 1200));
    }

    @Test
    public void multiSort() {
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() != o2.getSalary()) {
                    return o1.getSalary() > o2.getSalary() ? -1 : 1;
                }
                if (o1.getAge() != o2.getAge()) {
                    return o1.getAge() > o2.getAge() ? -1 : 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        employeeList.stream().forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void testSuitSort() {
        List<Map<String, Object>> suitsList = new ArrayList<>();
        suitsList.add(createSuitMap(3,1,1));
        suitsList.add(createSuitMap(3,1,3));
        suitsList.add(createSuitMap(3,0,1));
        suitsList.add(createSuitMap(5,0,0));
        suitsList.sort((o1, o2) -> {
            if (!MapUtils.getInteger(o1, "unitPrice").equals(MapUtils.getInteger(o2, "unitPrice"))) {
                return MapUtils.getInteger(o1, "unitPrice") > MapUtils.getInteger(o2, "unitPrice") ? 1 : -1;
            }
            if (!MapUtils.getInteger(o1, "payAutoRenew").equals(MapUtils.getInteger(o2, "payAutoRenew"))) {
                return MapUtils.getInteger(o1, "unitPrice") > MapUtils.getInteger(o2, "unitPrice") ? -1 : 1;
            }
            return MapUtils.getInteger(o1, "amount") > MapUtils.getInteger(o2, "amount") ? -1 : 1;
        });
        System.out.println(suitsList.get(0));
    }

    private Map<String, Object> createSuitMap(Integer unitPrice,Integer payAutoRenew,Integer amount) {
        Map<String, Object> map = new HashMap<>();

        map.put("unitPrice",unitPrice);
        map.put("payAutoRenew",payAutoRenew);
        map.put("amount",amount);

        return map;
    }

    @Test
    public void test() {
        Collections.sort(studentList, (o1, o2) -> (o1.getAge() > o2.getAge()) ? -1 : 1);
        System.out.println(studentList.get(1));
    }

    /**
     * 使用匿名函数
     */
    @Test
    public void sortByFunction() {
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() > o2.getAge() ? 1 : -1;
            }
        });
        studentList.stream().forEach(student -> {
            System.out.println(student);
        });
    }

    /**
     * 使用 Lambda 进行排序
     */
    @Test
    public void sortByLambda() {
        studentList.sort((o1, o2) -> o1.getAge() > o2.getAge() ? 1 : -1);
        studentList.stream().forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void sortByCompare() {
        Collections.sort(studentList, Comparator.comparing(Student::getAge));
        studentList.stream().forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void compute() {
        double a = 9.345;
        double b = a % 3;

        double d = 10 / 3;
        System.out.println(b);
        System.out.println(d);
    }

    @Test
    public void test1() {
        int a = 1;
        int b = 2;
        System.out.println(++a);
//        System.out.println(b++);
        int c = b + 2;
        System.out.println(c);

        boolean isA = true;
        boolean isB = false;
        boolean isC = true;
        System.out.println(isA ^ isB);
        System.out.println(isA ^ isC);
    }
}
