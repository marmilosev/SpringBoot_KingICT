package hr.kingict.springbootakademija2023.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DashboardServiceAspect {

    Logger logger = LoggerFactory.getLogger(DashboardServiceAspect.class);

    @Before(value = "execution(* hr.kingict.springbootakademija2023.service.DashboardService.getDashboard(..))")
    //prije nekog događaja
    //sve metode getDashboard -> (..)
    private void beforeDashboardServiceGetDashboard(JoinPoint joinPoint){
        logger.info("beforeDashboardServiceGetDashboard : " + joinPoint.getTarget().getClass().getSimpleName());
    }
}
