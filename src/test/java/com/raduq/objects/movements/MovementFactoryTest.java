package com.raduq.objects.movements;

import com.raduq.objects.locations.Orientation;
import com.raduq.objects.movement.MovementFactory;
import com.raduq.objects.movement.directions.EastMovement;
import com.raduq.objects.movement.directions.NorthMovement;
import com.raduq.objects.movement.directions.SouthMovement;
import com.raduq.objects.movement.directions.WestMovement;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raduq on 17/01/2017.
 */
public class MovementFactoryTest {

    @Test
    public void canGetEast() throws Exception {
        Assert.assertTrue(new MovementFactory().getMovement(Orientation.EAST) instanceof EastMovement);
    }

    @Test
    public void canGetWest() throws Exception {
        Assert.assertTrue(new MovementFactory().getMovement(Orientation.WEST) instanceof WestMovement);
    }

    @Test
    public void canGetNorth() throws Exception {
        Assert.assertTrue(new MovementFactory().getMovement(Orientation.NORTH) instanceof NorthMovement);
    }

    @Test
    public void canGetSouth() throws Exception {
        Assert.assertTrue(new MovementFactory().getMovement(Orientation.SOUTH) instanceof SouthMovement);
    }
}





