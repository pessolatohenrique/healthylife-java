package com.br.companyabc.healthylife.model;

import com.br.companyabc.healthylife.exception.CafException;
import com.br.companyabc.healthylife.exception.HighHeightException;
import com.br.companyabc.healthylife.exception.HighWeightException;

import java.time.LocalDate;
import java.time.Period;

public class Client implements ClientInterface, AutoCloseable{
    private String name;
    private Double weight;
    private Double height;
    private Integer age;
    private Double imc;
    private String imc_classification;
    private Integer activity_level;
    private Double caf;
    private Double eer;
    private Integer diet;

    /**
     * Construtor para a classe Client
     * @param name nome do cliente
     * @param weight peso do cliente
     * @param altura altura do cliente
     */
    public Client(String name, Double weight, Double altura) {
        this.name = name;
        this.weight = weight;
        this.height = altura;
    }

    @Override
    public void close() throws Exception {
    }

    public Integer getAge() { return this.age; }

    public String getName() { return this.name; }

    public String getImcClassification() { return this.imc_classification; }

    public Integer getActivityLevel() {
        return activity_level;
    }

    public void setActivityLevel(Integer activity_level) {
        this.activity_level = activity_level;
    }

    public void setCaf(Double caf) {
        this.caf = caf;
    }

    public Double getCaf() {
        return caf;
    }

    public void setEer(Double eer) {
        this.eer = eer;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

    public Integer getDiet() {
        return diet;
    }

    /**
     * realiza a validação com base em possíveis exceções
     * @throws HighWeightException exceção referente ao peso
     * @throws HighHeightException exceção referente à altura
     */
    public void validates() throws HighWeightException, HighHeightException {
        if (this.weight <= 0) {
            throw new IllegalArgumentException("O weight não pode ser menor do que 0");
        }

        if(this.height <= 0) {
            throw new IllegalArgumentException("A height não pode ser menor do que 0");
        }

        if (this.weight > 250) {
            throw new HighWeightException("O peso não pode ser maior do que 250!");
        }

        if (this.height > 3.50) {
            throw new HighHeightException("A altura não pode ser maior do que 3.50m!");
        }
    }

    /**
     * realiza o cálculo do IMC com base na altura e peso
     * @throws HighWeightException exceção referente ao peso
     * @throws HighHeightException exceção referente à altura
     */
    public void calculateImc() throws HighWeightException, HighHeightException {
        this.validates();
        this.imc = this.weight / (this.height * this.height);
    }

    /**
     * exemplo de sobrecarga, com IMC já enviado por usuário
     * @param imc IMC já enviado
     */
    public void calculateImc(Double imc) {
        System.out.println("Sobrecarga de IMC: " + imc);
        this.imc = imc;
    }

    /**
     * classificação de grau do IMC
     */
    public void classifyImc() {
        if (this.imc < 16){
            this.imc_classification = "Desnutrição grau 3";
        }else if(this.imc >= 16 && this.imc <= 17.9){
            this.imc_classification = "Desnutrição grau 2";
        }else if(this.imc >= 18 && this.imc <= 18.4){
            this.imc_classification = "Desnutrição grau 1";
        }else if(this.imc >= 18.5 && this.imc <= 24.9){
            this.imc_classification = "Eutrofia";
        }else if(this.imc >= 25 && this.imc <= 29.9){
            this.imc_classification = "Sobrepeso";
        }else if(this.imc >= 30 && this.imc <= 34.9){
            this.imc_classification = "Obesidade grau 1";
        }else if(this.imc >= 35 && this.imc <= 39.9){
            this.imc_classification = "Obesidade grau 2";
        }else{
            this.imc_classification = "Obesidade grau 3";
        }
    }

    /**
     * cálculo da Estimativa de Energia Diária (EER)
     * @throws HighWeightException exceção referente ao peso
     * @throws HighHeightException exceção referente à altura
     */
    @Override
    public void calculateEer() throws HighHeightException, HighWeightException {
        this.validates();
        if (this.age <= 0 || this.age >= 140) {
            throw new IllegalArgumentException("Idade não pode ser menor do que 0 e maior do que 140");
        }
    }

    @Override
    public void calculateCaf() throws CafException {
    }

    /**
     * cálculo da idade com base na data atual
     * @param birthDate data de aniversário do cliente
     */
    public void calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.of(2020, 10, 26);
        if ((birthDate != null) && (currentDate != null)) {
            this.age = Period.between(birthDate, currentDate).getYears();
        } else {
            this.age = 0;
        }
    }

    /**
     * seleção da dieta, com base no EER
     */
    public void chooseDiet() {
        if (this.eer <= 1900) {
            this.diet = 1900;
        } else if(this.eer > 1900 && this.eer <= 2500) {
            this.diet = 2500;
        } else {
            this.diet = 2800;
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
