package com.NttProject.demo.Model;

import jakarta.persistence.Entity;

@Entity
public class FullTime extends Employee {
    private double salaryPerYear;


    public FullTime() {
    }

    public FullTime(String name, Role role, double salaryPerYear) {
        super(name, role);
        this.salaryPerYear = salaryPerYear;

    }

    public double getSalaryPerYear() {
        return salaryPerYear;
    }

    public void setSalaryPerYear(double salaryPerYear) {
        this.salaryPerYear = salaryPerYear;
    }

    @Override
    public double calculateSalary() {
        return salaryPerYear;
    }
}