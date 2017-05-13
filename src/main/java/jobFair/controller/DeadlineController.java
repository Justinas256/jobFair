/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobFair.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jobFair.model.Spot;
import jobFair.service.JobFairDataService;
import jobFair.service.SpotService;
import jobFair.utils.StringToCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author justinas
 */
@Controller
public class DeadlineController {
    
    @Autowired
    private JobFairDataService jobFairDataService;
    
    @PostMapping("/setdeadline")
    public String setDeadline(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<>();
        
        StringToCalendar toCalendar = new StringToCalendar(request.getParameter("datum"));
        Date deadline = toCalendar.getDateFormat(errors);
        
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
        } else {
            jobFairDataService.updateDeadline(deadline);
            String dateStr = new SimpleDateFormat("EEEE").format(deadline) + " "
                + new SimpleDateFormat("dd").format(deadline) + " "
                + new SimpleDateFormat("MMMM").format(deadline) + " "
                + new SimpleDateFormat("yyyy").format(deadline);
            request.setAttribute("success", "Je hebt de deadline gewijzigd naar: " + dateStr); 
        }
        return "admin";
    }
}
