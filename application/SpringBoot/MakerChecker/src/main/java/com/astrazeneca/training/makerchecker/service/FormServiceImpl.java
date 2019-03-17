package com.astrazeneca.training.makerchecker.service;

import com.astrazeneca.training.makerchecker.common.ObjectMapperUtils;
import com.astrazeneca.training.makerchecker.datatable.DatatableRequest;
import com.astrazeneca.training.makerchecker.datatable.DatatableResponse;
import com.astrazeneca.training.makerchecker.dto.Applicationdto;
import com.astrazeneca.training.makerchecker.entity.Application;
import com.astrazeneca.training.makerchecker.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepository formRepository;

    @Override
    public DatatableResponse<Applicationdto> getAllApplications(DatatableRequest datatableRequest) {
        DatatableResponse<Application> resp = formRepository.getApplications(datatableRequest);
        List<Applicationdto> listOfApplicationsDTO = ObjectMapperUtils.mapAll(resp.getData(), Applicationdto.class);
        return new DatatableResponse<Applicationdto>(resp.getRecordsTotal(),listOfApplicationsDTO);
    }

    @Override
    public Applicationdto save(Applicationdto applicationdto) {
        Application application = formRepository.save(ObjectMapperUtils.map(applicationdto,Application.class));
        return ObjectMapperUtils.map(application,Applicationdto.class);
    }

    @Override
    public Applicationdto findByApplication(long id) {
        Application application = formRepository.findById(id).get();
        return ObjectMapperUtils.map(application,Applicationdto.class);
    }
}
