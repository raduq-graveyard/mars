package com.raduq.objects.locations;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by raduq on 17/01/17.
 */
public class OrientationTest {

    @Test
    public void canBeNorth() throws Exception {
        Assert.assertEquals("N",Orientation.NORTH.getValue());
    }

    @Test
    public void canBeSouth() throws Exception {
        Assert.assertEquals("S",Orientation.SOUTH.getValue());
    }

    @Test
    public void canBeWest() throws Exception {
        Assert.assertEquals("W",Orientation.WEST.getValue());
    }

    @Test
    public void canBeEast() throws Exception {
        Assert.assertEquals("E",Orientation.EAST.getValue());
    }

    @Test
    public void canNorthTurnLeft() throws Exception {
        Assert.assertEquals(Orientation.WEST, Orientation.NORTH.turn(Direction.LEFT));
    }

    @Test
    public void canNorthTurnRight() throws Exception {
        Assert.assertEquals(Orientation.EAST, Orientation.NORTH.turn(Direction.RIGHT));
    }

    @Test
    public void canSouthTurnLeft() throws Exception {
        Assert.assertEquals(Orientation.EAST, Orientation.SOUTH.turn(Direction.LEFT));
    }

    @Test
    public void canSouthTurnRight() throws Exception {
        Assert.assertEquals(Orientation.WEST, Orientation.SOUTH.turn(Direction.RIGHT));
    }

    @Test
    public void canEastTurnLeft() throws Exception {
        Assert.assertEquals(Orientation.NORTH, Orientation.EAST.turn(Direction.LEFT));
    }

    @Test
    public void canEastTurnRight() throws Exception {
        Assert.assertEquals(Orientation.SOUTH, Orientation.EAST.turn(Direction.RIGHT));
    }

    @Test
    public void canWestTurnLeft() throws Exception {
        Assert.assertEquals(Orientation.SOUTH, Orientation.WEST.turn(Direction.LEFT));
    }

    @Test
    public void canWestTurnRight() throws Exception {
        Assert.assertEquals(Orientation.NORTH, Orientation.WEST.turn(Direction.RIGHT));
    }

    @Test
    public void canGetNorth() throws Exception {
        Optional<Orientation> orientation = Orientation.getOrientation("N");
        Assert.assertTrue(orientation.isPresent());
        Assert.assertEquals(Orientation.NORTH,orientation.get());
    }

    @Test
    public void canGetSouth() throws Exception {
        Optional<Orientation> orientation = Orientation.getOrientation("S");
        Assert.assertTrue(orientation.isPresent());
        Assert.assertEquals(Orientation.SOUTH,orientation.get());
    }

    @Test
    public void canGetWest() throws Exception {
        Optional<Orientation> orientation = Orientation.getOrientation("W");
        Assert.assertTrue(orientation.isPresent());
        Assert.assertEquals(Orientation.WEST,orientation.get());
    }

    @Test
    public void canGetEast() throws Exception {
        Optional<Orientation> orientation = Orientation.getOrientation("E");
        Assert.assertTrue(orientation.isPresent());
        Assert.assertEquals(Orientation.EAST,orientation.get());
    }

    @Test
    public void cantGetInvalid() throws Exception {
        Optional<Orientation> orientation = Orientation.getOrientation("X");
        Assert.assertFalse(orientation.isPresent());
    }
}
