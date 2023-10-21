package hr.kingict.springbootakademija2023.controller;

import hr.kingict.springbootakademija2023.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @Autowired
    //ne mora se pisati = new... zbog anotacije
    private DashboardService dashboardService;

//    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    @GetMapping(value = "/dashboard")
    public String getDashboard(){
        return dashboardService.getDashboard();
    }
}
