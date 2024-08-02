import java.util.Scanner; // Import the Scanner class
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

    // public buildProductArray()
    // {

    // }

    public ArrayList<product> runner(ArrayList<product> x) {
        myProductBuilder = x;

        userNumber = 0;
        while (userNumber == 0) {
            System.out.println("How many products would you like to add?: ");
            String temp;
            if (!(temp = alphaScanner.nextLine()).isEmpty()) {
                try {
                    userNumber = Integer.parseInt(temp);
                } catch (NumberFormatException e) {
                    System.out.println("The number of products must be a positve integer");
                    userNumber = 0;
                }
            }
        }

        for (int i = 0; i < userNumber; i++) {
            System.out.println(" ");
            System.out.println("Information for product " + (i + 1) + ":");
            System.out.println("");
            getProductName();
            getProductNumber();
            getProductWeight();
            getProductNumberStock();
            getProductCost();

            myProductBuilder.add(new product(productName, productNumber, productWeight,
                    productNumberStock, productCost));
            System.out.println("");

        }

        bubbleSort(myProductBuilder);

        for (int j = 0; j < myProductBuilder.size(); j++) {
            System.out.println("Product " + (j + 1) + ":" + myProductBuilder.get(j));
        }

        return myProductBuilder;
    }

    public void bubbleSort(ArrayList<product> pro) {
        int n = pro.size();
        // Integer temp = 0;
        product temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (pro.get(j - 1).returnProductNumber() > pro.get(j).returnProductNumber()) {
                    // swap elements
                    temp = pro.get(j - 1);
                    pro.set(j - 1, pro.get(j));
                    pro.set(j, temp);
                }
            }
        }
    }

    private void getProductName() {
        productName = "";
        while (productName.equals("")) {
            System.out.print("Please enter the product's name: ");
            productName = alphaScanner.nextLine();
        }
    }

    public void getProductNumber() {
        productNumber = 0;
        while (productNumber == 0) {
            System.out.print("Please enter the product's ID: ");
            String test3;
            if (!(test3 = alphaScanner.nextLine()).isEmpty()) {
                try {
                    productNumber = Integer.parseInt(test3);
                    {
                        try {
                            for (int i = 0; i < myProductBuilder.size(); i++) {
                                if (productNumber == myProductBuilder.get(i).returnProductNumber()) {
                                    System.out.println("Product number must be unique");
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
            System.out.print("Please enter the product's weight(in lbs): ");
            String doubleTest;
            if (!(doubleTest = alphaScanner.nextLine()).isEmpty()) {
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
            System.out.print("Please enter the quantity of this product currently in stock: ");
            String test2;
            if (!(test2 = alphaScanner.nextLine()).isEmpty()) {
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
            System.out.print("Please enter each of these product's cost: $");
            String tester = " ";
            if (!(tester = alphaScanner.nextLine()).isEmpty()) {
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
