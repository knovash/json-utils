package org.itacademy.jsonutils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.itacademy.jsonutils.pojo.CatalogItem;
import org.itacademy.jsonutils.pojo.Server;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtilsTyped {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

    public static String pojoToJson(Server pojo) throws JsonProcessingException {
      return objectMapper.writeValueAsString(pojo);
    }

    public static Server jsonToPojo(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Server.class);
    }

    public static String listToJson(List<CatalogItem> list) throws JsonProcessingException {
        return objectMapper.writeValueAsString(list);
    }

    public static List<CatalogItem> jsonToList(String json) throws JsonProcessingException {
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, CatalogItem.class);
       return objectMapper.readValue(json, type);
    }

    public static void pojoToJsonFile(Server pojo, String fileName) throws IOException {
        File file = new File(fileName);
        objectWriter.writeValue(file, pojo);
    }

    public static void listToJsonFile(List<CatalogItem> list, String fileName) throws IOException {
        File file = new File(fileName);
        objectWriter.writeValue(file, list);
    }

    public static Server jsonFileToPojo(String fileName) throws IOException {
        File file = new File(fileName);
        return objectMapper.readValue(file, Server.class);

    }

    public static List<CatalogItem> jsonFileToList(String fileName) throws IOException {
        File file = new File(fileName);
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, CatalogItem.class);
        return objectMapper.readValue(file, type);
    }


}
