package project;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.lang.*;
import java.util.ArrayList;

public class Cashier {
    private  int numberOfItems;
    private  double totalSum = 0;
    private  double amount;
    private  int counter = -1, price_index = -1, name_index = -1 ;
    private  String names;
    ArrayList<String> item_names = new ArrayList<String>();
    ArrayList<Double> item_price = new ArrayList<Double>();
    private  String s, name;
    private double price, tendered, change,  dollars, quarters, dimes,   
    nickels, pennies;

    NumberFormat nf = NumberFormat.getInstance();
    DecimalFormat df = (DecimalFormat)nf;

    public Cashier()
    {
       this.name = "";
       this.price = price;
       price = 0;
       this.s = "";
     }

  public double average()
   {
      return totalSum/numberOfItems;
   }
   public void add(String name, double price)
   {	
	   this.counter++;
       totalSum = totalSum + price;
//       s = s + name + "........" + price + "\n";
       this.item_names.add(name);
       this.item_price.add(price);
       numberOfItems++;
   }

   public void makeChange()
   {
         change = amount - totalSum;
         change = 100 * change;
         change = Math.round(change);
         change = change / 100;
         dollars = (int)(amount - totalSum) * 100 / 100;
         pennies = (int)(change * 100) % 100;
         quarters = (int)pennies / 25;
         pennies = (int)pennies % 25;
         dimes = (int)pennies / 10;
         pennies = (int)pennies % 10;
         nickels = (int)pennies / 5;
         pennies = (int)pennies % 5;
         pennies = (int)pennies;
    }
   public String getNames()
   { 
	   this.name_index++;
	   System.out.println("name index: " + this.name_index );
	   return this.item_names.get(this.name_index);
   }
   public double getPrices()
   {
	   this.price_index++;
	   System.out.println("price index: " + this.price_index);
	   return Math.abs(this.item_price.get(this.price_index));
   }
   public double getTotal()
   {
	System.out.println("totalSum " + totalSum);
      return Math.abs(totalSum);
   }
   public double getMoney()
   {
   	System.out.println("tendered " + tendered);
	   return Math.abs(tendered);
   }
   public double getChange()
   {
	   double score = tendered - totalSum;
	   System.out.println("score " + score);
	   return Math.abs(score) ;
   }
   public double getQuantity()
   {
   	System.out.println("numberOfItems " + numberOfItems);
	   return Math.abs(numberOfItems);
   }
   public double getAverage()
   {
   	System.out.println("");
	   return average();
   }
   public double getDollars()
   {
   	System.out.println("dollars " + dollars);
	   return Math.abs(dollars);
    }
    public double getQuarters()
    {
    	System.out.println("quarters " + quarters);
    	return Math.abs(quarters);
    }
    public double getDimes()
    {
    	System.out.println("dimes " + dimes);
    	return Math.abs(dimes);
    }
    public double getNickels()
    {
    	System.out.println("nickels " + nickels);
    	return Math.abs(nickels);
    }
    public double getPennies()
    {
    	System.out.println("pennies " + pennies);
    	return Math.abs(pennies);
    }

    public void tendered(double amount)
    {
		// double tendered;
		tendered = Math.abs(amount);
    }

}
