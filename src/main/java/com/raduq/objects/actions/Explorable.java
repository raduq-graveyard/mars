package com.raduq.objects.actions;

import com.raduq.objects.locations.Position;

/**
 * Métodos caracteristicos de classes que podem ter movimentos feitos (interface Movable).
 * Created by raduq on 17/01/17.
 */
public interface Explorable {

    /**
     * Valida se a Position recebia pode ser aplicada no terreno. <br/>
     * Caso ela extrapole os limites máximos, deve lancar exception.
     */
    Explorable validatePosition(Position position);
}
