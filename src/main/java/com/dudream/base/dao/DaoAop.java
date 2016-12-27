package com.dudream.base.dao;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dudream on 2016/12/27.
 */
@Component
@Aspect
@Slf4j
public class DaoAop {

    @Pointcut("execution(* com.dudream.dao.*.*(..))")
    public void aspect() {};

    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint){
        try{
            Object bean = joinPoint.getTarget();
            Class<?>define= bean.getClass().getInterfaces()[0];
            Dao daoAnno =define.getAnnotation(Dao.class);

            if(daoAnno!=null){
                MultipleDataSource.setDataSourceKey(daoAnno.value().getValue());
            }else {
                MultipleDataSource.setDataSourceKey(DataSourceType.getDefault().getValue());
            }
        }catch (Throwable throwable) {
            log.error("dao router error, {}", throwable);
            throw new RuntimeException("dao router error", throwable);
        }
        Object result =null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("dao around error: {}", e);
            throw new RuntimeException("dao run sql error", e);
        }
        return result;
    }

}
