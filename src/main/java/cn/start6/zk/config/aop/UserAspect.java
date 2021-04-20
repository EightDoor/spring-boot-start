package cn.start6.zk.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import cn.start6.zk.utils.R;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoukai
 */
@Slf4j
@Aspect
@Component
public class UserAspect {
    @Before("execution(public * cn.start6.zk.web..*(..))")
    public void doBefore(final JoinPoint joinPoint) {
        for (final Object arg : joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                final BindingResult result = (BindingResult)arg;
                if (result.hasErrors()) {
                    final FieldError error = result.getFieldError();
                    R.error("field " + error.getField() + "msg:" + error.getDefaultMessage());
                }
            }
        }
    }
}
