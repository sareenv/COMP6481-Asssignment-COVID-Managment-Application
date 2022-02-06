package Main;

//
// Assignment 1
// © Vinayak Sareen.
// Written by: Vinayak Sareen - SID: 40186182
//

import java.util.Scanner;

public class Main {

    private int maxVaccineCount;
    private Vaccine[] vaccines;

    public void registerVaccine(Scanner snc) {
        System.out.println("Please enter new vaccination count");
        int newVaccineCount = snc.nextInt();
        // check if the amount of vaccines can be entered into the system.
        int inventorySize = this.vaccines.length;
        int objectAllocationCounts = Vaccine.findNumberOfCreatedVaccine();
        int currentCapacity = inventorySize - objectAllocationCounts;

        if (currentCapacity >= newVaccineCount) {
            for(int i = 0; i< newVaccineCount; i++) {
                Vaccine vaccine = inputVaccine(snc, false);
                this.vaccines[i] = vaccine;
            }
        } else {
            int currentAvailability = Math.max(currentCapacity, 0);
            System.out.println("Sorry the storage capacity for " +
                    "the store has already exceeded only " +  currentAvailability + " can be stored " +
                    "in the system" );
        }
    }

    private Vaccine inputVaccine(Scanner snc, boolean isUpdation) {
        System.out.println(isUpdation ? "Please provide the update details" : "Please enter the " +
                "new vaccine details");
        System.out.println("Please enter the vaccine id");
        long vaccineID = snc.nextLong();

        VaccineBrand selectedBrand = selectBrandOption(snc);
        System.out.println("Please enter the dose for the vaccine");
        int dose = snc.nextInt();
        System.out.println("Please enter the price for the vaccine");
        double price = snc.nextDouble();
        System.out.println("Please enter the expiry date");
        String expiryDate = snc.nextLine();
        return new Vaccine(selectedBrand,
            dose, expiryDate, vaccineID, price);
    }


    private VaccineBrand selectBrandOption(Scanner snc) {
        System.out.println("Please select vaccine category from the following categories \n" +
                "1. Moderna \n" +
                "2. Pfizer \n" +
                "3. COVISHIED \n" +
                "4. COVAXIN \n");
        boolean isCorrectOption = false;
        int selectedCategory = snc.nextInt();
        VaccineBrand selectedBrand = null;
        while (!isCorrectOption) {
            if (selectedCategory == 1) {
                selectedBrand = VaccineBrand.Moderna;
                isCorrectOption = true;
            }  else if(selectedCategory == 2) {
                selectedBrand = VaccineBrand.Pfizer;
                isCorrectOption = true;
            }  else if(selectedCategory == 3) {
                selectedBrand = VaccineBrand.COVISHIED;
                isCorrectOption = true;
            }  else if (selectedCategory == 4) {
                selectedBrand = VaccineBrand.COVAXIN;
                isCorrectOption = true;
            }
        }
        return selectedBrand;
    }

    public boolean validateUserPassword(Scanner snc) {
        // boolean flag to check if the password is correct.
        boolean isPassword = false;
        int passwordAttempt = 0;
        System.out.println("Please enter your password to register new vaccine");
        while (!isPassword && passwordAttempt < 3) {
            String password = snc.next();
            if(password.equals("password")) {
                isPassword = true;
            } else{
                System.out.println("Incorrect Password! " +
                        "Please type your password again");
            }
            passwordAttempt++;
        }
        String passwordStatus = isPassword ? "Correct Password" : "Wrong password " +
                "even after 3 tries";
        System.out.println(passwordStatus);
        return isPassword;
    }

