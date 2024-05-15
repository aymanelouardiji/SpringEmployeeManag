package com.NttProject.demo.Model;

import jakarta.persistence.Entity;


@Entity
public class Contractor extends Employee {
    private double hourlyRate;
    private double contractDuration; // in hours
    private double salary;

    public void setContractDuration(double contractDuration) {
        this.contractDuration = contractDuration;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Contractor() {
    }

    public Contractor(String name, Role role, double hourlyRate, double contractDuration) {
        super(name, role);
        this.hourlyRate = hourlyRate;
        this.contractDuration = contractDuration;
        this.salary = calculateSalary();

    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    @Override
    public double calculateSalary() {
        return salary = hourlyRate * contractDuration;
    }
}
