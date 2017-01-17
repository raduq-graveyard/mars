package com.raduq.objects.actions;

/**
 * Métodos caracteristicos de objetos que podem se movimentar em um Explorable.
 * Created by raduq on 17/01/17.
 */
public interface Movable <R> {

    /**
     * Move o objeto para frente em 1 terreno, na direção que ele estiver.
     */
    R move();
}
