package com.asiainfo.objectMappertest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectMapperDemo {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readValue("<asdasd>", JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
