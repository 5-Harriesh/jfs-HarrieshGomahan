package com.astrazeneca.training.makerchecker.service;

import com.astrazeneca.training.makerchecker.datatable.DatatableRequest;
import com.astrazeneca.training.makerchecker.datatable.DatatableResponse;
import com.astrazeneca.training.makerchecker.dto.Applicationdto;
import org.springframework.stereotype.Service;

@Service
public interface FormService {

    public DatatableResponse<Applicationdto> getAllApplications(DatatableRequest datatableRequest);

    public Applicationdto save(Applicationdto applicationdto);

    public Applicationdto findByApplication(long id);

}
