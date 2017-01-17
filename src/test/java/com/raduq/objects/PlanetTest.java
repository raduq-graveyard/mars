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
        Robot robot = new Robot().move(planet);
        planet.validatePosition(robot.getPosition());
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
                .move(planet)
                .move(planet)
                .move(planet)
                .move(planet);
        planet.validatePosition(robot.getPosition());
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
                    .move(planet)
                    .move(planet)
                    .move(planet)
                    .move(planet)
                    .move(planet);
            planet.validatePosition(robot.getPosition());
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
                .move(planet)
                .turn(Direction.RIGHT)
                .move(planet);
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
                    .move(planet)
                    .turn(Direction.LEFT)
                    .move(planet);
            planet.validatePosition(robot.getPosition());
        }catch(Exception e){
            Assert.assertEquals("Não é possível mover para  a posição X -> -1 - Fora dos limites.", e.getMessage());
            throw e;
        }
    }

    @Test
    public void canMoveNorthFromDefaultLargePlanet100x100() throws Exception {
        Planet planet = new Planet(100,100); //max 100,100
        Robot robot = new Robot(); //0,0,N
        for(int y = 1; y < 100 ; y++){
            Assert.assertEquals("0,"+y+",N",robot.move(planet).location());
        }
    }

    @Test
    public void canMoveEastFromDefaultLargePlanet100x100() throws Exception {
        Planet planet = new Planet(100,100); //max 100,100
        Robot robot = new Robot(); //0,0,N
        robot.turn(Direction.RIGHT);
        for(int x = 1; x < 100 ; x++){
            Assert.assertEquals(x+",0,E",robot.move(planet).location());
        }
    }
}
