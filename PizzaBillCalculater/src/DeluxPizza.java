// Delux pizza extend the class Pizza
public class DeluxPizza extends Pizza{
   //Delux pizza inbuilt add cheese and toppings
   DeluxPizza(boolean isVeg){
    super(isVeg); // calling the parent class constructor with parameter
    addExtraCheese();
    addToppings();
   }
}