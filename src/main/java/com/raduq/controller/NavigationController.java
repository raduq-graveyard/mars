package com.raduq.controller;

import com.raduq.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Interface rest para a navegação do robo.
 * Created by raduq on 17/01/17.
 */
@RestController
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    public ResponseEntity ping(){
        return ResponseEntity.ok().body("PONG");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/mars/{command}")
    public ResponseEntity navigate(@PathVariable("command") String command) {
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(navigationService.navigate(command));
    }
}
