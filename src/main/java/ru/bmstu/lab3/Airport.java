package ru.bmstu.lab3;

import java.io.Serializable;

public class Airport implements Serializable {
    private final int id;
    private final String name;

    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
