package org.itacademy.jsonutils;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.itacademy.jsonutils.pojo.Player;
import org.itacademy.jsonutils.pojo.ServerLMS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main2 {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

    public static void main(String[] args) throws IOException {
        System.out.printf("Hello and welcome!");
        System.out.printf("\n");


        List<Player> players = new ArrayList<>();
        ServerLMS server1 = new ServerLMS();

        players.add(new Player("mibox", "111"));
        players.add(new Player("ggmm", "222"));
        players.add(new Player("homepod", "333"));

        server1.players = players;
//        server1.counter = 3;

        System.out.println("\nSERVER1 POJO:\n" + server1);

        String serverjson = JsonUtils.pojoToJson(server1);

        System.out.println(serverjson);

        ServerLMS sss = JsonUtils.jsonToPojo(serverjson, ServerLMS.class);

        System.out.println(sss);

    }
}