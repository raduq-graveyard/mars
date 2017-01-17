package com.raduq.objects.actions;

/**
 * Métodos caracteristicos de objetos que podem se movimentar em um Explorable.
 * Created by raduq on 17/01/17.
 */
public interface Movable {

    /**
     * Move o objeto para frente em um explorable, na direção que ele estiver.
     */
    Movable move(Explorable explorable);
}
