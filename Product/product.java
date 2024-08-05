import java.text.DecimalFormat;

public class product {
    private String productName;
    private int productNumber;
    private double productWeight;
    private int productNumberStock;
    private double productCost;

    public product(String pName, int pNumber, double pWeight, int pStock, double pCost) {
        productName = pName;
        productNumber = pNumber;
        productWeight = pWeight;
        productNumberStock = pStock;
        productCost = pCost;
    }

    public void updateProductName(String name) {
        productName = name;
    }

    public void updateProductNumber(int number) {
        productNumber = number;
    }

    public void updateProductWeight(double weight) {
        productWeight = weight;
    }

    public void updateProductNumberStock(int stock) {
        productNumberStock = stock;
    }

    public void updateProductCost(double cost) {
        productCost = cost;
    }

    public String returnProductName() {
        return productName;
    }

    public int returnProductNumber() {
        return productNumber;
    }

    public double returnProductWeight() {
        return productWeight;
    }

    public double returnProductStock() {
        return productNumberStock;
    }

    public double returnProductCost() {
        return productCost;
    }

    public String toString() {
        // Ensures every product cost is printedin the same format
        DecimalFormat df = new DecimalFormat("#.00");
        return " name is " + productName + ", its ID is "
                + productNumber + ", it weighs " + df.format(productWeight) + " lbs, there are " + productNumberStock
                + " of these in stock, and its unit cost is $" + df.format(productCost);
    }

}
