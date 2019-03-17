package com.astrazeneca.training.makerchecker.repository;

import com.astrazeneca.training.makerchecker.datatable.DatatableRequest;
import com.astrazeneca.training.makerchecker.datatable.DatatableResponse;
import com.astrazeneca.training.makerchecker.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Application,Long> {

    public DatatableResponse<Application> getApplications(DatatableRequest datatableRequest);
}
