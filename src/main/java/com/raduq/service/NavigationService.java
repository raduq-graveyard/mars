package com.raduq.service;

import com.raduq.objects.Planet;
import com.raduq.objects.Robot;
import com.raduq.objects.locations.Direction;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Classe de serviços para a navegação do robo.
 * Created by raduq on 17/01/17.
 */
@Service
public class NavigationService {

    public String navigate(String command){
        Planet planet = new Planet();
        Robot robot = new Robot();
        List<String> commandList = separateCommands(command);
        Optional<Robot> movedRobot = commandList.stream().map(cmd -> {
            Optional<Direction> direction = Direction.getDirection(cmd);
            return direction.isPresent() ? robot.turn(direction.get()) : robot.move(planet);
        }).reduce((r1,r2) -> r2);
        return movedRobot.get().location();
    }

    /** Separa um commando string em uma lista de commandos. */
    private List<String> separateCommands(String command) {
        return Arrays.asList(command.split(""));
    }
}
