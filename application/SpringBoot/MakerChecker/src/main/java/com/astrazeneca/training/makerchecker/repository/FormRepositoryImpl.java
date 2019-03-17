package com.astrazeneca.training.makerchecker.repository;

import com.astrazeneca.training.makerchecker.datatable.DatatableBuilder;
import com.astrazeneca.training.makerchecker.datatable.DatatableRequest;
import com.astrazeneca.training.makerchecker.datatable.DatatableResponse;
import com.astrazeneca.training.makerchecker.entity.Application;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FormRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public DatatableResponse<Application> getApplications(DatatableRequest datatableRequest) {
        DatatableBuilder<Application> datatableBuilder = new DatatableBuilder();
        datatableBuilder.setDatatableRequest(datatableRequest);
        datatableBuilder.setEntityManager(entityManager);
        datatableBuilder.setClazz(Application.class);
        return datatableBuilder.buildDatatableConfig();
    }

}
