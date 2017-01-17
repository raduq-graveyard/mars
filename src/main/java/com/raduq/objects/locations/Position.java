package com.raduq.objects.locations;

/**
 * Representa uma posição em um terreno.
 * Created by raduq on 17/01/17.
 */
public class Position {

    private int x;
    private int y;

    /**
     * Cria uma posicao com os valores recebidos.
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Adiciona +1 à posicao X.
     */
    public Position plusX(){
        this.x += 1;
        return this;
    }

    /**
     * Adiciona +1 à posicao Y.
     */
    public Position plusY(){
        this.y += 1;
        return this;
    }

    /**
     * Remove -1 da posicao X.
     */
    public Position minusX(){
        this.x -= 1;
        return this;
    }

    /**
     * Remove -1 da posicao Y.
     */
    public Position minusY(){
        this.y -= 1;
        return this;
    }

    public boolean isValidAxisX(int maxX){
        return isValidAxis(x,maxX);
    }

    public boolean isValidAxisY(int maxY){
        return isValidAxis(y,maxY);
    }

    private boolean isValidAxis(int n, int maxN){
        return n >= 0 && n < maxN;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return String.valueOf(x) + "," + String.valueOf(y);
    }
}
