package com.raduq.objects.movement.directions;

import com.raduq.objects.locations.Position;
import com.raduq.objects.movement.Movement;

/**
 * Movimentação para sul.
 * Created by raduq on 17/01/17.
 */
public class SouthMovement implements Movement {

    @Override
    public Position move(Position oldPosition) {
        return oldPosition.minusY();
    }
    
}
