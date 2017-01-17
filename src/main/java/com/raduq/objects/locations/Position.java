package com.raduq.objects.locations;

import java.util.Objects;

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
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Adiciona +1 à posicao X.
     */
    public Position plusX() {
        this.x += 1;
        return this;
    }

    /**
     * Adiciona +1 à posicao Y.
     */
    public Position plusY() {
        this.y += 1;
        return this;
    }

    /**
     * Remove -1 da posicao X.
     */
    public Position minusX() {
        this.x -= 1;
        return this;
    }

    /**
     * Remove -1 da posicao Y.
     */
    public Position minusY() {
        this.y -= 1;
        return this;
    }

    /**
     * Valida se a posicao X é valida de acordo com um valor máximo recebido.
     */
    public boolean isValidAxisX(int maxX) {
        return isValidAxis(x, maxX);
    }

    /**
     * Valida se a posicao Y é valida de acordo com um valor máximo recebido.
     */
    public boolean isValidAxisY(int maxY) {
        return isValidAxis(y, maxY);
    }

    /**
     * Valida se a posicao 'N' é valida de acordo com um valor máximo recebido.
     */
    private boolean isValidAxis(int n, int maxN) {
        return n >= 0 && n < maxN;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.valueOf(x) + "," + String.valueOf(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
