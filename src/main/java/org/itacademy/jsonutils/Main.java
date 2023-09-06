package org.itacademy.jsonutils;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.itacademy.jsonutils.pojo.CatalogItem;
import org.itacademy.jsonutils.pojo.Player;
import org.itacademy.jsonutils.pojo.Server;
import org.itacademy.jsonutils.pojo.ServerLMS;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

    public static void main(String[] args) throws IOException {
        System.out.printf("Hello and welcome!");
        System.out.printf("\n");


        List<Player> players = new ArrayList<>();
        ServerLMS server1 = new ServerLMS();
        ServerLMS server2 = new ServerLMS();

        players.add(new Player("mibox", "111"));
        players.add(new Player("ggmm", "222"));
        players.add(new Player("homepod", "333"));

        server1.players = players;
//        server1.counter = 3;

        System.out.println("\nSERVER1 POJO:\n" + server1);
        System.out.println("\nSERVER2 POJO:\n" + server2);

        // POJO to JSON
        String server1Json = objectMapper.writeValueAsString(server1);
        System.out.println("\nSERVER1 JSON:\n" + server1Json);

        // JSON to POJO
        server2 = objectMapper.readValue(server1Json, ServerLMS.class);
        System.out.println("\nSERVER2 POJO:\n" + server2);

        List<CatalogItem> itemsList1 = new ArrayList<>();
        List<CatalogItem> itemsList2 = new ArrayList<>();

        itemsList1.add(new CatalogItem("iphone", "apple"));
        itemsList1.add(new CatalogItem("mibox", "xiaomi"));
        itemsList1.add(new CatalogItem("matebook", "huawei"));
        System.out.println("\nITEMS1 LIST:\n" + itemsList1);

        // LIST to JSON
        String items1Json = objectMapper.writeValueAsString(itemsList1);
        System.out.println("\nITEMS1 JSON:\n" + items1Json);

        // https://habr.com/ru/companies/otus/articles/687004/
        // https://ru.stackoverflow.com/questions/442233/Как-собрать-jacksonом-дерево-из-потока
        TypeFactory.defaultInstance().constructCollectionType(List.class, CatalogItem.class);

        // JSON to LIST
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, CatalogItem.class);
        itemsList2 = objectMapper.readValue(items1Json, type);
        System.out.println("\nITEMS2 LIST:\n" + itemsList2);

        // POJO to JSON file
        File fileItems = new File("itemsnew.json");
        File fileServer = new File("servernew.json");
        objectWriter.writeValue(fileItems, itemsList2);
        objectWriter.writeValue(fileServer, server2);

        // JSON file to POJO
        Server server3 = objectMapper.readValue(fileServer, Server.class);
        System.out.println("\nSERVER3 POJO from JSON file\n" + server3);

        // JSON file to LIST
        itemsList2 = objectMapper.readValue(fileItems, type);
        System.out.println("\nITEMS LISY from JSON file\n" + itemsList2);

        System.out.println("\n----------------------------\n");

//        String serverJson4 = JsonUtilsServer.pojoToJson(server2);
//        System.out.println("\nJSON\n" + serverJson4);
//
//        Server server5 = JsonUtilsServer.jsonToPojo(serverJson4);
//        System.out.println("\nPOJO\n" + server5);
//
//        String itemsJson5 = JsonUtilsServer.listToJson(itemsList2);
//        System.out.println("\nJSON\n" + itemsJson5);
//
//        itemsList2 = JsonUtilsServer.jsonToList(items1Json);
//        System.out.println("\nJSON\n" + itemsList2);
//
//        JsonUtilsServer.pojoToJsonFile(server2, "server2.json");
//
//        JsonUtilsServer.listToJsonFile(itemsList1, "items3.json");
//
//        Server server7 = JsonUtilsServer.jsonFileToPojo("server2.json");
//        System.out.println("\nPOJO\n" + server7);
//
//        List<CatalogItem> itemList4= JsonUtilsServer.jsonFileToList("items3.json");
//        System.out.println("\nLIST\n" + itemList4);

        System.out.println("\n----------------------------\n");

        String serverJson24 = JsonUtils.pojoToJson(server2);
        System.out.println("\nJSON\n" + serverJson24);

        Server server55 = JsonUtils.jsonToPojo(serverJson24, Server.class);
        System.out.println("\nPOJO\n" + server55);

        String itemsJson45 = JsonUtils.listToJson(itemsList2);
        System.out.println("\nJSON\n" + itemsJson45);

        itemsList2 = JsonUtils.jsonToList(items1Json, CatalogItem.class);
        System.out.println("\nJSON\n" + itemsList2);

        JsonUtils.pojoToJsonFile(server2, "server2.json");

        JsonUtils.listToJsonFile(itemsList1, "items3.json");

        Server server37 = JsonUtils.jsonFileToPojo("server2.json", Server.class);
        System.out.println("\nPOJO\n" + server37);

        List<CatalogItem> itemList34= JsonUtils.jsonFileToList("items3.json", CatalogItem.class);
        System.out.println("\nLIST\n" + itemList34);

    }
}