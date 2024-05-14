package com.NttProject.demo.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class PartTime extends Employee  {


    private double hourlyRate;
    public static final int workingDays= 120;
    public static final int workingHoursPerDay = 8;
    private double salary;
    public PartTime() {
    }

    public PartTime(String name, Role role, double hourlyRate) {
        super(name, role);
        this.hourlyRate = hourlyRate;
        this.salary = calculateSalary();
    }



    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return salary = hourlyRate * workingDays * workingHoursPerDay;
    }
}
