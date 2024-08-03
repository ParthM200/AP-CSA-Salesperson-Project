public class SalesPerson {
    private String salesPersonLastName;
    private String salesPersonFirstName;
    private int salesPersonIDNumber;
    private double salesPersonDailyGoal;
    private int numberDaysOfSalesInfo;

    

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

    // One Line comment for method
    public SalesPerson(String sPLN, String sPFN, int sPID) {
        salesPersonLastName = sPLN;
        salesPersonFirstName = sPFN;
        salesPersonIDNumber = sPID;
        salesPersonDailyGoal = 12.33;
        numberDaysOfSalesInfo = 4;
    }

    // One Line comment for method
    public SalesPerson(double sPDG, int nDOSI) {
        salesPersonLastName = "Smith";
        salesPersonFirstName = "John";
        salesPersonIDNumber = 233;
        salesPersonDailyGoal = sPDG;
        numberDaysOfSalesInfo = nDOSI;
    }

    // One Line comment for method
    public void updateSPDailyGoal(double amount) {
        salesPersonDailyGoal = amount;
    }

    // One Line comment for method
    public double returnSPDailyGoal() {
        return salesPersonDailyGoal;
    }

    // One Line comment for method
    public void updateDayOfSale(Integer day, Double amount) {
        globalArray[day] = amount;
    }

    public void updateSPIDNumber(Integer position, Integer number) {
        globalArray2[position] = number;
    }
    
    public Integer returnSPIDNumber(Integer elementNumber) {
        return salesPersonIDNumber;
    }

    // One Line comment for method
    public Double returnAmount(Integer elementNumber) {
        return globalArray[elementNumber];
    }

   // One Line comment for method
    public Double percentageDailySales(Integer elementNumber) {
        Double j = globalArray[elementNumber];
        Double newDouble = (j) / ((salesPersonDailyGoal) * 3) * 100;
        newDouble = Math.round(10.0 * newDouble) / 10.0;
        return newDouble;
    }

    @Override
    public String toString() {
        return "The Sales Person's name is " + salesPersonFirstName + " " + salesPersonLastName
                + "\nTheir ID number is " + salesPersonIDNumber + "\nTheir daily goal is $" + salesPersonDailyGoal +
                " dollars \nThey have " + numberDaysOfSalesInfo + " days of sales info\n";
    }
}
