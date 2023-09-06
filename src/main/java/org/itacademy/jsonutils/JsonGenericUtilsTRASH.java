package org.itacademy.jsonutils;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
//import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;
import org.itacademy.jsonutils.pojo.CatalogItem;
import org.itacademy.jsonutils.pojo.Server;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Log4j2
public class JsonGenericUtilsTRASH {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static CatalogItem itemJsonFileToPojo() throws IOException {
        File file = new File("src/test/resources/items.json");
        CatalogItem o = objectMapper.readValue(file, CatalogItem.class);
        return o;
    }

    public static Server serverJsonFileToPojo() throws IOException {
        File file = new File("src/test/resources/server.json");
        Server o = objectMapper.readValue(file, Server.class);
        return o;
    }

    public static String getJsonFromFile(String path, String fileName) {
        String jsonData = null;
        URL resourceItems = JsonGenericUtilsTRASH.class.getClassLoader().getResource(path + fileName);
        File jsonFile = new File(Objects.requireNonNull(resourceItems).getFile());
        log.info("JSON FILE: " + jsonFile);
//        try {
//            jsonData = new JsonParser().parse(new java.io.FileReader(file)).toString();
////            jsonData = new JsonParser().parse(new java.io.FileReader(jsonFile)).toString();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        log.info("JSON DATA: " + jsonData);
        return jsonData;
    }

    public static <T> ArrayList<T> getListFromJson(String jsonData, Class<T> clazz) {
        ArrayList<Object> list;
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
        log.info("CLASS: " + clazz.getTypeName());
        log.info("TYPE: " + type);
        try {
            list = objectMapper.readValue(jsonData, type);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        log.info("LIST: " + list);
        return (ArrayList<T>) list;
    }

    public static void setObjectToFile(Object object, String fileName) {
        File file = new File("src/main/resources/data/" + fileName);
        try {
            file.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(file, object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}