/*
Assignment 7
Inventory Management Program for Gator Bookstore
Millinh Apilado
CSC 210 - 02
Spring 2020
 */

import java.util.Arrays;
import java.util.Scanner;

//class ArrItemName is the main object array which will contain the items
//However, I've decided I want it to contain the Item Total value as well since I want to avoid creating too much object arrays
//and also so it corresponds to the object easily
class ArrItemName{

    //I set these non-static variables which are gonna be the attributes/elements to be taken inside of my array
    int itemNumber = 0;
    String itemName = "";
    double TotPrice = 0.00;

    //Using the IDE's generator, I've generated a constructor which has the arguments or parameters
    //These parameters are the attributes I would want to assign elements to later on on my main method
    public ArrItemName(int itemNo, String itemName1, double TotPrice) {
        //"this" I found is a keyword to call a repeating constructor/appropriate for overloading
        //I did this so I could reassign the constructor parameters into new variables which will be kind of a "label"
        //once I've started assigning elements to it on the main method
        this.itemNumber = itemNo;
        this.itemName = itemName1;
        this.TotPrice = TotPrice;
    }

    //These are getter methods for the item number of the class object Array
    //I will be able to use this to grab the object;s "item number" using a dot operator after calling the object
    public int getItemNumber() {
        return itemNumber;
    }

    /*
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
     */

    //Another getter but for the Item Name
    public String getItemName() {
        return itemName;
    }

    /*
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
     */

    //Another getter as well but for the Item Total Value
    public double getTotPrice() {
        return TotPrice;
    }

    //A setter method which will help me reassign/set values or elements onto one of the parameters
    //In this case, I could set any double variable/element onto totPrice parameter/argument
    public void setTotPrice(double totPrice) {
        TotPrice = totPrice;
    }
}

//Another object array for the items' quantities
class QuantObjArr{
    //I have set only two non-static variables for this which will be in the object array I wish to create
    int itemNumber = 0;
    int itemQty = 0;

    //Same as above, I have created a constructor for my object quantity array
    public QuantObjArr(int itemNo, int itemQty) {
        this.itemNumber = itemNo;
        this.itemQty = itemQty;
    }

    /*
    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
     */

    //A getter method for the Item's quantity
    //This will help me get a specific quantity of the item using a dot operator after calling the object
    public int getItemQty() {
        return itemQty;
    }

    /*
    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }
     */
}

//Lastly, class for creating my object array containing the Price for the items
class PriceObjArr{
    //non-static variables which includes the price
    //all initialized to 0
    int itemNumber = 0;
    double itemPr = 0.00;

    //Constructor for my object price array
    public PriceObjArr(int itemNo, double itemPr) {
        this.itemNumber = itemNo;
        this.itemPr = itemPr;
    }

    /*
    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
     */

    public double getItemPr() {
        return itemPr;
    }

