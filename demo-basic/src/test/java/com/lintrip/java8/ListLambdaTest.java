package com.lintrip.java8;

import com.lintrip.java8.domain.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * List Lambda 测试例子
 */
public class ListLambdaTest {

    private List<Student> normalDataList = new ArrayList<>();

    private List<Student> duplicateDataList = new ArrayList<>();


    @Before
    public void setUp(){
        normalDataList.add(new Student("zhangsan", 80));
        normalDataList.add(new Student("lisi", 65));
        normalDataList.add(new Student("wangwu", 55));

        duplicateDataList.add(new Student("zhangsan", 80));
        duplicateDataList.add(new Student("zhangsan", 90));
        duplicateDataList.add(new Student("lisi", 65));
        duplicateDataList.add(new Student("wangwu", 55));
    }

    @Test
    public void testListToMap(){
        Map<String,Student> nameToStudentMap = normalDataList.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
        System.out.println(nameToStudentMap);
        Map<String,Integer> nameToAgeMap = normalDataList.stream().collect(Collectors.toMap(Student::getName,Student::getAge));
        System.out.println(nameToAgeMap);
    }

    /**
     * 重复数据的处理
     */
    @Test
    public void testDuplicateListToMap(){
        Map<String,Student> map = duplicateDataList.stream()
            .collect(Collectors.toMap(Student::getName, Function.identity(),(oldData,newData) -> oldData));
        System.out.println(map);
    }
}
