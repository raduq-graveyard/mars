package com.raduq.objects.movement;

import com.raduq.objects.locations.Position;

/**
 * Representa uma movimentação de uma posição a outra.
 * Created by raduq on 17/01/17.
 */
public interface Movement {

    /** Move algo de uma posição a outra. */
    Position move(Position oldPosition);
}
