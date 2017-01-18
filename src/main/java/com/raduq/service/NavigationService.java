package com.raduq.service;

import com.raduq.objects.Planet;
import com.raduq.objects.Robot;
import com.raduq.objects.actions.Placeable;
import com.raduq.objects.locations.Direction;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe de serviços para a navegação do robo.
 * Created by raduq on 17/01/17.
 */
@Service
public class NavigationService {

    public String navigate(String command){
        Planet planet = new Planet();
        Robot robot = new Robot();
        Instruction instruction = new Instruction(command);

        Optional<Robot> finalRobot = instruction.execute(robot,planet);
        if(!finalRobot.isPresent()){
            throw new RuntimeException("Movimentação inválida");
        }
        return finalRobot.get().location();
    }

}
