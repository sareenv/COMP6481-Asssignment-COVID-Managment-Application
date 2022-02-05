package Main;

//
// Assignment 1
// © Vinayak Sareen.
// Written by: Vinayak Sareen - SID: 40186182
//

enum VaccineBrand {
    Moderna,
    Pfizer,
    COVISHIED,
    COVAXIN
}

class Vaccine {
    static int vaccineCnt = 0;

    private VaccineBrand brand;
    private double dose;
    private String expiryDate;
    private final long vaccineId;
    private double price;
    @Override
    public String toString() {
        return "Vaccine{" +
                "brand=" + brand +
                ", dose=" + dose +
                ", expiryDate='" + expiryDate + '\'' +
                ", vaccineId=" + vaccineId +
                ", price=" + price +
                '}';
    }
    public Vaccine() {
        this.dose = 0;
        this.price = 0;
        this.vaccineId = 0;
        this.brand = null;
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
}
