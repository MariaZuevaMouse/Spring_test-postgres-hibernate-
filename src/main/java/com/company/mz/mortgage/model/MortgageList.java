package com.company.mz.mortgage.model;

import com.company.mz.mortgage.entity.MortgageApplication;

import java.io.Serializable;
import java.util.List;

public class MortgageList implements Serializable {
    List<MortgageApplication> values;

    public MortgageList() {
    }

    public MortgageList(List<MortgageApplication> values) {
        this.values = values;
    }

    public List<MortgageApplication> getValues() {
        return values;
    }

    public void setValues(List<MortgageApplication> values) {
        this.values = values;
    }
}
