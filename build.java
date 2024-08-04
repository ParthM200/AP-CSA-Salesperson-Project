import java.util.Scanner;

public class build {

    private String salesPersonLastName;
    private String salesPersonFirstName;
    private int salesPersonIDNumber;
    private double salesPersonDailyGoal;
    private int numberDaysOfSalesInfo;

    private double dailyGoalTotal;
    private Double dayXInfo;

    private Double totalSales = 0.0;
    private Double totalPer = 0.0;

    private int salesPeople;

    private Scanner alphaScanner;
    private Scanner numberScanner;

    private SalesPerson[] salesPerson;

    public SalesPerson[] runner(SalesPerson[] x) {
        salesPerson = x;
        setup();

        System.out.println("How many sales people do you want to enter?");
        salesPeople = numberScanner.nextInt();

        salesPerson = new SalesPerson[salesPeople];

        // Asks user to add info for salesPerson.length people
        for (int i = 0; i < salesPerson.length; i++) {
            captureSalesPersonInformation();
            salesPerson[i] = new SalesPerson(salesPersonLastName, salesPersonFirstName,
                    salesPersonIDNumber, salesPersonDailyGoal, numberDaysOfSalesInfo);

            // Nested loop to add numberDaysOfSalesInfo for each salesperson
            for (int j = 0; j < numberDaysOfSalesInfo; j++) {
                dayXInfo = 0.0;
                while (dayXInfo == 0.0) {
                    System.out.print("\nPlease enter the sales for day " + (j + 1) + ": ");
                    String doubleTest2;

                    // Input Validation
                    if (!(doubleTest2 = alphaScanner.nextLine()).isEmpty()) {
                        try {
                            dayXInfo = Double.parseDouble(doubleTest2);
                        } catch (NumberFormatException e) {
                            System.out.println("Daily Goal value can only be a double");
                            dayXInfo = 0.0;
                        }
                    }
                    totalSales += dayXInfo;
                }
                salesPerson[i].updateDayOfSale(j, dayXInfo);
            }

            // Prints sales info for each day of salesperson
            for (int k = 0; k < numberDaysOfSalesInfo; k++) {
                System.out.println("\n" + salesPersonFirstName + "'s sales for day " + (k + 1) + " are: $"
                        + salesPerson[i].returnAmount(k) +
                        "0 and their sales percentage achieved that day was: " + salesPerson[i].percentageDailySales(k)
                        + "0%");
            }
            totalPer = (totalSales / (salesPersonDailyGoal)) * 100;
            totalPer = Math.round(10.0 * totalPer) / 10.0;

            // Prints total sales for person
            System.out.println("\n" + salesPersonFirstName + "'s total sales achieved are: $" + totalSales +
                    "0 and the total sales percentage acheived was " + totalPer + "%");
            System.out.println();
        }

        // One Line Comment For Section Here
        for (int i = 0; i < salesPerson.length; i++) {
            dailyGoalTotal += salesPerson[i].returnSPDailyGoal();
        }

        System.out.println("The total of all employees' sales goals is $" + dailyGoalTotal + "\n");

        for (int i = 0; i < salesPerson.length; i++) {
            System.out.println(salesPerson[i]);
        }

        return salesPerson;
    }

    // Initialize both scanners
    public void setup() {
        alphaScanner = new Scanner(System.in);
        numberScanner = new Scanner(System.in);
    }

    // One Line Comment For Method
    public void captureSalesPersonInformation() {
        getSalesPersonLastName();
        getSalesPersonFirstName();
        getSalesPersonIDNumber();
        getSalesPersonDailyGoal();
        getNumberDaysOfSalesInfo();
    }

    // Get Employee's Last Name
    public void getSalesPersonLastName() {
        salesPersonLastName = "";
        while (salesPersonLastName.equals("")) {
            System.out.print("Please enter the sales person's last name: ");
            salesPersonLastName = alphaScanner.nextLine();
        }
    }

    // Get Employee's First Name
    public void getSalesPersonFirstName() {
        salesPersonFirstName = "";
        while (salesPersonFirstName.equals("")) {
            System.out.print("Please enter the sales person's first name: ");
            salesPersonFirstName = alphaScanner.nextLine();
        }
    }

    // Get Employee's ID Number - Checks for emptiness, uniqueness, and proper
    // character format
    public void getSalesPersonIDNumber() {
        salesPersonIDNumber = 0;
        while (salesPersonIDNumber == 0) {
            System.out.print("Please enter the sales person's number ID: ");
            String test;
            if (!(test = alphaScanner.nextLine()).isEmpty()) {
                try {
                    salesPersonIDNumber = Integer.parseInt(test);
                    {
                        for (int i = 0; i < salesPerson.length; i++) {
                            try {
                                if (salesPersonIDNumber == salesPerson[i].returnSPIDNumber(i)) {
                                    System.out.println("Sales Person ID Must be unique");
                                    salesPersonIDNumber = 0;
                                }
                            }

                            catch (NullPointerException e) {

                            }

                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Sales Person ID Number can only be integers");
                    salesPersonIDNumber = 0;
                }
            }
        }
    }

    // Get Employee's Daily Sales Goal - Checks for emptiness & number format
    public void getSalesPersonDailyGoal() {
        salesPersonDailyGoal = 0;
        while (salesPersonDailyGoal == 0) {
            System.out.print("Please enter the sales person's daily goal (in dollars): ");
            String doubleTest;
            if (!(doubleTest = alphaScanner.nextLine()).isEmpty()) {
                try {
                    salesPersonDailyGoal = Double.parseDouble(doubleTest);
                } catch (NumberFormatException e) {
                    System.out.println("Sales Person Daily Goal can only be a double");
                    salesPersonDailyGoal = 0;
                }
            }
        }

    }

    // Get Employee's Days of Sales Info - Checks for number format and emptiness
    public void getNumberDaysOfSalesInfo() {
        numberDaysOfSalesInfo = 0;
        while (numberDaysOfSalesInfo == 0) {
            System.out.print("Please enter the number of days of sales info that you have: ");
            String test;
            if (!(test = alphaScanner.nextLine()).isEmpty()) {
                try {
                    numberDaysOfSalesInfo = Integer.parseInt(test);
                } catch (NumberFormatException e) {
                    System.out.println("Days of sales info can only be integers");
                    numberDaysOfSalesInfo = 0;
                }
            }
        }

    }

}
