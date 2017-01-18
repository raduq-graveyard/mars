package com.raduq.service;

import com.raduq.objects.Robot;
import com.raduq.objects.actions.Explorable;
import com.raduq.objects.locations.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by raduq on 18/01/17.
 */
public class Instruction {

    private List<String> commands;

    public Instruction(String command){
        this.commands = getFromString(command);
    }

    private List<String> getFromString(String command) {
        if(command == null || command.isEmpty()){
            throw new RuntimeException("Nenhum comando recebido.");
        }
        return Arrays.asList(command.split(""));
    }

    public Optional<Robot> execute(Robot robot,Explorable planet) {
        return commands.stream().map(cmd -> {
            Optional<Direction> direction = Direction.getDirection(cmd);
            if( direction.isPresent() ) {
                return robot.turn(direction.get());
            }
            if( cmd.equalsIgnoreCase("M")){
                return robot.move(planet);
            }
            throw new RuntimeException("O commando " + cmd + " recebido é inválido.");
        }).reduce((r1,r2) -> r2);
    }
}
