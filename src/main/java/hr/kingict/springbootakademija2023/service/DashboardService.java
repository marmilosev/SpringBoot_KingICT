package hr.kingict.springbootakademija2023.service;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public String getDashboard(){
        return "dashboard.html";
    }
}
