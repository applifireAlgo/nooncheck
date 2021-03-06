package checkgit.app.server.businessservice.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;

@Aspect
@Component
public abstract class BusinessAspect {


	protected Object handleMethodCall(ProceedingJoinPoint joinPoint, RuntimeLogUserInfoBean runtimeLogInfoHelper) throws Throwable {
		try {

			Object returnObject = joinPoint.proceed();
			return returnObject;

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
