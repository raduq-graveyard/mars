package com.raduq.objects.locations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Representa uma orientação norte/sul/leste/oeste. <br/>
 * Cada orientação tem a direção caso uma curva seja feita.
 * Created by raduq on 17/01/17.
 */
public enum Orientation {

    NORTH("N") {
        /** No norte, virando para esquerda vai para oeste... virando para direita vai para leste. */
        @Override
        public Orientation turn(Direction direction) {
            return Direction.LEFT.equals(direction) ? WEST : EAST;
        }
    },
    SOUTH("S"){
        /** No sul, virando para esquerda vai para leste... virando para direita vai para oeste. */
        @Override
        public Orientation turn(Direction direction) {
            return Direction.LEFT.equals(direction) ? EAST : WEST;
        }
    },
    EAST("E"){
        /** No leste, virando para esquerda vai para norte... virando para direita vai para sul. */
        @Override
        public Orientation turn(Direction direction) {
            return Direction.LEFT.equals(direction) ? NORTH : SOUTH;
        }
    },
    WEST("W"){
        /** No oeste, virando para esquerda vai para sul... virando para direita vai para norte. */
        @Override
        public Orientation turn(Direction direction) {
            return Direction.LEFT.equals(direction) ? SOUTH : NORTH;
        }
    };

    private String value;

    Orientation(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<Orientation> getOrientation(String value){
        List<Orientation> allValues = Arrays.asList(values());
        return allValues.stream().filter(vl -> vl.value.equals(value)).findFirst();
    }

    public abstract Orientation turn(Direction direction);

}
