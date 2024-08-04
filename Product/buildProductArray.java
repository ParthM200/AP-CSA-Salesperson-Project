import java.util.Scanner;
import java.util.ArrayList;

public class buildProductArray {

    private int userNumber;

    private String productName;
    private int productNumber;
    private double productWeight;
    private int productNumberStock;
    private double productCost;

    private ArrayList<product> myProductBuilder = new ArrayList<product>();

    Scanner alphaScanner = new Scanner(System.in);
    Scanner numberScanner = new Scanner(System.in);

    public ArrayList<product> runner(ArrayList<product> x) {
        myProductBuilder = x;
        userNumber = 0;

        // Asks user how many products to add
        while (userNumber == 0) {
            System.out.print("How many products would you like to add?: ");
            String temp;
            // Ensures user input is positive and a compatible integer
            if (!(temp = alphaScanner.nextLine()).isEmpty()) {
                try {
                    userNumber = Integer.parseInt(temp);
                } catch (NumberFormatException e) {
                    System.out.println("The number of products must be a positve integer");
                    userNumber = 0;
                }
            }
        }

        // Asks user to input info for userNumber products
        for (int i = 0; i < userNumber; i++) {
            System.out.println(" ");
            System.out.println("Product " + (i + 1) + ":");

            // Gathers all info & adds to arrayList
            getProductName();
            getProductNumber();
            getProductWeight();
            getProductNumberStock();
            getProductCost();

            myProductBuilder.add(new product(productName, productNumber, productWeight,
                    productNumberStock, productCost));

        }

        // Prints all collected info from ArrayList
        System.out.println("\nSummary: \n");

        for (int j = 0; j < myProductBuilder.size(); j++) {
            System.out.println("Product " + (j + 1) + "'s" + myProductBuilder.get(j));
        }
        return myProductBuilder;
    }

    // Gets Product Name & ensures input is not empty
    private void getProductName() {
        productName = "";
        while (productName.equals("")) {
            System.out.print("Enter the product's name: ");
            productName = alphaScanner.nextLine();
        }
    }

    // Gets product ID
    public void getProductNumber() {
        productNumber = 0;
        while (productNumber == 0) {
            System.out.print("Enter the product's ID: ");
            String test3;
            if (!(test3 = alphaScanner.nextLine()).isEmpty()) {
                // Validates that input is an integer
                try {
                    productNumber = Integer.parseInt(test3);
                    {
                        // Checks that product ID is not duplicate
                        try {
                            for (int i = 0; i < myProductBuilder.size(); i++) {
                                if (productNumber == myProductBuilder.get(i).returnProductNumber()) {
                                    System.out.println("Product's ID must be unique");
                                    productNumber = 0;
                                }
                            }
                        }

                        catch (NullPointerException e) {

                        }

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Product Number can only be integers");
                    productNumber = 0;
                }
            }
        }
    }

    public void getProductWeight() {
        productWeight = 0;
        while (productWeight == 0) {
            System.out.print("Enter the product's weight in lbs: ");
            String doubleTest;
            if (!(doubleTest = alphaScanner.nextLine()).isEmpty()) {
                // Validates that user input is a double
                try {
                    productWeight = Double.parseDouble(doubleTest);
                } catch (NumberFormatException e) {
                    System.out.println("Product Weight can only be a double");
                    productWeight = 0;
                }
            }
        }

    }

    public void getProductNumberStock() {
        productNumberStock = 0;
        while (productNumberStock == 0) {
            System.out.print("Enter the inventory count of this item: ");
            String test2;
            if (!(test2 = alphaScanner.nextLine()).isEmpty()) {
                // Validates that input is an integer
                try {
                    productNumberStock = Integer.parseInt(test2);
                } catch (NumberFormatException e) {
                    System.out.println("Inventory count can only be integers");
                    productNumberStock = 0;
                }
            }
        }

    }

    public void getProductCost() {
        productCost = 0;
        while (productCost == 0) {
            System.out.print("Enter the product's unit cost: $");
            String tester = " ";
            if (!(tester = alphaScanner.nextLine()).isEmpty()) {
                // Validates that input is a double
                try {
                    productCost = Double.parseDouble(tester);
                } catch (NumberFormatException e) {
                    System.out.println("Cost can only be a double");
                    productCost = 0;
                }
            }
        }
    }

}
