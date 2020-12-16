package com.lintrip.java8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Jackson JsonNode 测试
 */
public class JsonNodeTest {

    @Test
    public void readJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode treeNode = objectMapper.readTree("{\"name\":\"Jack\",\"age\":90}");
        int age =  treeNode.get("age").asInt();
        Assert.assertEquals(90,age);
    }
}
