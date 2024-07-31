import java.util.Scanner;
import java.util.ArrayList;

public class updateProductInfo {

    private ArrayList<product> myProductBuilder = new ArrayList<product>();

    Scanner alphaScanner = new Scanner(System.in);
    Scanner numberScanner = new Scanner(System.in);

    private int fieldSelection;

    private String productName = " ";
    private double productWeight;
    private double productCost;
    private int productID;
    private int productStock;
    private int tester;

    private int variableTester;

    private int counter = 0;

    public updateProductInfo() {

    }

    public ArrayList<product> runner(ArrayList<product> x) {
        myProductBuilder = x;

        checkID();
        loop: if (productID >= 0) {
            getFieldSelection();
            if (fieldSelection == 1) {
                updateProductName();
            } else if (fieldSelection == 2) {
                updateProductWeight();
            } else if (fieldSelection == 3) {
                updateProductStock();
            } else if (fieldSelection == 4) {
                updateProductCost();
            } else if (fieldSelection == 5) {
                updateProductWeight();
                System.out.println(" ");
                updateProductStock();
                System.out.println(" ");
                updateProductCost();
                System.out.println(" ");
                updateProductName();
                System.out.println(" ");
                break loop;
            }
        } else {
            System.out.println("You must enter a valid product ID");
            productID = 0;
            checkID();
        }
        return myProductBuilder;
    }

    public void checkID() {
        productID = 0;
        loop: while (productID == 0) {
            System.out.print("Please enter the ID of the product you would like to update: ");
            String test01 = " ";
            if (!(test01 = numberScanner.nextLine()).isEmpty()) {
                try {
                    productID = Integer.parseInt(test01);
                    for (product tx : myProductBuilder) {
                        try {
                            if (productID == tx.returnProductNumber()) {
                                tester = (counter + 1);
                                productID = Integer.parseInt(test01);
                                variableTester = (counter + 1);
                                break loop;
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Product ID does not exist in the database, please try again");
                            productID = 0;
                        }
                        counter++;
                    }
                    System.out.println("Product does not exist in the database, please try again");
                    productID = 0;
                } catch (NumberFormatException e) {
                    System.out.println("Product ID can only be integers");
                    productID = 0;
                }
            }
        }
    }

    public void getFieldSelection() {
        fieldSelection = 0;
        while (fieldSelection == 0) {
            System.out.println(
                    "Enter 1 to update product name, 2 to update product weight, 3 to update product stock, 4 to update product cost, 5 to udpate all fields at once");
            String doubleTest10;
            if (!(doubleTest10 = alphaScanner.nextLine()).isEmpty()) {
                try {
                    fieldSelection = Integer.parseInt(doubleTest10);
                } catch (NumberFormatException e) {
                    System.out.println("Entry can only be an integer");
                    fieldSelection = 0;
                }
            } else {
                System.out.println("You must select option 1, 2, 3, 4, or 5! ");
                fieldSelection = 0;
            }
        }
    }

    public void updateProductName() {
        System.out.println("The product's current name is  " + myProductBuilder.get(counter).returnProductName());
        System.out.println("What is the new name you want the product to have? ");
        String doubleTest2 = "";
        if (!(doubleTest2 = alphaScanner.nextLine()).isEmpty()) {
            try {
                productName = doubleTest2;
            } catch (NullPointerException e) {
                System.out.println("You must enter something for the product name");
            }
        }
        myProductBuilder.get(tester).updateProductName(productName);
        System.out.println("The product's new name is: " + myProductBuilder.get(tester).returnProductName());
    }

    public void updateProductWeight() {
        productWeight = 0.0;
        while (productWeight == 0.0) {
            System.out.println(
                    "The product's current weight is  " + myProductBuilder.get(counter).returnProductWeight() + "0");
            System.out.println("What is the new weight you want the product to have? ");
            String doubleTest2;
            if (!(doubleTest2 = alphaScanner.nextLine()).isEmpty()) {
                try {
                    productWeight = Double.parseDouble(doubleTest2);
                } catch (NumberFormatException e) {
                    System.out.println("Product Weight can only be a double");
                    productWeight = 0.0;
                }
            }
            myProductBuilder.get(counter).updateProductWeight(productWeight);
            System.out.println(
                    "The product's new weight is: " + myProductBuilder.get(counter).returnProductWeight() + "0");
        }
    }

    public void updateProductStock() {
        productStock = 0;
        while (productStock == 0) {
            System.out.println("The product's current stock is  " + myProductBuilder.get(counter).returnProductStock());
            System.out.println("What is the new stock you want the product to have? ");
            String doubleTest8;
            if (!(doubleTest8 = alphaScanner.nextLine()).isEmpty()) {
                try {
                    productStock = Integer.parseInt(doubleTest8);
                } catch (NumberFormatException e) {
                    System.out.println("Product Stock can only be an int");
                    productStock = 0;
                }
            }
        }
        myProductBuilder.get(counter).updateProductNumberStock(productStock);
        System.out.println("The product's new stock is: " + myProductBuilder.get(counter).returnProductStock());
    }

    public void updateProductCost() {
        productCost = 0.0;
        while (productCost == 0.0) {
            System.out.println(
                    "The product's current cost is $" + myProductBuilder.get(counter).returnProductCost() + "0");
            System.out.println("What is the new cost you want the product to have? ");
            String doubleTest3;
            if (!(doubleTest3 = alphaScanner.nextLine()).isEmpty()) {
                try {
                    productCost = Double.parseDouble(doubleTest3);
                } catch (NumberFormatException e) {
                    System.out.println("Product Cost can only be a double");
                    productCost = 0.0;
                }
            }
            myProductBuilder.get(counter).updateProductCost(productCost);
            System.out.println("The product's new cost is: " + myProductBuilder.get(counter).returnProductCost() + "0");
        }
    }
}