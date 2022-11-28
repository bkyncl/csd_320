/* method_overload.java
 * Module 8 Assignment 
 * Name: Brittany Kyncl
 * Date: 11.27.22
 * Course: CSD320
 * Program to calculate the cost of yearly auto service
 * */

import java.util.*;
import java.util.InputMismatchException;

public class Method_Overload{

	// set final service charge value
	public static final double serviceCharges = 120;
	public static final double oilChangePrice = 65;
	public static final double tireRotation = 45;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); //to take user input
		int serviceSelection; 
		int coupon = 10;

		System.out.println(Method_Overload.yearlyService());
		System.out.println(Method_Overload.yearlyService(oilChangePrice));
		System.out.println(Method_Overload.yearlyService(oilChangePrice,tireRotation));
		System.out.println(Method_Overload.yearlyService(oilChangePrice,tireRotation,coupon));

		System.out.println("\nThe standard yearly service charge is $150" +
						"\nPlease select additonal services from the below menu.." +
						"\n1. Oil Change: $65" +
						"\n2. Tire Rotation: $45" +
						"\n3. Oil Change + Tire Rotation: $110" +
						"\n4. Oil Change + Tire Rotation - $10 coupon" +
						"\n5. No Additonal Services");
		
		while(true){

			System.out.print("Enter 1/2/3/4/5: ");
			try{
				serviceSelection = input.nextInt();
				if(serviceSelection > 5 || serviceSelection < 1){
					continue;
				}
				else if(serviceSelection == 1){
					System.out.println("Your total will be: " + Method_Overload.yearlyService(oilChangePrice));
					break;
				}else if(serviceSelection == 2){
					System.out.println("Your total will be: " + Method_Overload.yearlyService(tireRotation));
					break;
				}else if(serviceSelection == 3){
					System.out.println("Your total will be: " + Method_Overload.yearlyService(oilChangePrice,tireRotation));
					break;
				}else if (serviceSelection == 4){
					System.out.println("Your total will be: " + Method_Overload.yearlyService(oilChangePrice,tireRotation,coupon));
					break;
				}else{
					System.out.println("Your total will be: " + Method_Overload.yearlyService());
					break;
				}
			}
			catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("Invalid Input. Enter only integers 1-4.");
			}
		}
		input.close();
	}

	// method to return base service charge
	public static double yearlyService() {
		return serviceCharges;
	}

	// method to return base service charge + oilchange price
	public static double yearlyService(double oilChangePrice) {
		return serviceCharges+oilChangePrice;
	}

	// method to return base service charge + oilchange price + tirerotation price
	public static double yearlyService(double oilChangePrice,double tireRotation) {
		return serviceCharges+oilChangePrice+tireRotation;
	}

	// method to return base service charge + oilchange price + tirerotation price - coupon amt
	public static double yearlyService(double oilChangePrice,double tireRotation,double coupon) {
		return (serviceCharges+oilChangePrice+tireRotation)-coupon;
	}
}
