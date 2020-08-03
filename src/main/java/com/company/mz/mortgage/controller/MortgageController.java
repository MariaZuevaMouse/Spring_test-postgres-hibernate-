package com.company.mz.mortgage.controller;

import com.company.mz.mortgage.model.MortgageList;
import com.company.mz.mortgage.model.MortgageRequest;
import com.company.mz.mortgage.model.MortgageResponse;
import com.company.mz.mortgage.repository.MortgageManualRepository;
import com.company.mz.mortgage.services.MortgageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MortgageController {

    private final MortgageManualRepository manualRepository;
    private final MortgageService service;

    public MortgageController(
            MortgageManualRepository manualRepository,
            MortgageService service) {
        this.manualRepository = manualRepository;
        this.service = service;
    }

    @GetMapping("/mortgages")
    public MortgageList getAll(){
        return  service.getAllMortgages();
    }



    @GetMapping("/mortgages/successful")
    public MortgageList getAllSuccessful(){
        return service.getAllSuccessfulMortgages();
    }


    @PostMapping("/mortgage")
    public MortgageResponse registerApplication(@RequestBody MortgageRequest request){
        return  service.registerApplicationService(request);
    }
}

//0) long method using stream in Controller - further resolution in repository
/*
* @GetMapping("/mortgages/successful")
    public MortgageList getAllSuccessful(){
        List<MortgageApplication> allSuccessful = repository.findAll().stream()
                .filter(application -> application.getResolution() == Resolution.SUCCESSFUL)
                .collect(Collectors.toList());
        return new MortgageList(allSuccessful);
    }
    *
    *
  *
    * */

//
/*
* -- ! bad approach, methods should be in service
* @GetMapping("/mortgages")
    public MortgageList getAll(){
        return  new MortgageList(repository.findAll());
        *
        *
 @RestController
public class MortgageController {
    private final MortgageApplicationRepository repository;
    private final MortgageManualRepository manualRepository;
    private final MortgageService service;

    public MortgageController(
            MortgageApplicationRepository repository,
            MortgageManualRepository manualRepository,
            MortgageService service) {
        this.repository = repository;
        this.manualRepository = manualRepository;
        this.service = service;
    }

    @GetMapping("/mortgages")
    public MortgageList getAll(){
        return  service.getAllMortgages();
    }



    @GetMapping("/mortgages/successful")
    public MortgageList getAllSuccessful(){
        List<MortgageApplication> allSuccessful =
//                repository.getAllByStatusEquals(Resolution.SUCCESSFUL);
                manualRepository.getAllSuccessful();
        return new MortgageList(allSuccessful);
    }


    @PostMapping("/mortgage")
    public MortgageResponse registerApplication(@RequestBody MortgageRequest request){
        MortgageApplication application = new MortgageApplication();
        application.setName(request.getName());
        application.setResolution(Resolution.SUCCESSFUL);

        application = repository.save(application);
        MortgageResponse response = new MortgageResponse();
        response.setId(application.getId());
        response.setRequest(request);
        response.setResolution("Ok");

        return response;
    }
}

    }*/