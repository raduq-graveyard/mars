package com.raduq.objects.locations;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by raduq on 17/01/17.
 */
public class DirectionTest {

    @Test
    public void canBeLeft() throws Exception {
        Assert.assertEquals("L",Direction.LEFT.getValue());
    }

    @Test
    public void canBeRight() throws Exception {
        Assert.assertEquals("R",Direction.RIGHT.getValue());
    }

    @Test
    public void canGetValueRight() throws Exception {
        Optional<Direction> direction = Direction.getDirection("R");
        Assert.assertTrue(direction.isPresent());
        Assert.assertEquals(Direction.RIGHT, direction.get());
    }

    @Test
    public void canGetValueLeft() throws Exception {
        Optional<Direction> direction = Direction.getDirection("L");
        Assert.assertTrue(direction.isPresent());
        Assert.assertEquals(Direction.LEFT, direction.get());
    }

    @Test
    public void cantGetValueInvalid() throws Exception {
        Assert.assertFalse(Direction.getDirection("X").isPresent());
    }
}