    /*
    public void setItemPr(double itemPr) {
        this.itemPr = itemPr;
    }
     */
}
public class gatorBookstore {
    public static void main(String[] args) {
        //I created an instance for the object array I've created with 5 total elements
        ArrItemName[] objArrItemName = new ArrItemName[5];

        //I've created an instance for each element of the object array using constructors
        //The constructor contains the attributes for my array, in this case, the number of item, the name of the item, and item total value price
        objArrItemName[0] = new ArrItemName(1, "Notepad", 0.00);
        objArrItemName[1] = new ArrItemName(2, "Pen", 0.00);
        objArrItemName[2] = new ArrItemName(3, "Pencil", 0.00);
        objArrItemName[3] = new ArrItemName(4, "Eraser", 0.00);
        objArrItemName[4] = new ArrItemName(5, "Marker", 0.00);

        Scanner sc = new Scanner(System.in);

        //I've also created an instance for two more object arrays I've created
        //First Array will contain Quantity of each object
        QuantObjArr[] objArrQuant = new QuantObjArr[5];

        //Second Array will contain the Price per Item of each object
        PriceObjArr[] objArrPrice = new PriceObjArr[5];

        double totPricee = 0.00;
        int totQuant = 0;
        double highVal = 0.00;
        double lowVal = 0.00;
        double val = 0.00;
        double grandTot = 0.00;
        double val1 = 0.00;


        //Welcome prompt to users
        System.out.println();
        System.out.println("Welcome back to the Gator Bookstore Inventory!");
        System.out.println("Please enter the corresponding values to the following items");
        System.out.println();

        //This is a for loop to keep the iteration in/through objArrItemName or our main array containing the items
        for (int i = 0; i < 5; i++) {

            //instantiated z inside as a flag in case user input is invalid
            //it is kept outside while loop to keep reassigning z to 0 when user input is invalid and is kicked outside the loop
            int z = 0;
            while(z == 0) {
                //Asks user for quantity of item given
                System.out.println("Please enter the available quantity of " + objArrItemName[i].getItemName() + ": ");
                System.out.print(">>");
                int quant = sc.nextInt();

                //Checks if quantity input by user is valid
                if (quant >= 0) {

                    //If quantity is valid, it automatically assigns the input quantity into the array I've created assigned corresponding to i
                    //i is kind of equivalent to the item we're iterating through the main array
                    objArrQuant[i] = new QuantObjArr(i, quant);

                    //Another flag
                    int y = 0;

                    while(y == 0) {

                        //Asks user for price input
                        System.out.println("Please enter the price for " + objArrItemName[i].getItemName() + ": ");
                        System.out.print(">> $ ");
                        double pricee = sc.nextDouble();

                        if (pricee >= 0.00) {

                            //Same logic as with quantity but this time on its own array as well
                            objArrPrice[i] = new PriceObjArr(i, pricee);

                            //Immediately getting item total value per item iterated
                            val = quant * pricee;
                            //Val gets set as TotPrice or in the Item Total Value category of our main array
                            objArrItemName[i].setTotPrice(val);

                            //Sums three different things:
                            //Total Item Prices (not Item value prices)
                            totPricee += pricee;

                            //Total number of items
                            totQuant += quant;

                            //Grand total of all item total values
                            grandTot += val;

                            //System.out.println("- " + val);
                            //System.out.println("- " + lowVal);

                            //Sets the comparable value to determine which item total values have the lowest and have the highest amounts
                            if (i == 0) {
                                //Using the getter function/method, I was able to get the TotPrice attribute
                                //I first call the object, and using the dot operator, use the getTotPrice() function
                                //First item's price is reassigned to lowVal and to highVal for comparison
                                lowVal = objArrItemName[i].getTotPrice();
                                //System.out.println(val);
                                //System.out.println(lowVal);
                                highVal = objArrItemName[i].getTotPrice();

                            } else {
                                //System.out.println("+ " + val);
                                //System.out.println("+ " + lowVal);

                                //If new item total value price is lower or equal than the previous/current item total value price
                                //then it gets reassigned to another variable called lowVal
                                if (val <= lowVal) {
                                    lowVal = val;
                                    //System.out.println(":" + val);
                                    //System.out.println(":" + lowVal);
                                }
                                //Same logic as lowVal above but instead compares and keeps highest item total values prices
                                if (val >= highVal) {
                                    highVal = val;
                                    //System.out.println(">" + val);
                                    //System.out.println(">" + lowVal);
                                }
                            }
                            //Reassigns y fla to break out of the loop
                            y = 1;

                        //If user input is invalid prompt
                        }else{
                            System.out.println("Please enter valid price value!");
                        }
                    }
                    //Breaks out of the other nested loop
                    z = 1;
                } else {
                    System.out.println("Please enter valid quantity value!");
                }
            }
        }

        int x = 0;
        int count = 0;

        while (x == 0){

            //Prompt to store manager
            System.out.println();
            System.out.println("What would you like to access?");
            System.out.println("Print Inventory (p), Check for Low Inventory (c), Highest and Lowest Inventory Value Items (h), Total Inventory Value (v), Exit (e)");
            System.out.println("Press the corresponding alphabetical key for each function to access: ");
            char ansMan = sc.next().charAt(0);
            System.out.println();

            //Switch and cases that determines next function to execute depending on user input
            switch (ansMan){
                case'p':
                    //Iterates through the arrays
                    for (int i = 0; i < 5; i++){
                        //Using the getter function, we get the specific attribute of each item/object from the object array
                        //it calls the getter method inside the class which gets the element of the attribute
                        //Reassigns each value from the object array into a variable to be displayed later on
                        //it's just easier for me this way but I could technically just type getters and setters
                        //wit multiple print lines
                        int no1 = objArrItemName[i].getItemNumber();
                        String name = objArrItemName[i].getItemName();
                        int qty1 = objArrQuant[i].getItemQty();
                        double price1 = objArrPrice[i].getItemPr();
                        val1 = objArrItemName[i].getTotPrice();

                        //Displays each item information
                        System.out.println(no1 + " " + name + "  Quantity:  " + qty1 + " pc(s)"+ "  Price Per Item:  $" + price1 + "  Item Total Value:  $" + val1);
                    }
                    break;
                case 'c':
                    //Again, iterates through the arrays same as case 'p' above
                    //However, it determines items low on quantity (quant < 5)
                    for (int i = 0; i < 5; i++){
                        int no = objArrItemName[i].getItemNumber();
                        String name1 = objArrItemName[i].getItemName();
                        int quant = objArrQuant[i].getItemQty();
                        double pricet = objArrPrice[i].getItemPr();
                        val1 = objArrItemName[i].getTotPrice();

                        //Checks for quantities that are less than 5 and prints them
                        if (quant < 5){
                            System.out.println(no + " " + name1 + "  Quantity:  " + quant + " pc(s)"+ "  Price Per Item:  $" + pricet + "  Item Total Value:  $" + val1);
                            //If there are quantities less than 5, it iterates count flag of int type
                            count++;
                        }
                    }
                    //If count is zero, this means that there are no quantities less than 5 and will print an appropriate
                    //message
                    if (count == 0){
                        System.out.println("All items have sufficient quantity!");
                    }

                    break;
                case 'h':
                    //Displays the prompt to user to know the items with highest item total values
                    System.out.println(">>Item(s) with the highest total value based on price and stock:<<");

                    //Pretty much the same as the previous cases, it iterates through the arrays and uses getters
                    //To grab specific attribute/information from the object array
                    for (int j = 0; j < 5; j++) {
                        //System.out.println(lowVal);
                        int no2 = objArrItemName[j].getItemNumber();
                        String name2 = objArrItemName[j].getItemName();
                        int qty2 = objArrQuant[j].getItemQty();
                        double price2 = objArrPrice[j].getItemPr();
                        val1 = objArrItemName[j].getTotPrice();

                        //System.out.println(val1);

                        //Since earlier we had determined which item had the highest item total value by comparing each item per iteration
                        //This time, we want to compare each item's item total value to display all equivalent values
                        //This is to make sure we don't only display one item if other items have the same item total value as the highest one determined
                        if (val1 == highVal) {
                            System.out.println();
                            System.out.println(no2 + " " + name2 + "  Quantity:  " + qty2 + "  Price Per Item:  $" + price2 + "  Item Total Value:  $" + highVal);
                        }
                    }
                    System.out.println();

                    //The same logic as the highest item total value loop
                    //Except inside this loop, it compares the items to the determined lowest item total value prices and checks for equivalencies
                    System.out.println(">>Item(s) with the lowest total value based on price and stock:<<");
                    for (int j = 0; j < 5; j++) {
                        //System.out.println(lowVal);
                        int no2 = objArrItemName[j].getItemNumber();
                        String name2 = objArrItemName[j].getItemName();
                        int qty2 = objArrQuant[j].getItemQty();
                        double price2 = objArrPrice[j].getItemPr();
                        val1 = objArrItemName[j].getTotPrice();
                        //System.out.println(val1);
                        if (val1 == lowVal) {
                            System.out.println();
                            System.out.println(no2 + " " + name2 + "  Quantity:  " + qty2 + "  Price Per Item:  $" + price2 + "  Item Total Value:  $" + lowVal);
                        }
                    }
                    break;
                case 'v':
                    //Displays the Sum of Quantities
                    System.out.println("Inventory's Total Quantity: " + totQuant + " pcs");
                    //Displays the Sum of Grand Total in the inventory
                    System.out.println("Inventory's Grand Total Value: $" + grandTot);
                    break;
                case 'e':
                    //Reassigns the flag to break out of the loop if user wishes to exit
                    x = 1;
                    break;

            }
        }
    }
}

