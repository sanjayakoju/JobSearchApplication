package com.ea.cs544.jobsearchapplication.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DeleteLogAspect {

    @Pointcut("execution(* com.ea.cs544.jobsearchapplication.service.ApplicationService.deleteById(..))")
    public void deleteApplication() {

    }

    @Pointcut("execution(* com.ea.cs544.jobsearchapplication.service.JobService.deleteById(..))")
    public void deleteJob() {

    }

    @Pointcut("execution(* com.ea.cs544.jobsearchapplication.service.CompanyService.deleteById(..))")
    public void deleteCompany() {

    }

    @Pointcut("execution(* com.ea.cs544.jobsearchapplication.service.SkillService.deleteById(..))")
    public void deleteSkill() {

    }

    @Pointcut("execution(* com.ea.cs544.jobsearchapplication.service.InterviewService.deleteById(..))")
    public void deleteInterview() {

    }

    @After("deleteApplication() || deleteJob() || deleteCompany() || deleteInterview() || deleteSkill()")
    public void afterDelete(JoinPoint joinPoint) {
        System.out.println("Object type of " + joinPoint.getSignature().getDeclaringTypeName() + " - using method "
                + joinPoint.getSignature().getName() + " with id " + joinPoint.getArgs()[0] +
                " deleted Successfully.");
    }

}