    public void updateVaccineDetails(Scanner snc) {
        System.out.println("Please enter the valid index of the vaccine " +
                "in the inventory");
        int index = snc.nextInt();
        if (index < 0 || index >= this.vaccines.length ) {
            System.out.println("Sorry Invalid option is selected");
            return;
        }
        // update the vaccine details.
        if (vaccines[index] != null) {
            Vaccine vaccine = this.vaccines[index];
            System.out.println(vaccine);
            System.out.println("Which information would you like to change \n" +
                    "1. Brand \n" +
                    "2. Dose \n" +
                    "3. Expiry \n" +
                    "4. Price \n" +
                    "5. Quit \n");
            int inputOption = 0;
            while (inputOption != 5) {
                inputOption = snc.nextInt();
                switch (inputOption) {
                    case 1:
                        System.out.println("Editing the vaccine name");
                        VaccineBrand brand =  selectBrandOption(snc);
                        vaccine.setBrand(brand);
                        System.out.println("Successfully changed " +
                                "brand of this vaccine");
                        continue;
                    case 2:
                        System.out.println("Editing the vaccine dose");
                        int vaccine_dose = snc.nextInt();
                        vaccine.setDose(vaccine_dose);
                        System.out.println("Successfully changed " +
                                "dose of this vaccine");
                        continue;

                    case 3:
                        System.out.println("Editing the expiry date of the vaccine");
                        String vaccine_expiry = snc.next();
                        vaccine.setExpiryDate(vaccine_expiry);
                        System.out.println("Successfully changed " +
                                "expiry of the vaccine");
                        continue;

                    case 4:
                        System.out.println("Editing the price of the vaccine");
                        double price = snc.nextDouble();
                        vaccine.setPrice(price);
                        System.out.println("Successfully changed " +
                                "price of the vaccine");
                        continue;

                    case 5:
                        System.out.println("Quit option is selected: " +
                                "Thanks for using this option");
                        break;

                    default:
                        System.out.println("Invalid option is selected try again");
                }
            }

        } else {
            // null is present at that index.
            System.out.println("Sorry no vaccine record has been found at this index" +
                    " \n Would you like to register the vaccine, Y OR N: ");
            boolean isInputCorrect  = false;
            while (!isInputCorrect) {

            }
        }
    }
    public void displayMenu(Scanner snc) {
        System.out.println("What do you want to do ?");
        System.out.println("1. Enter new vaccines (password required)");
        System.out.println("2. Change information of a vaccine (password required)");
        System.out.println("3. Display all vaccines by a specific brand ");
        System.out.println("4. Display all vaccines under a certain a price. ");
        System.out.println("5. Quit");
        System.out.println("Please enter your choice > ");
        // boolean flag to ensure that correct option is selected by the user
        boolean isWrongOptionSelected = true;
        while (isWrongOptionSelected) {
            double selectedOption = 0;
            selectedOption = snc.nextDouble();
            switch ((int) selectedOption) {
                case 1:
                    isWrongOptionSelected = false;
                    boolean passwordValidation = this.validateUserPassword(snc);
                    if(passwordValidation) {
                        System.out.println("Register new vaccines");
                        registerVaccine(snc);
                    } else {
                        // display the wrong password 4 times need to implement that part.
                        displayMenu(snc);
                    }
                    break;
                case 2:
                    isWrongOptionSelected = false;
                    updateVaccineDetails(snc);
                    break;
                case 3:
                    System.out.println("3 is pressed");
                    isWrongOptionSelected = false;
                    break;
                case 4:
                    System.out.println("4 is pressed");
                    isWrongOptionSelected = false;
                    break;
                case 5:
                    System.out.println("Quit option is selected: " +
                            "Shutting the system down");
                    isWrongOptionSelected = false;
                    snc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong option is selected");
                    System.out.println("Please enter your selection again");
                    break;
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Pharmacy Application 👩‍⚕️ ...");
        System.out.println("Please enter the amount of Vaccines store may contain 🏪");
        Main driver = new Main();
        Scanner snc = new Scanner(System.in);
        driver.maxVaccineCount = snc.nextInt();
        driver.vaccines = new Vaccine[driver.maxVaccineCount];
        while(true) {
            driver.displayMenu(snc);
        }
    }
}
