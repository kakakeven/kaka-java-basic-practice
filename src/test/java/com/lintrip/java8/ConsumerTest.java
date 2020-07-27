package com.lintrip.java8;

import com.lintrip.java8.domain.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer 函数测试用例
 */
public class ConsumerTest {

    @Test
    public void testConsumer(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("zhangsan", 80));
        students.add(new Student("lisi", 65));
        students.add(new Student("wangwu", 55));
        foreach(students,s -> s.setName(s.getName().toUpperCase()));
        System.out.println(students);
    }

    public void foreach(List<Student> studentList, Consumer<Student> consumer) {
        for (Student student:studentList) {
            consumer.accept(student);
        }
    }
}
