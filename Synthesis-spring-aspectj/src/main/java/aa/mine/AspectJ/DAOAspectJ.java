package aa.mine.AspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DAOAspectJ {

//	设置切入点
	@Pointcut("execution(* aa.mine.AspectJ.DAO.*DAO.*(..))")
	public void pointcut() {}
	
	@Pointcut("within(aa.mine.AspectJ.DAO.*)")
	public void daoPointcut() {}
	
	@Before("pointcut()")
	public void before() {
		System.out.println("Before....");
	}
	
	@Before("pointcut() && args(arg)")
	public void beforeWithParam(String arg) {
		System.out.println("BeforeWithParam." + arg);
	}
	
	@Before("pointcut() && @annotation(DAOmethod)")
	public void beforeWithAnnotaion(DAOmethod DAOmethod) {
		System.out.println("BeforeWithAnnotation." + DAOmethod.value());
	}
	
	@AfterReturning(pointcut="daoPointcut()", returning="returnValue")
	public void afterReturning(Object returnValue) {
		System.out.println("AfterReturning : " + returnValue);
	}
	
	@AfterThrowing(pointcut="pointcut()", throwing="e")
	public void afterThrowing(RuntimeException e) {
		System.out.println("AfterThrowing : " + e.getMessage());
	}
	
	@After("pointcut()")
	public void after() {
		System.out.println("After....");
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around 1.");
		Object obj = pjp.proceed();
		System.out.println("Around 2.");
		System.out.println("Around : " + obj);
		return obj;
	}
}
