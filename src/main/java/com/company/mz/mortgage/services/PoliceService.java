package com.company.mz.mortgage.services;

import com.company.mz.mortgage.entity.MortgageApplication;
import org.springframework.stereotype.Service;

@Service
public class PoliceService {
    public boolean getIsTerrorist(MortgageApplication application){
        return (Math.random()<0.5) ? false : true;
    }

}
