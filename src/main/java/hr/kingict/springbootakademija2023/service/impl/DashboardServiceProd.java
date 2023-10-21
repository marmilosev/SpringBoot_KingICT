package hr.kingict.springbootakademija2023.service.impl;

import hr.kingict.springbootakademija2023.service.DashboardService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "prod")
public class DashboardServiceProd implements DashboardService {

    @Override
    public String getDashboard() {
        return "dashboardProd.html";
    }
}
