package com.astrazeneca.training.makerchecker.validator;


import com.astrazeneca.training.makerchecker.common.JSendResponse;
import com.astrazeneca.training.makerchecker.dto.Applicationdto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Aspect
@Component
public class CustomerFormValidator {

    @Around("execution(* com.astrazeneca.training.makerchecker.controller.CustomerFormController.* (..)) && args(applicationdto,..) ")
    public Object beforeApplicationSaveExecution(ProceedingJoinPoint pjp, Applicationdto applicationdto) {
        try {
            if (applicationdto.getApplicationtype().trim().isEmpty()) {
                HashMap<String, String> errors = new HashMap<String, String>();
                errors.put("ApplicationType", "Application Type is Empty");
                return new JSendResponse(JSendResponse.STATUS_ERROR, errors, "");
            }
            Applicationdto rapplicationdto = (Applicationdto) pjp.proceed();
            return new JSendResponse(JSendResponse.STATUS_SUCCESS,rapplicationdto, "");

        }catch (Throwable e) {
            return new JSendResponse(JSendResponse.STATUS_FAIL, "", JSendResponse.getStackTrace(e));
        }
    };
}
