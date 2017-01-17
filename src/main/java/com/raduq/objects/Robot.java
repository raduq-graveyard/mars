package com.raduq.objects;

import com.raduq.objects.actions.Explorable;
import com.raduq.objects.actions.Placeable;
import com.raduq.objects.locations.Direction;
import com.raduq.objects.locations.Orientation;
import com.raduq.objects.locations.Position;
import com.raduq.objects.actions.Movable;
import com.raduq.objects.actions.Turnable;
import com.raduq.objects.movement.MovementFactory;

/**
 * Representa um robô que anda no planeta.
 * Created by raduq on 17/01/17.
 */
public class Robot implements Movable, Turnable, Placeable {
    private Position position;
    private Orientation orientation;

    /** Cria o robô na posição default (0,0,N). */
    public Robot(){
        this.position = new Position(0,0);
        this.orientation = Orientation.NORTH;
    }

    /** Cria o robô com posições e orientação especificados. */
    public Robot(Position position,Orientation orientation){
        this.position = position;
        this.orientation = orientation;
    }

    /**
     * Move o robô uma posição para a orientação atual.
     * @return instancia de robô movida para a posição.
     */
    public Robot move(Explorable explorable){
        MovementFactory movementFactory = new MovementFactory();
        Position newPosition = movementFactory.getMovement(this.orientation).move(this.position);
        explorable.validatePosition(newPosition);
        this.position = newPosition;
        return this;
    }

    /**
     * Vira o robo para a nova direção e retorna a orientação atual do robô.
     * @param direction - nova direção do robô, podendo ser esquerda ou direita.
     * @return nova orientação do robo.
     */
    public Robot turn(Direction direction){
        this.orientation = orientation.turn(direction);
        return this;
    }

    /** Retorna uma posicao com valores de X e Y. */
    public Position getPosition(){
        return this.position;
    }

    /** Retorna a orientacao do objeto em Norte, Sul, Leste ou Oeste **/
    public Orientation getOrientation(){
        return this.orientation;
    }

}
