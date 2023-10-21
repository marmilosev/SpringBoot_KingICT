package hr.kingict.springbootakademija2023.controller;

import hr.kingict.springbootakademija2023.service.DashboardService;
import hr.kingict.springbootakademija2023.service.PageSuffixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import util.FilenameUtil;

@Controller
public class DashboardController {
    @Autowired
    //ne mora se pisati = new... zbog anotacije
    private DashboardService dashboardService;
    @Autowired
    @Qualifier(value = "html")
    private PageSuffixService pageSuffixService;
    @Autowired
    private FilenameUtil filenameUtil;

//    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    @GetMapping(value = "/dashboard")
    public String getDashboard(){
        return dashboardService.getDashboard() + filenameUtil.getSuffixSeparator() + pageSuffixService.getSuffix();
    }
}
