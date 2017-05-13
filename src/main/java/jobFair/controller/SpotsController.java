/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobFair.controller;

import java.util.List;
import jobFair.model.JobFairData;
import jobFair.model.Spot;
import jobFair.model.Users;
import jobFair.service.JobFairDataService;
import jobFair.service.SpotService;
import jobFair.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private JobFairDataService jobFairDataService;
    
    @GetMapping("/spots")
    public ModelAndView getSpotsList() {
        ModelAndView model = new ModelAndView("spotoverview");
        List<Spot> spots = spotService.findAll();
        model.addObject("spots", spots);
        return model;
    }
    
    @GetMapping("/freespots")
    public String getFreeSpots(Model model) {
        List<Spot> spots = spotService.freeSpots();
        model.addAttribute("spots", spots);
        return "spotoverview";
    }
    
    @GetMapping("/takenspots")
    public String getTakenSpots(Model model) {
        List<Spot> spots = spotService.takenSpots();
        model.addAttribute("spots", spots);
        return "spotoverview";
    }
    
    @GetMapping("/sorttakenspots")
    public String getSortedTakenSpots(Model model) {
        List<Spot> spots = spotService.sortTakenSpots();
        model.addAttribute("spots", spots);
        return "spotoverview";
    }
    
    
    @GetMapping("/fill")
    public String fillDatabase() {
        this.createData();
        return "login";
    }
    
    
    public void createData() {
        spotService.save(new Spot("!", 2,3,true,"cool", null));
        spotService.save(new Spot("2", 1,1,false,"oh yeah!", null));
        
        usersService.save(new Users("Name", "Company", "email@gmail.com", "user", "pass", "", "COMPANY", null));
   
        Users user = new Users();
        user.setPassword("admin");
        user.setRole("ADMIN");
        user.setUsername("admin");
        user.setSalt("");
        user.setCompanyName("admin");
        user.setContactName("admin");
        user.setEmail("Email@gmail.com");
        usersService.save(user);
        
        jobFairDataService.save(new JobFairData("Job fair", "2017","", null));
        

    }
    
}
