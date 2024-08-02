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

        // One line comment for program here
        for (int i = 0; i < salesPerson.length; i++) {
            captureSalesPersonInformation();
            salesPerson[i] = new SalesPerson(salesPersonLastName, salesPersonFirstName,
                    salesPersonIDNumber, salesPersonDailyGoal, numberDaysOfSalesInfo);

            // One line comment for segment here
            for (int j = 0; j < numberDaysOfSalesInfo; j++) {
                dayXInfo = 0.0;
                while (dayXInfo == 0.0) {
                    System.out.print("Please enter the sales for day " + (j + 1) + ":");
                    System.out.println("");
                    String doubleTest2;
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

            System.out.println(salesPerson[i]);

            // One Line Comment For This Section
            for (int k = 0; k < numberDaysOfSalesInfo; k++) {
                System.out.println("The sales for day " + (k + 1) + " are: $" + salesPerson[i].returnAmount(k) +
                        "0 and the sales percentage achieved was: " + salesPerson[i].percentageDailySales(k) + "0%");
            }

            totalPer = (totalSales / (salesPersonDailyGoal)) * 100;
            totalPer = Math.round(10.0 * totalPer) / 10.0;

            System.out.println("Total sales are: $" + totalSales +
                    "0 and the total percentage acheived was " + totalPer + "%");
            System.out.println();
        }

        // One Line Comment For Section Here
        for (int i = 0; i < salesPerson.length; i++) {
            dailyGoalTotal += salesPerson[i].returnSPDailyGoal();
        }

        System.out.println("The total of all sales goals is $" + dailyGoalTotal);

        System.out.println("Before insertion sort: ");
        System.out.println("");
        for (int i = 0; i < salesPerson.length; i++) {
            System.out.println(salesPerson[i]);
        }

        insertionSort(salesPerson);
        System.out.println("After insertion sort: ");
        System.out.println("");

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

    // One line comment for method
    public void insertionSort(SalesPerson[] nums) {
        for (int i = 1; i < nums.length; i++) {
            SalesPerson value = nums[i];
            int j = i - 1;
            while ((j > -1) && nums[j].returnSPIDNumber(j) > value.returnSPIDNumber(i)) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = value;
        }
    }

    // One Line Comment For Method
    public void captureSalesPersonInformation() {
        getSalesPersonLastName();
        getSalesPersonFirstName();
        getSalesPersonIDNumber();
        getSalesPersonDailyGoal();
        getNumberDaysOfSalesInfo();
    }

    // One Line Comment For Method
    public void getSalesPersonLastName() {
        salesPersonLastName = "";
        while (salesPersonLastName.equals("")) {
            System.out.print("Please enter the sales person's last name: ");
            salesPersonLastName = alphaScanner.nextLine();
        }
    }

    // One Line Comment for Mehtod
    public void getSalesPersonFirstName() {
        salesPersonFirstName = "";
        while (salesPersonFirstName.equals("")) {
            System.out.print("Please enter the sales person's first name: ");
            salesPersonFirstName = alphaScanner.nextLine();
        }
    }

    // One Line Comment For Method
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

    // One Line Comment For Method
    public void getSalesPersonDailyGoal() {
        salesPersonDailyGoal = 0;
        while (salesPersonDailyGoal == 0) {
            System.out.print("Please enter the sales person's daily goal(in dollars): ");
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

    // One Line Comment For Method
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
