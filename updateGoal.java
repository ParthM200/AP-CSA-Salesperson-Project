import java.util.Scanner;

public class updateGoal {
    Scanner alphaScanner = new Scanner(System.in);
    Scanner numberScanner = new Scanner(System.in);
    private int originalID;
    private int newID;
    private double updatedGoal;
    private SalesPerson[] salesPerson;

    public updateGoal() {

    }

    public SalesPerson[] runner(SalesPerson[] x) {
        salesPerson = x;
        originalID = 0;

        // Verifies that Sales Person database exists
        try {

        } catch (NullPointerException e) {
            System.out.println("Salesperson Database hasn't been created yet");
            return salesPerson;
        }

        while (originalID == 0) {

            System.out.print("Please enter the salesperson's original ID: ");
            String test = " ";

            if (!(test = numberScanner.nextLine()).isEmpty()) {
                // Data validation to ensure input is in number format
                try {
                    originalID = Integer.parseInt(test);
                    for (int i = 0; i < salesPerson.length; i++) {
                        // Ensures inputted ID matches existing record in database
                        try {
                            if (originalID == salesPerson[i].returnSPIDNumber(i)) {
                                updatedGoal = 0.0;
                                while (updatedGoal == 0.0) {
                                    System.out.println("The salesperson's current goal is $"
                                            + salesPerson[i].returnSPDailyGoal() + "0");

                                    System.out.println("What is the new goal you want that salesPerson to have?");
                                    String doubleTest2;
                                    if (!(doubleTest2 = alphaScanner.nextLine()).isEmpty()) {
                                        // Ensures new inputted goal is in double format
                                        try {
                                            updatedGoal = Double.parseDouble(doubleTest2);
                                        } catch (NumberFormatException e) {
                                            System.out.println("Daily Goal value can only be a double");
                                            updatedGoal = 0.0;
                                        }
                                    }
                                    // Updates and returns new daily goal for sales person
                                    salesPerson[i].updateSPDailyGoal(updatedGoal);
                                    System.out.println("The salesperson's new goal is now: $"
                                            + salesPerson[i].returnSPDailyGoal() + "0");
                                    return salesPerson;
                                }
                                break;
                            }

                        } catch (NullPointerException e) {
                            System.out.println("SalesPersonID does not exist in the database, please try again");
                            originalID = 0;
                        }
                    }

                    System.out.println("SalesPerson does not exist in the database, please try again");
                    originalID = 0;

                } catch (NumberFormatException e) {
                    System.out.println("SalesPerson ID can only be integers");
                    newID = 0;
                }

            }

        }

        return salesPerson;
    }

}
