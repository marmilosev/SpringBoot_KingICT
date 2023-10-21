package hr.kingict.springbootakademija2023.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

//    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    @GetMapping(value = "/dashboard")
    public String getDashboard(){
        return "dashboard.html";
    }
}
