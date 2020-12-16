package com.lintrip.java8;

import com.lintrip.java8.domain.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 函数 Predicate 测试用例
 */
public class PredicateTest {

    @Test
    public void testPredicate() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("zhangsan", 80));
        students.add(new Student("lisi", 65));
        students.add(new Student("wangwu", 55));
        // 匿名内部类写法
        List<Student> afterFilter1 = filter(students, new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAge() > 60;
            }
        });
        // 带参、返回值的 lambda 表达式写法
        List<Student> afterFilter2 = filter(students, (Student s) -> {
            return s.getAge() > 60;
        });
        // 简化版的 lambda 表达式写法
        List<Student> afterFilter3 = filter(students, s -> s.getAge() > 60);
        System.out.println(afterFilter1);
        System.out.println(afterFilter2);
        System.out.println(afterFilter3);
    }

    /**
     * 过滤满足给定条件的学生信息
     *
     * @param studentList
     * @param predicate
     * @return
     */
    public List<Student> filter(List<Student> studentList, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (predicate.test(student)) {
                result.add(student);
            }
        }
        return result;
    }

    @Test
    public void test01() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("zhangsan", 80));
        students.add(new Student("lisi", 65));
        students.add(new Student("wangwu", 55));
        students.add(new Student("maliu", 98));
        // 简化版的 lambda 表达式写法
        List<Student> afterFilter3 = students.stream().filter(s -> s.getAge() > 60).sorted(Comparator.comparingDouble(Student::getAge)).collect(Collectors.toList());
        System.out.println(afterFilter3);
    }

}
