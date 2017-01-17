package com.raduq.objects;

import com.raduq.objects.locations.Direction;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testes de Planet.
 * Created by raduq on 17/01/17.
 */
public class PlanetTest {

    @Test
    public void canCreatePlanetDefault() throws Exception {
        Assert.assertNotNull(new Planet());
    }

    @Test
    public void canCreatePlanet1x1() throws Exception {
        Assert.assertNotNull(new Planet(1,1));
    }

    /**
     * Movendo de :
     *  _ _ _ _ _
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |^|_|_|_|_|
     *
     * Para:
     *   _ _ _ _ _
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |^|_|_|_|_|
     *  |_|_|_|_|_|
     *
     *  Resultado: movimento valido - X0,Y1,East (0,1,N)
     */
    @Test
    public void canAcceptMoveNorthX1() throws Exception {
        Planet planet = new Planet();
        Robot robot = new Robot().move();
        planet.validateMove(robot.getPosition());
        Assert.assertEquals("0,1,N",robot.location());
    }

    /**
     * Movendo de :
     *  _ _ _ _ _
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |^|_|_|_|_|
     *
     * Para:
     *   _ _ _ _ _
     *  |^|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *
     *  Resultado: movimento valido - X0,Y4,East (0,4,N)
     */
    @Test
    public void canAcceptMoveNorthX4() throws Exception {
        Planet planet = new Planet();
        Robot robot = new Robot()
                .move()
                .move()
                .move()
                .move();
        planet.validateMove(robot.getPosition());
        Assert.assertEquals("0,4,N",robot.location());
    }

    /**
     * Movendo de :
     *  _ _ _ _ _
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |^|_|_|_|_|
     *
     * Para:
     *
     *   ^ _ _ _ _
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *
     *  Resultado: movimento inválido - fora dos limites.
     */
    @Test(expected = RuntimeException.class)
    public void cantAcceptMoveNorthX5() throws Exception {
        try {
            Planet planet = new Planet();
            Robot robot = new Robot()
                    .move()
                    .move()
                    .move()
                    .move()
                    .move();
            planet.validateMove(robot.getPosition());
        }catch(Exception e){
            Assert.assertEquals("Não é possível mover para  a posição Y -> 5 - Fora dos limites.", e.getMessage());
            throw e;
        }
    }

    /**
     * Movendo de :
     *  _ _ _ _ _
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |^|_|_|_|_|
     *
     * Para:
     *   _ _ _ _ _
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|>|_|_|_|
     *  |_|_|_|_|_|
     *
     *  Resultado: movimento valido - X1,Y1,East (1,1,E)
     */
    @Test
    public void canMoveNorth1East1() throws Exception {
        Planet planet = new Planet(); //max 5,5
        Robot robot = new Robot() //0,0,N
                .move()
                .turn(Direction.RIGHT)
                .move();
        planet.validateMove(robot.getPosition());
        Assert.assertEquals("1,1,E",robot.location());
    }

    /**
     * Movendo de :
     *  _ _ _ _ _
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |_|_|_|_|_|
     * |^|_|_|_|_|
     *
     * Para:
     *   _ _ _ _ _
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     *  |_|_|_|_|_|
     * <|_|_|_|_|_|
     *  |_|_|_|_|_|
     *
     *  Resultado: movimento inválido - fora dos limites.
     */
    @Test(expected = RuntimeException.class)
    public void cantMoveNorth1West1FromDefault() throws Exception {
        try{
            Planet planet = new Planet(); //max 5,5
            Robot robot = new Robot() //0,0,N
                    .move()
                    .turn(Direction.LEFT)
                    .move();
            planet.validateMove(robot.getPosition());
        }catch(Exception e){
            Assert.assertEquals("Não é possível mover para  a posição X -> -1 - Fora dos limites.", e.getMessage());
            throw e;
        }
    }
}
