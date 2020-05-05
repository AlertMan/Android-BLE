package com.blehelper.demo.aop.aspect;

import com.blehelper.demo.Utils;
import com.blehelper.demo.aop.CheckConnect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

import cn.com.heaton.blelibrary.ble.Ble;

/**
 * Created by jerry on 2018/6/13.
 */

@Aspect
public class CheckConnectAspect {

    private static final String CHECK_CONNECT = "execution(@com.belhelper.demo.aop.CheckConnect * *(..))";

    @Pointcut("execution(@com.belhelper.demo.aop.CheckConnect * *(..))")//方法切入点
    public void methodAnnotated() {
    }

//    @Around("methodAnnotated()")//在连接点进行方法替换

    @Around("execution(@com.belhelper.demo.aop.CheckConnect * *(..)) && @annotation(checkConnect)")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint, CheckConnect checkConnect) throws Throwable {
        List list = Ble.getInstance().getConnetedDevices();
        if(list == null || list.size() == 0){
            Utils.showToast("请先连接设备!");
            return;
        }
        joinPoint.proceed();//执行原方法
    }
}