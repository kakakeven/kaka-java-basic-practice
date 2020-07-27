package com.lintrip.java8;

import com.lintrip.java8.domain.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Stream 排序
 */
public class SortTest {

    private List<Student> studentList;

    @Before
    public void setUp() {
        studentList = new ArrayList<>();
        studentList.add(new Student("zhangsan", 80));
        studentList.add(new Student("lisi", 65));
        studentList.add(new Student("wangwu", 55));
    }

    /**
     * 使用匿名函数
     */
    @Test
    public void sortByFunction() {
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() > o2.getScore() ? 1 : -1;
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
        studentList.sort((o1, o2) -> o1.getScore() > o2.getScore() ? 1 : -1);
        studentList.stream().forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void sortByCompare() {
        Collections.sort(studentList,Comparator.comparing(Student::getScore));
        studentList.stream().forEach(student -> {
            System.out.println(student);
        });
    }
}
