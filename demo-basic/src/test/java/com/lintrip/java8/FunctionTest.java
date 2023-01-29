package com.lintrip.java8;

import com.lintrip.java8.domain.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Function 函数测试用例
 */
public class FunctionTest {

    @Test
    public void testFunction() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("zhangsan", 80));
        students.add(new Student("lisi", 65));
        students.add(new Student("wangwu", 55));
        List<String> nameList1 = map(students, new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        });
        List<String> nameList2 = map(students, (Student s) -> {
            return s.getName();
        });
        List<String> nameList3 = map(students, s -> s.getName());
        // 方法引用的写法
        List<String> nameList4 = map(students, Student::getName);
        System.out.println(students.stream().map(Student::getName).limit(5).collect(Collectors.toList()));
        System.out.println(nameList1);
        System.out.println(nameList2);
        System.out.println(nameList3);
        System.out.println(nameList4);
    }

    public List<String> map(List<Student> studentList, Function<Student, String> function) {
        List<String> dataList = new ArrayList<>();
        for (Student student : studentList) {
            dataList.add(function.apply(student));
        }
        return dataList;
    }

}
