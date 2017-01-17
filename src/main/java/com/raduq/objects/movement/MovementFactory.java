package com.raduq.objects.movement;

import com.raduq.objects.locations.Orientation;
import com.raduq.objects.movement.directions.EastMovement;
import com.raduq.objects.movement.directions.NorthMovement;
import com.raduq.objects.movement.directions.SouthMovement;
import com.raduq.objects.movement.directions.WestMovement;

/**
 * Created by raduq on 17/01/17.
 */
public class MovementFactory {

    public Movement getMovement(Orientation orientation){
        switch (orientation){
            case NORTH: return new NorthMovement();
            case SOUTH: return new SouthMovement();
            case EAST: return new EastMovement();
            case WEST: return new WestMovement();
            default: throw new RuntimeException("Orientação de movimento inválida");
        }
    }
}
