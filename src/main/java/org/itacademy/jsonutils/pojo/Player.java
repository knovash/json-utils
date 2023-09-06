package org.itacademy.jsonutils.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    public String name;
    public String id;
    public Integer volumeStep;
    public Integer volumePrevious;
    public Integer low;
    public Integer high;
    public boolean black;

    public static String pathLast;

    public Player(String name, String id) {
        this.name = name;
        this.id = id;
        this.volumePrevious = 1;
        this.volumeStep = 5;
        this.low = 5;
        this.high = 20;
        this.black = false;
    }


    @Override
    public String toString() {
        return "\nPlayer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", volumeStep=" + volumeStep +
                ", volumePrevious=" + volumePrevious +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) && Objects.equals(getId(), player.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}
