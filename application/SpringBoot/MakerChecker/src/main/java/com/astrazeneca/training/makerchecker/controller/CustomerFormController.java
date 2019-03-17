package com.astrazeneca.training.makerchecker.controller;


import com.astrazeneca.training.makerchecker.common.JSendResponse;
import com.astrazeneca.training.makerchecker.datatable.DatatableRequest;
import com.astrazeneca.training.makerchecker.dto.Applicationdto;
import com.astrazeneca.training.makerchecker.service.FormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("customerForm")
public class CustomerFormController {

    private Logger log = LoggerFactory.getLogger(CustomerFormController.class);

    @Autowired
    FormService formService;

    @GetMapping(value = "/getForms")
    public Object getAllForms(@RequestBody DatatableRequest datatableRequest) {
        log.info("inside getAllForms()");
        return new JSendResponse(JSendResponse.STATUS_SUCCESS, formService.getAllApplications(datatableRequest), "");
    }

    @PostMapping(value = "/save")
    public Object saveForm(@RequestBody Applicationdto applicationdto) {
        log.info("inside saveForm()");
        return formService.save(applicationdto);
    }

    @GetMapping(value="/getFormById/{formId}", produces = "Application/json")
    public Object getFormById(@PathVariable(value = "formId") long id) {
        try {
            return new JSendResponse(JSendResponse.STATUS_SUCCESS, formService.findByApplication(id), "");
        }catch (NoSuchElementException Nsee){
            HashMap<String, String> errors = new HashMap<String, String>();
            errors.put("ApplicationForm", "Form Not Found");
            return new JSendResponse(JSendResponse.STATUS_FAIL, errors, "");
        }
    }

    @PostMapping(value = "/update/{formId}")
    public Object updateForm(@PathVariable(value = "formId") long id, @RequestBody Applicationdto applicationdto) {
        log.info("inside saveForm()");
        return formService.save(applicationdto);
    }

    @GetMapping(value="/getProductById/{prodId}", produces = "Application/json")
    public Object deleteForm(@PathVariable(value = "formId") long id) {
        return new JSendResponse(JSendResponse.STATUS_SUCCESS, formService.findByApplication(id), "");
    }



}
