public class Pizza {
  private static int basePrice; // based on veg or no veg pizza
  private static int toppings;  // based on veg or no veg pizza
  private final static int cheese = 80; // Independent price
  private final static int bag = 20; // Independent price
  private static  int total;
  static String pizzaType;
  
  private boolean isVeg; // to selelct veg or non veg pizza

  static boolean extraCheese = false; // to avoid repeted call
  static boolean extraToppings = false; // to avoid repeted call
  static boolean takeAway = false; // to avoid repeted call

 
  Pizza(boolean isVeg) { // constructor to initiaize according to our selection and We are assinging basePrice and Toppings based on our choice
    this.isVeg = isVeg;
    if(isVeg){ // if true it is veg pizza
      pizzaType = "VEG PIZZA";
        basePrice = 300;
        toppings = 70;
        total = 300; // total will be atleast basePrice
      }
    else {   // if false it is Nog-veg pizza
       pizzaType = "NON-VEG PIZZA";
        basePrice = 400;
        toppings = 120;
        total = 400; // total will be atleast basePrice
    }
  }
  public static void addExtraCheese(){ // if extra cheese needed
    if(extraCheese == false){
        total = total + cheese; // add cheese price to total
        extraCheese = true;
    } 
  } 
  public static void addToppings(){  // if toppings needed
    if(extraToppings == false){
        total = total + toppings; // add topping price to total
        extraToppings = true;
    } 
  } 
  public static void addBag(){  // if takeaway needed
    if(takeAway == false){
        total = total + bag; // add bag price to total
        takeAway = true;
    } 
  } 
  public static String generateBill(){ // bill will be added based on the function called
    // System.out.println(pizzaType);
     String bill = "Base price of the Pizza: "+ basePrice +"\n";
     if(extraCheese){
        bill = bill + "Extra cheese Added: "+ cheese +"\n";
     }
     if(extraToppings){
        bill = bill + "Extra Toppings Added: "+ toppings +"\n";
     }
     if(takeAway){
        bill = bill + "Paper bag Added: "+ bag +"\n";
     }
     bill = bill+"Total Price: "+ total;
     return bill;
  }
}
