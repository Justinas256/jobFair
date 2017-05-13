/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobFair.controller;

import java.util.List;
import jobFair.model.LoginData;
import jobFair.model.Spot;
import jobFair.service.LoginDataService;
import jobFair.service.SpotService;
import jobFair.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author justinas
 */
@Controller
public class SpotsController {
    
    @Autowired
    private SpotService spotService;
    
    @Autowired
    private UsersService usersService;
    
     @Autowired
    private LoginDataService loginDataService;
    
    @GetMapping("/spots")
    public ModelAndView getSpotsList() {
        ModelAndView model = new ModelAndView("spotoverview");
        List<Spot> spots = spotService.findAll();
        model.addObject("spots", spots);
        return model;
    }
    
    
    @GetMapping("/fill")
    public String fillDatabase() {
        this.createData();
        return "login";
    }
    
    
    public void createData() {
        spotService.save(new Spot("!", 2,3,true,"cool"));
        spotService.save(new Spot("2", 1,1,false,"oh yeah!"));
        
        loginDataService.save(new LoginData("adminm", "admin", "", "ADMIN"));
        
    }
    
    
}
