package org.itacademy.jsonutils.pojo;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ServerLMS {

    public ServerLMS() {

    }

    public List<Player> players;
//    public Integer counter;

    @Override
    public String toString() {
        return "ServerLMS{" +
                "players=" + players +
//                ", counter=" + counter +
                '}';
    }
}
