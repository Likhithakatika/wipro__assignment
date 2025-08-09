package com.wipro.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

@Aspect		// we are telling to spring this is extra logic I'm writing
@Component		// spring take care of this class (object creation)
@Slf4j
public class QuizAOP {
	
	@Before("execution(* com.wipro.example.controller.QuestionController.addNewQuestion(..))")
	public void logbefore() {
		log.warn("loging something before addNewQuestion");
	}
	
	@After("execution(* com.wipro.example.controller.QuestionController.addNewQuestion(..))")
	public void logafter() {
		log.warn("loging something after addNewQuestion");
	}
	
	@AfterReturning(pointcut = "quizControllerMethods()", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
	    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	    log.info("Completed method: {} with result: {}", signature.getName(), result);
	}
}
