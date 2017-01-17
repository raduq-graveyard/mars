package com.raduq.objects.actions;

import com.raduq.objects.locations.Direction;
import com.raduq.objects.locations.Orientation;
import com.raduq.objects.locations.Position;

/**
 * Métodos caracteristicos de objetos que podem se girar em um Explorable.
 * Created by raduq on 17/01/17.
 */
public interface Turnable {

    /**
     * Gira o objeto para a direção especificada.
     */
    Turnable turn(Direction direction);
}
