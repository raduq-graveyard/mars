package com.raduq.objects.movement;

import com.raduq.objects.locations.Position;

/**
 * Created by raduq on 17/01/17.
 */
public interface Movement {

    Position move(Position oldPosition);
}
