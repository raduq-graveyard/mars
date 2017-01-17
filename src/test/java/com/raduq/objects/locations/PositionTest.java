package com.raduq.objects.locations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raduq on 17/01/17.
 */
public class PositionTest {

    @Test
    public void canBeDefault() throws Exception {
        Position position = new Position(0,0);
        Assert.assertEquals(0,position.getX());
        Assert.assertEquals(0,position.getY());
    }

    @Test
    public void canToStringDefault() throws Exception {
        Position position = new Position(0,0);
        Assert.assertEquals("0,0",position.toString());
    }

    @Test
    public void canBeValidAxisX() throws Exception {
        Assert.assertTrue(new Position(0,0).isValidAxisX(5));
    }

    @Test
    public void cantBeValidAxisX() throws Exception {
        Assert.assertFalse(new Position(6,0).isValidAxisX(5));
    }

    @Test
    public void canBeValidAxisY() throws Exception {
        Assert.assertTrue(new Position(0,0).isValidAxisY(5));
    }

    @Test
    public void cantBeValidAxisY() throws Exception {
        Assert.assertFalse(new Position(0,6).isValidAxisY(5));
    }
}
