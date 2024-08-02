import java.util.Scanner; // Import the Scanner class

public class build {

    // change each variable from public to private and also take out the static
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

    /*************************************
     * The main method calls the high
     * level methods to complete the
     * sales person project.
     ************************************/
    public SalesPerson[] runner(SalesPerson[] x) {
        salesPerson = x;
        setup();

        System.out.println("How many sales people do you want to enter?");
        salesPeople = numberScanner.nextInt();

        salesPerson = new SalesPerson[salesPeople];

        /***************************************
         * The array below will first define i so that the array runs a total of 3 times
         * Then the array will ask the user to enter the 5 values through the
         * captureSalesPersonInformation method,
         * and it will store and print them in an instance of the salesPerson object
         * Then the array will cycle back through everything until "i <
         * salesPerson.length" is not true anymore
         * 
         * Precondition: The "captureSalesPersonInformation" method has been created,
         * the array salesPerson,
         * has been created and instantiated, the 5 variables regarding SP info have
         * been defined,
         * the SalesPerson object has been created and defined, and the variable
         * "dailyGoalTotal" has been
         * defined
         * 
         * Postcondition: 3 instances of the SalesPerson object will be created and
         * printed based on user input
         * for each object
         ***************************************/
        for (int i = 0; i < salesPerson.length; i++) {
            captureSalesPersonInformation();
            salesPerson[i] = new SalesPerson(salesPersonLastName, salesPersonFirstName,
                    salesPersonIDNumber, salesPersonDailyGoal, numberDaysOfSalesInfo);
            /***************************************
             * The loop below will ask the user to enter each day's sales info for the
             * amount of days that they
             * entered. It will also run data validation to make sure that the value the
             * user enters is a double
             * Lastly, at the end of the loop, it will allocate all of those values to each
             * salesPerson object created through
             * the "updateDayOfSale" method, using the j value from the loop as well as each
             * day's info as the receiving
             * variables. Additionally, the loop using "k" below will extract each sales
             * amount allocated to the salesPerson Object
             * using the ".returnAmount(k)" method from the SalesPerson Object to print
             * every day's sales that the user entered.
             * 
             * Precondition: An instance of the salesPerson object has been created and the
             * user has defined how many days of sales info they have
             * for the salesPerson object
             * 
             * Postcondition: Each day's amount will be allocated to the corresponding
             * salesPerson object, and the entered value will be
             * validated to make sure that only doubles are passed to the object and not a
             * different data type. Each day's sales info wil also be
             * printed to the user.
             ***************************************/
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

            // System.out.println("(Before Insertion Sort)");
            System.out.println(salesPerson[i]);

            /***************************************
             * The loop below will print out the sales for each day that the user entered as
             * well as how much
             * of the total goal's percentage that is, and then after that it will calculate
             * the total
             * sales percentage using the totalSales that the user enters and dividing that
             * by the
             * person's goal to get the percentage, and it will use the math.round method to
             * clean up the percentage
             * 
             * Precondition: The numberDaysOfSalesInfo variable has been defined and entered
             * by the user
             * and the user entered sales amounts for each day that they had
             * 
             * Postcondition: The sales for each day (and their percentage of the daily
             * goal) will be printed,
             * and the total sales and its percentage of the daily goal will also be printed
             ***************************************/
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

        /***************************************
         * The array below will use the returnSPDailyGoal method to extract the daily
         * goal value of each
         * instance of the SalesPerson created in the previous array and add them all up
         * together
         * Then the array will cycle back through everything until "i <
         * salesPerson.length" is not true anymore
         * 
         * Precondition: The array salesPerson has been created and instantiated, the
         * SalesPerson object has been created and defined,
         * and the variable "dailyGoalTotal" has been defined
         * 
         * Postcondition: The dailyGoalTotal of all 3 sales people will be added up
         * together
         ***************************************/
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

    /***************************************
     * The setup method will instantiate any objects needed
     * Precondition: The Scanners have been defined as global variables
     * Postcondition: The scanner have been instantiated
     ***************************************/

    public void setup() {
        alphaScanner = new Scanner(System.in); // Create a Scanner object
        numberScanner = new Scanner(System.in); // Create a Scanner object
    }

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

    /***************************************
     * The captureSalesPersonInformation method will ask the user to enter
     * inforrmation about the sales person: last name, first name, ID, daily goal
     * and number of days of sales to be entered
     * Precondition: The Scanners have been instantiated, the variables used have
     * been defined as global variables
     * Postcondition: The global variables will hold the information about the
     * saleperson.
     ***************************************/

    public void captureSalesPersonInformation() {
        getSalesPersonLastName();
        getSalesPersonFirstName();
        getSalesPersonIDNumber();
        getSalesPersonDailyGoal();
        getNumberDaysOfSalesInfo();
    }

    /***************************************
     * The printSalesPersonReports method will print the inforrmation about the
     * sales person: last name, first name, ID, daily goal and number of days of
     * sales to be entered
     * Precondition: The variables used have been captured and validated.
     * Postcondition: The inforrmation about each sales person will be printed.
     ***************************************/

    public void printSalesPersonReports() {

    }

    /***************************************
     * The getSalesPersonLastName method will print a message to the user and then
     * read the sales person's last name.
     * Precondition: The global variable used and the global scanner have been
     * defined.
     * Postcondition: The input from the user will be stored in the
     * salesPersonLastName global variable.
     ***************************************/
    public void getSalesPersonLastName() {
        salesPersonLastName = "";
        while (salesPersonLastName.equals("")) {
            System.out.print("Please enter the sales person's last name: ");
            salesPersonLastName = alphaScanner.nextLine();
        }
    }

    /***************************************
     * The getSalesPersonFirstName method will print a message to the user and then
     * read the sales person's first name.
     * Precondition: The global variable used and the global scanner have been
     * defined.
     * Postcondition: The input from the user will be stored in the
     * salesPersonFirstName global variable.
     ***************************************/
    public void getSalesPersonFirstName() {
        salesPersonFirstName = "";
        while (salesPersonFirstName.equals("")) {
            System.out.print("Please enter the sales person's first name: ");
            salesPersonFirstName = alphaScanner.nextLine();
        }
    }

    /***************************************
     * The getSalesPersonIDNumber method will print a message to the user to enter
     * the sales person's ID Number
     * will validate to make sure that the user input is the correct data type and
     * matches what the
     * program expects for the method.
     * Precondition: The global variable used and the global scanner have been
     * defined.
     * Postcondition: The input from the user will be validated to make sure the
     * correct data type was entered and will
     * store the appropriate value in the getSalesPersonIDNumber variable.
     ***************************************/
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

    /***************************************
     * The getSalesPersonDailyGoal method will print a message to the user to enter
     * the sales person's Daily Goal and
     * will validate to make sure that the user input is the correct data type and
     * matches what the
     * program expects.
     * Precondition: The global variable used and the global scanner have been
     * defined.
     * Postcondition: The input from the user will be validated to make sure the
     * correct data type was entered and will
     * store the appropriate value in the salesPersonDailyGoal variable.
     ***************************************/
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

    /***************************************
     * The getNumberDaysOfSalesInfo method will print a message to the user to enter
     * the sales person's days of info and
     * will validate to make sure that the user input is the correct data type and
     * matches what the
     * program expects for the method.
     * Precondition: The global variable used and the global scanner have been
     * defined.
     * Postcondition: The input from the user will be validated to make sure the
     * correct data type was entered and will
     * store the appropriate value in the getNumberDaysOfSalesInfo variable.
     ***************************************/
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
