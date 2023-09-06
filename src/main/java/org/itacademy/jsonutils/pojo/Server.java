package org.itacademy.jsonutils.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {

    public List<Player> players;
    public Integer counter;

    @Override
    public String toString() {
        return "Server{" +
                "players=" + players +
                ", counter=" + counter +
                '}';
    }
}
