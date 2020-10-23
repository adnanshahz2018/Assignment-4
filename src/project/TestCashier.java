package project;
import project.Cashier;

import java.io.IOException;  
import java.net.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;  


public class TestCashier {
	public static void main(String[] args) 
	{
		String name;
		double price;
		Cashier c = new Cashier();
		
		name = GetData.getWord("Enter name of item");
		price = GetData.getDouble("Enter price of item");
		c.add(name, price);
		
		name = GetData.getWord("Enter name of item");
		price = GetData.getDouble("Enter price of item");
		c.add(name, price);
		
		name = GetData.getWord("Enter name of item");
		price = GetData.getDouble("Enter price of item");
		c.add(name, price);
		
		//Now average the price of the items
		c.average();
		
		//Make payment
		double amount = GetData.getDouble("Enter amount of money for payment");
		c.tendered(amount);
		
		c.makeChange();
		generateReceipt(c);
	}

	public static void generateReceipt(Cashier c)
	{
	
		String s= "ABC Groceries Shop \n";
		
		s = s + "Welcome – Thanks for stopping, \n";
		
		DateFormat df = DateFormat.getDateInstance();
		
		Date d = new Date();
		
		NumberFormat f = NumberFormat.getCurrencyInstance();
		
		s = s + "Today is " + df.format(d) + "\n\n";
		
//		s = s + "Item:" +(c.getNames());
		   //\n";
		
		
		s = s + c.getNames() + "..... " + f.format(c.getPrices()) + "\n" + c.getNames() +
		    "..... " + f.format(c.getPrices()) + "\n" + c.getNames() + "....." +
		    f.format(c.getPrices()) + "\n";
		
		s = s + "____________________" + "\n";
		
		s = s + "Total " + f.format(c.getTotal()) + "\n\n";
		
		s = s + "Amount tendered " + f.format(c.getMoney()) + "\n";
		
		s = s + "The change is " + f.format(c.getChange()) + "\n";
		
		s = s + "There were " + c.getQuantity() + " items" + "\n";
		s = s + "The average price is " + f.format(c.getAverage()) + "\n\n";
		
		s = s + "The change includes :" + "\n";
		
		s = s + c.getDollars() + " dollars" + "\n" + c.getQuarters()+ " quarters" +
		    "\n" + c.getDimes()+ " dimes" + "\n" + c.getNickels()+ " nickels" + 
		    "\n" + c.getPennies() + " cents";
		
		JTextArea text = new JTextArea(s,15, 25);
		
		JScrollPane pane = new JScrollPane(text);
		
		JOptionPane.showMessageDialog(null,pane, "Your bill",
	    JOptionPane.INFORMATION_MESSAGE);

	}


}
