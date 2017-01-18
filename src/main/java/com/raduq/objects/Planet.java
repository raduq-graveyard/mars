package com.raduq.objects;

import com.raduq.exception.MarsException;
import com.raduq.objects.actions.Explorable;
import com.raduq.objects.locations.Position;

/**
 * Representa um planeta.
 * Created by raduq on 17/01/17.
 */
public class Planet implements Explorable{

    private static final int DEFAULT_MAX_X = 5;
    private static final int DEFAULT_MAX_Y = 5;

    private int sizeX;
    private int sizeY;

    public Planet(){
        this.sizeX = DEFAULT_MAX_X;
        this.sizeY = DEFAULT_MAX_Y;
    }

    public Planet(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    /** Valida se a posição recebida é valida. */
    public Planet validatePosition(Position position){
        if(!position.isValidAxisX(this.sizeX)){
            throw new MarsException("Não é possível mover para  a posição X -> " + position.getX() + " - Fora dos limites.");
        }
        if(!position.isValidAxisY(this.sizeY)){
            throw new MarsException("Não é possível mover para  a posição Y -> " + position.getY() + " - Fora dos limites.");
        }
        return this;
    }

}
