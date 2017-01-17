package com.raduq.objects.actions;

import com.raduq.objects.locations.Orientation;
import com.raduq.objects.locations.Position;

/**
 * Representam objetos que podem ser colocados em um terreno, em posições X e Y.
 * Created by raduq on 17/01/2017.
 */
public interface Placeable {

    String LOCATION_SEPARATOR = ",";

    /** Retorna uma posicao com valores de X e Y. */
    Position getPosition();

    /** Retorna a orientacao do objeto em Norte, Sul, Leste ou Oeste **/
    Orientation getOrientation();

    /** Retorna um local em string.*/
    /** Retorna um local em string.*/
    default String location(){
        return getPosition().toString() + LOCATION_SEPARATOR + getOrientation().getValue();
    }
}
