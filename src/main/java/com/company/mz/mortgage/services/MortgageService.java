package com.company.mz.mortgage.services;

import com.company.mz.mortgage.entity.MortgageApplication;
import com.company.mz.mortgage.entity.Resolution;
import com.company.mz.mortgage.model.MortgageList;
import com.company.mz.mortgage.model.MortgageRequest;
import com.company.mz.mortgage.model.MortgageResponse;
import com.company.mz.mortgage.repository.MortgageApplicationRepository;
import com.company.mz.mortgage.repository.MortgageManualRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MortgageService {

    private final MortgageApplicationRepository repository;
    private final MortgageManualRepository manualRepository;
    private final PoliceService policeService;
    private final TaxService taxService;

    public MortgageService(MortgageApplicationRepository repository, MortgageManualRepository manualRepository, PoliceService policeService, TaxService taxService) {
        this.repository = repository;
        this.manualRepository = manualRepository;
        this.policeService = policeService;
        this.taxService = taxService;
    }

    public MortgageList getAllMortgages() {
        return new MortgageList(repository.findAll());
    }

    public MortgageList getAllSuccessfulMortgages() {
        List<MortgageApplication> allSuccessful =
                repository.getAllByResolutionEquals(Resolution.SUCCESSFUL);
        return new MortgageList(allSuccessful);
    }

    public MortgageResponse registerApplicationService(MortgageRequest request) {
        MortgageApplication application = new MortgageApplication();
        MortgageResponse response = new MortgageResponse();
        application.setName(request.getName());

        if(taxService.isSolvent(application)){
            if(policeService.getIsTerrorist(application)){
                application.setResolution(Resolution.TERRORIST);
            }else application.setResolution(Resolution.SUCCESSFUL);
        }else application.setResolution(Resolution.LOW_BUDGET);



        application = repository.save(application);

        response.setId(application.getId());
        response.setRequest(request);

        if(taxService.isSolvent(application)){
            if(policeService.getIsTerrorist(application)){
                response.setResolution("denied");
            }else response.setResolution("agreed");
        }else response.setResolution("try decreasing the loan amount or increasing the payment term");

        return response;
    }
}

/*
* @Service
* @Repository
* @Controller
*
* @Component
*
* */
