package com.br.companyabc.healthylife.model;

import com.br.companyabc.healthylife.exception.HighWeightException;
import com.br.companyabc.healthylife.exception.HighHeightException;
import com.br.companyabc.healthylife.exception.CafException;

import java.time.LocalDate;

public interface ClientInterface {
    public void calculateImc() throws HighWeightException, HighHeightException;
    public void classifyImc() throws HighWeightException, HighHeightException;
    public void calculateEer() throws HighHeightException, HighWeightException;
    public void calculateCaf() throws CafException;
    public void calculateAge(LocalDate birthDate);
}
