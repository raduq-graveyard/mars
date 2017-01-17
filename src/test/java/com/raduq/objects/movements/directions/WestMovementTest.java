package com.raduq.objects.movements.directions;

import com.raduq.objects.locations.Orientation;
import com.raduq.objects.locations.Position;
import com.raduq.objects.movement.Movement;
import com.raduq.objects.movement.MovementFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raduq on 17/01/2017.
 */
public class WestMovementTest {

    @Test
    public void canMove() throws Exception {
        MovementFactory factory = new MovementFactory();
        Movement movement = factory.getMovement(Orientation.WEST);
        Assert.assertEquals(new Position(0,0), movement.move(new Position(1,0)));
    }
}
