public class SalesPerson {
    private String salesPersonLastName;
    private String salesPersonFirstName;
    private int salesPersonIDNumber;
    private double salesPersonDailyGoal;
    private int numberDaysOfSalesInfo;

    private Double[] globalArray;
    private Integer[] globalArray2;

    // Overloaded Constructor to build info for each employee
    public SalesPerson(String sPLN, String sPFN, int sPID, double sPDG,
            int nDOSI) {
        salesPersonLastName = sPLN;
        salesPersonFirstName = sPFN;
        salesPersonIDNumber = sPID;
        salesPersonDailyGoal = sPDG;
        numberDaysOfSalesInfo = nDOSI;
        globalArray = new Double[nDOSI];
    }

    public void updateSPDailyGoal(double amount) {
        salesPersonDailyGoal = amount;
    }

    public double returnSPDailyGoal() {
        return salesPersonDailyGoal;
    }

    public void updateDayOfSale(int day, double amount) {
        globalArray[day] = amount;
    }

    public void updateSPIDNumber(int position, int number) {
        globalArray2[position] = number;
    }

    public int returnSPIDNumber(int elementNumber) {
        return salesPersonIDNumber;
    }

    public double returnAmount(int elementNumber) {
        return globalArray[elementNumber];
    }

    // Calculates employee's daily sales achieved as a percentage
    public double percentageDailySales(int elementNumber) {
        double j = globalArray[elementNumber];
        double newDouble = (j) / (salesPersonDailyGoal) * 100;
        newDouble = Math.round(10.0 * newDouble) / 10.0;
        return newDouble;
    }

    public String toString() {
        return "Summary: \nThe Sales Person's name is " + salesPersonFirstName + " " + salesPersonLastName
                + "\n" + salesPersonFirstName + "'s ID is: " + salesPersonIDNumber + "\n" + salesPersonFirstName
                + "'s daily goal is $" + salesPersonDailyGoal +
                " dollars \nThey have " + numberDaysOfSalesInfo + " days of sales info\n";
    }
}
