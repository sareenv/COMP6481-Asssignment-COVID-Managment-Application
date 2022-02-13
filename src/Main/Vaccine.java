package Main;

//
// Assignment 1
// © Vinayak Sareen.
// Written by: Vinayak Sareen - SID: 40186182
//

import java.util.ArrayList;
import java.util.Objects;


class Vaccine {
    static int vaccineCnt = 0;
    private VaccineBrand brand;
    private double dose;
    private String expiryDate;
    private final long vaccineId;
    private double price;

    @Override
    public String toString() {
        return "ID: " + vaccineId + "\n"+
                "Brand: " + brand + "\n"+
                "Dose: " + dose + "\n" +
                "Expiry: " + expiryDate + "\n" +
                "Price: $" + price + "\n";
    }

    // default constructor.
    public Vaccine() {
        this.expiryDate = "";
        this.dose = 0;
        this.price = 0;
        this.vaccineId = 0;
        this.brand = null;
        vaccineCnt += 1;
    }

    // copy constructor.
    public Vaccine(Vaccine v) {
        this.vaccineId = v.vaccineId;
        this.price = v.price;
        this.expiryDate = v.expiryDate;
        this.brand = v.brand;
        this.dose = v.dose;
        vaccineCnt += 1;
    }

    public Vaccine(VaccineBrand brand, double dose, String expiryDate, long vaccineId, double price) {
        this.brand = brand;
        this.dose = dose;
        this.expiryDate = expiryDate;
        this.vaccineId = vaccineId;
        this.price = price;
        vaccineCnt += 1;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setBrand(VaccineBrand brand) {
        this.brand = brand;
    }
    public void setDose(double dose) {
        this.dose = dose;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public static int findNumberOfCreatedVaccine() { return vaccineCnt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return Double.compare(vaccine.dose, dose) == 0
                && vaccineId == vaccine.vaccineId
                && Double.compare(vaccine.price, price) == 0
                && brand == vaccine.brand
                && expiryDate.equals(vaccine.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, dose,
                expiryDate, vaccineId, price);
    }

    public static ArrayList<Vaccine> findVaccineByVaccineBrand(ArrayList<Vaccine> vaccines,
                                                                    VaccineBrand brand) {
        ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
        for (Vaccine v: vaccines) {
            if (v != null && v.brand == brand) {
                vaccineList.add(v);
            }
        }
        return vaccineList;
    }

    public static ArrayList<Vaccine> findCheaperThan(Vaccine[] vaccines, double price) {
        // linear search - complexity - O(N).
        // Alternative: Binary Search but the problem is that we
        ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
        for (Vaccine vaccine: vaccines) {
            if (vaccine != null && vaccine.price < price) {
                vaccineList.add(vaccine);
            }
        }
        return vaccineList;
    }

}
