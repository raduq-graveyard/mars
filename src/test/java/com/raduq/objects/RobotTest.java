package com.raduq.objects;

import com.raduq.objects.locations.Direction;
import com.raduq.objects.locations.Orientation;
import com.raduq.objects.locations.Position;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raduq on 17/01/17.
 */
public class RobotTest {

    @Test
    public void canCreateInDefaultPosition() throws Exception {
        Robot robot = new Robot();
        Assert.assertEquals("0,0,N",robot.location());
    }

    @Test
    public void canTurnLeftFromDefault(){
        Robot robot = new Robot();
        Assert.assertEquals("0,0,W",robot.turn(Direction.LEFT).location());
    }

    @Test
    public void canTurnRightFromDefault(){
        Robot robot = new Robot();
        Assert.assertEquals("0,0,E",robot.turn(Direction.RIGHT).location());
    }

    @Test
    public void canTurnLeftFromNorth(){
        Robot robot = new Robot(new Position(0,0), Orientation.NORTH);
        Assert.assertEquals("0,0,W",robot.turn(Direction.LEFT).location());
    }

    @Test
    public void canTurnRightFromNorth(){
        Robot robot = new Robot(new Position(0,0), Orientation.NORTH);
        Assert.assertEquals("0,0,E",robot.turn(Direction.RIGHT).location());
    }

    @Test
    public void canTurnLeftFromSouth(){
        Robot robot = new Robot(new Position(0,0), Orientation.SOUTH);
        Assert.assertEquals("0,0,E",robot.turn(Direction.LEFT).location());
    }

    @Test
    public void canTurnRightFromSouth(){
        Robot robot = new Robot(new Position(0,0), Orientation.SOUTH);
        Assert.assertEquals("0,0,W",robot.turn(Direction.RIGHT).location());
    }

    @Test
    public void canTurnLeftFromWest(){
        Robot robot = new Robot(new Position(0,0), Orientation.WEST);
        Assert.assertEquals("0,0,S",robot.turn(Direction.LEFT).location());
    }

    @Test
    public void canTurnRightFromWest(){
        Robot robot = new Robot(new Position(0,0), Orientation.WEST);
        Assert.assertEquals("0,0,N",robot.turn(Direction.RIGHT).location());
    }

    @Test
    public void canTurnLeftFromEast(){
        Robot robot = new Robot(new Position(0,0), Orientation.EAST);
        Assert.assertEquals("0,0,N",robot.turn(Direction.LEFT).location());
    }

    @Test
    public void canTurnRightFromEast(){
        Robot robot = new Robot(new Position(0,0), Orientation.EAST);
        Assert.assertEquals("0,0,S",robot.turn(Direction.RIGHT).location());
    }

    @Test
    public void canMove() throws Exception {
        Robot robot = new Robot();
        Assert.assertEquals("0,1,N", robot.move().location());
    }
}
