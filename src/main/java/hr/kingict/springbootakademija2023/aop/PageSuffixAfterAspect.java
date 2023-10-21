package hr.kingict.springbootakademija2023.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PageSuffixAfterAspect {

    Logger logger = LoggerFactory.getLogger(PageSuffixAfterAspect.class);
    @AfterReturning(value = "execution(* hr.kingict.springbootakademija2023.service.PageSuffixService.getSuffix())",
            returning = "result")
    private void afterPageSuffixServiceGetSuffix(String result){
        logger.info("afterPageSuffixServiceGetSuffix : " + result);
    }
}
