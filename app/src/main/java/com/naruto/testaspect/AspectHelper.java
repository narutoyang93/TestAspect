package com.naruto.testaspect;

import android.view.View;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.ref.WeakReference;

/**
 * @Purpose
 * @Author Naruto Yang
 * @CreateDate 2021/2/10 0010
 * @Note
 */
@Aspect
public class AspectHelper {

    @Before("execution(@com.naruto.testaspect.annotation.SingleClick  * *(..))")
    public void onViewClick(JoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.getArgs()[0];
        if (o instanceof View) {
            View view = (View) o;
            view.setClickable(false);
            WeakReference<View> weakReference = new WeakReference<>(view);
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (weakReference.get() != null)
                        weakReference.get().setClickable(true);
                }
            }, 500);
        }
    }

}
