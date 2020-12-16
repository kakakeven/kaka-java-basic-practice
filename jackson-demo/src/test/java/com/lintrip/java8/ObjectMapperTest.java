package com.lintrip.java8;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.lintrip.java8.domain.Student;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Jackson ObjectMapper 使用
 */
public class ObjectMapperTest {

    @Test
    public void testWriteJson() throws JsonProcessingException {
        Student student = new Student("Jack",90);
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(result);
    }

    @Test
    public void readJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue("{\"name\":\"Jack\",\"age\":30}",Student.class);
        System.out.println(student);

        List<Student> studentList = objectMapper.readValue("[{\"name\":\"Jack\",\"age\":20},{\"name\":\"Tom\",\"age\":30}]", new TypeReference<List<Student>>() {});
        System.out.println(studentList);
    }

    @Test
    public void readJsonConfig01() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 如果 json 中包含未知的属性，不抛出异常
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Student student = objectMapper.readValue("{\"name\":\"Jack\",\"age\":30,\"sex\":1}",Student.class);
        System.out.println(student);
    }

    @Test
    public void testWriteJsonConfig01() throws JsonProcessingException {
        Student student = new Student("Jack",90);
        ObjectMapper objectMapper = new ObjectMapper();
        // 如果属性值为 null，则返回结果中不包含对应属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(result);
    }

    @Test
    public void testWriteJsonConfig02() throws JsonProcessingException {
        Student student = new Student("Jack",90);
        ObjectMapper objectMapper = new ObjectMapper();
        // 忽略值为默认值的属性，比如 int 默认为 0
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(result);
    }

    @Test
    public void testWriteJsonConfig03() throws JsonProcessingException {
        Student student = new Student("Jack",30);
        student.setBirthDay(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        // 忽略值为默认值的属性，比如 int 默认为 0
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(result);
    }

    @Test
    public void testWriteJsonConfig04() throws JsonProcessingException {
        Student student = new Student("Jack",30);
        student.setBirthDay(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(StdDateFormat.getDateTimeInstance());
        // 忽略值为默认值的属性，比如 int 默认为 0
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(result);
    }

    @Test
    public void testWriteJsonConfig05() throws JsonProcessingException {
        Student student = new Student("Jack",30);
        student.setBirthDay(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(StdDateFormat.getDateTimeInstance());
        // 忽略值为默认值的属性，比如 int 默认为 0
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(result);
    }
}
