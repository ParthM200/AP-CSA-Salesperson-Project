public class SalesPerson {
    private String salesPersonLastName;
    private String salesPersonFirstName;
    private int salesPersonIDNumber;
    private double salesPersonDailyGoal;
    private int numberDaysOfSalesInfo;

    //private Double dailySalesAmount;

    private Double[] globalArray;
    private Integer[] globalArray2;

    public SalesPerson() {

    }

    public SalesPerson(String sPLN, String sPFN, int sPID, double sPDG,
            int nDOSI) {
        salesPersonLastName = sPLN;
        salesPersonFirstName = sPFN;
        salesPersonIDNumber = sPID;
        salesPersonDailyGoal = sPDG;
        numberDaysOfSalesInfo = nDOSI;
        globalArray = new Double[nDOSI];
    }

    /***************************************
     * This SalesPerson overloaded constructor will ask for input for the sales
     * person's first and last name
     * as well as their ID number. It will use default values of 12.33 and 4 for the
     * sales person's daily goal and
     * the number of days of sales info that they have, and it will combine all of
     * that data to initialize a
     * version of the salesPerson object.
     * 
     * Precondition: All 5 variables have been defined and the appropriate variables
     * have been
     * passed into this constructor.
     * 
     * Postcondition: An instance of the salesPerson object will be printed based on
     * user input for the first and last name and ID number and the default values
     * for their daily goal and the
     * # of days of sales info they have
     ***************************************/
    public SalesPerson(String sPLN, String sPFN, int sPID) {
        salesPersonLastName = sPLN;
        salesPersonFirstName = sPFN;
        salesPersonIDNumber = sPID;
        salesPersonDailyGoal = 12.33;
        numberDaysOfSalesInfo = 4;
    }

    /***************************************
     * This SalesPerson overloaded constructor will ask for input for the sales
     * person's daily goal and
     * the number of days of sales info that they have. It will use default values
     * for
     * the first and last name and ID number, and it will combine all of that data
     * to initialize an instance
     * of the salesPerson object.
     * 
     * Precondition: All 5 variables have been defined and the appropriate variables
     * have been
     * passed into this constructor.
     * 
     * Postcondition: An instance of the salesPerson object will be printed based on
     * user input for their daily goal and the # of days of sales info they have and
     * the default values for
     * their first and last name and ID number.
     ***************************************/
    public SalesPerson(double sPDG, int nDOSI) {
        salesPersonLastName = "Smith";
        salesPersonFirstName = "John";
        salesPersonIDNumber = 233;
        salesPersonDailyGoal = sPDG;
        numberDaysOfSalesInfo = nDOSI;
    }

    /***************************************
     * This updateSPDailyGoal void method will assign the value 75.99 to
     * the salesPersonDailyGoal double, regardless of what the user inputted for
     * that value
     * 
     * Precondition: The instance variable updateSPDailyGoal has been defined
     * 
     * Postcondition: The value 75.99 will be assigned to the updateSPDailyGoal
     * variable for any object that calls this method
     ***************************************/
    public void updateSPDailyGoal(double amount) {
        salesPersonDailyGoal = amount;
    }

    /***************************************
     * This returnSPDailyGoal void method will take whatever value is entered for
     * salesPersonDailyGoal
     * and return/save that value to be referenced anywhere
     * 
     * Precondition: The instance variable updateSPDailyGoal has been defined
     * 
     * Postcondition: The value entered by the user for this variable will be saved
     * for any object that calls this method
     ***************************************/
    public double returnSPDailyGoal() {
        return salesPersonDailyGoal;
    }

    /***************************************
     * The updateDayOfSale method will take an integer (the corresponding day of
     * sales info)
     * and double (the amount for that day), and allocate the amount to that
     * corresponding day
     * in the array
     * 
     * Precondition: The parameters "day" and "amount" are properly passed to the
     * method, and
     * the array globalArray has been defined
     * 
     * Postcondition: The amount parameter will be allocated to the corresponding
     * day value in the array.
     * There is no return value since this is a void method
     ***************************************/
    public void updateDayOfSale(Integer day, Double amount) {
        globalArray[day] = amount;
    }

    public void updateSPIDNumber(Integer position, Integer number) {
        globalArray2[position] = number;
    }

    public Integer returnSPIDNumber(Integer elementNumber) {
        return salesPersonIDNumber;
    }

    /***************************************
     * This returnAmount method will take the element number of the array as a
     * parameter and
     * return the sales amount at that value. It is almost like the reverse of the
     * above method,
     * because instead of passing a value to an element, it return the value from
     * that element.
     * 
     * Precondition: The elementNumber parameter is properly passed when calling
     * this method,
     * the value at that elementNumber is defined and existing in the array, and the
     * array is defined
     * 
     * Postcondition: The method will return the Double sales amount at the
     * corresponding element number
     * when called
     ***************************************/
    public Double returnAmount(Integer elementNumber) {
        return globalArray[elementNumber];
    }

    /***************************************
     * This percentageDailySales Wrapper Class extracts the corresponding sales
     * value from
     * the element (day value) in the array and assigned to a Double called "j"
     * That J value is then divided by the salesPersonDailyGoal to get the sales
     * percentage
     * acheived for that day, and it is multiplied by 100 to get converted to a
     * percentage amount
     * and then returned from the method
     * 
     * Precondition: The elementNumber parameter is properly passed when calling
     * this method,
     * the value at that elementNumber is defined and existing in the array, and the
     * array is defined
     * 
     * Postcondition: The method will return the percentageofDailySales that the
     * salesperson achieved
     * in that day
     ***************************************/
    public Double percentageDailySales(Integer elementNumber) {
        Double j = globalArray[elementNumber];
        Double newDouble = (j) / ((salesPersonDailyGoal) * 3) * 100;
        newDouble = Math.round(10.0 * newDouble) / 10.0;
        return newDouble;
    }

    public String toString() {
        return "The Sales Person's name is " + salesPersonFirstName + " " + salesPersonLastName
                + "\nTheir ID number is " + salesPersonIDNumber + "\nTheir daily goal is $" + salesPersonDailyGoal +
                " dollars \nThey have " + numberDaysOfSalesInfo + " days of sales info\n";
    }
}
