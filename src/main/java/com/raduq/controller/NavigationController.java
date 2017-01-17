package com.raduq.controller;

import com.raduq.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Interface rest para a navegação do robo.
 * Created by raduq on 17/01/17.
 */
@RestController
@RequestMapping(value = "/rest")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    public ResponseEntity ping(){
        return ResponseEntity.ok().body("PONG");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/mars/{command}")
    public ResponseEntity navigate(@PathVariable String command) {
        try {
            return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(navigationService.navigate(command));
        } catch (Exception e) {
            return ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
        }
    }
}
