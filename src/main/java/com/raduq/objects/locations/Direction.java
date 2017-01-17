package com.raduq.objects.locations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Direções disponíveis para girar (Turnable).
 * Created by raduq on 17/01/17.
 */
public enum Direction {

    /** Esquerda */
    LEFT("L"),

    /** Direita */
    RIGHT("R");

    String value;

    Direction(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<Direction> getDirection(String value){
        List<Direction> allValues = Arrays.asList(values());
        return allValues.stream().filter(vl -> vl.value.toLowerCase().equals(value.toLowerCase())).findFirst();
    }
}
