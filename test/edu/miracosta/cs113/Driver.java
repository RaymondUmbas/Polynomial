package edu.miracosta.cs113;

import java.util.Scanner;

public class Driver {
	static Scanner input = new Scanner(System.in);
	static Polynomial polynomial1 = new Polynomial(), polynomial2 = new Polynomial();
	public static void main(String[] args) 
	{
		int user;
		do { 
			System.out.println(
			"\n------------------------------\n"
			+"Welcome to Polynomial Program!\n\n"+
			 "Please select an option:\n"
			 +"1) Add Term\n"
			 +"2) Remove Term\n"
			 +"3) Add Polynomials\n"
			 +"4) Display Polynomials\n"
			 +"5) Clear Polynomial\n"
			 +"6) Exit Program\n"
			 +"\n------------------------------");
			
				user = input.nextInt();
			
			//Menu Input Validation
			while(user != 1 && user != 2 && user != 3 && user != 4 && user != 5 && user != 6 ) 
			{
				System.out.println("Please enter a valid option (1 to 4).");
				user = input.nextInt();	
			}
			
			//Add Term
			if(user == 1) 
			{
				display();
				addTermToPoly();
			}
			
			//Remove Term
			else if(user == 2)
			{
				display();
				removeTermFromPoly();
			}
			
			//Add Polynomials
			else if(user == 3)
			{
				addPolynomials();
			}
			
			//Display Polynomials
			else if(user == 4)
			{
				display();
			}
			
			//Clear Polynomials
			else if(user == 5)
			{
				clear();
			}
	
		}while(user != 6); //Exit Loop
	}
	
	public static void addTermToPoly() 
	{
		int coefficientAdd, exponentAdd, polynomialChoice;
		
		//User Input
		System.out.println("Please enter the COEFFICIENT of the term you would like to ADD.");
		coefficientAdd = input.nextInt();
		System.out.println("Please enter the EXPONENT of the term you would like to ADD.");
		exponentAdd = input.nextInt();
		Term addedTerm = new Term(coefficientAdd, exponentAdd);
		System.out.println("Would you like to add this term to Polynomial 1 or 2?");
		polynomialChoice = input.nextInt();
		
		//Polynomial Choice Input Validation
		while(polynomialChoice != 1 && polynomialChoice != 2 ) 
			{
				System.out.println("Please enter a valid option (1 or 2).");
				polynomialChoice = input.nextInt();
			}
		System.out.println("Adding " + addedTerm.toString() + " to Polynomial " + polynomialChoice );
		
		//Chooses which Polynomial to edit
		if(polynomialChoice == 1) 
		{
			polynomial1.addTerm(addedTerm);
		}
		else if(polynomialChoice == 2)
		{
			polynomial2.addTerm(addedTerm);
		}
	}
	
	public static void removeTermFromPoly() 
	{
		int coefficientRemove, exponentRemove, polynomialChoice;
		
		//User Input
		System.out.println("Please enter the COEFFICIENT of the term you would like to REMOVE. ");
		coefficientRemove = input.nextInt();
		System.out.println("Please enter the EXPONENT of the term you would like to REMOVE. ");
		exponentRemove = input.nextInt();
		Term removedTerm = new Term(coefficientRemove, exponentRemove);
		System.out.println("Would you like to remove this term to Polynomial 1 or 2? ");
		polynomialChoice = input.nextInt();
		
		//Polynomial Choice Input Validation
		while(polynomialChoice != 1 && polynomialChoice != 2 ) 
			{
				System.out.println("Please enter a valid option (1 or 2).");
				polynomialChoice = input.nextInt();
			}
		
		if(polynomialChoice == 1) 
			{	
				//Not Found
				if(!polynomial1.getPolynomial().contains(removedTerm))
				{
					System.out.println("ERROR: " +removedTerm.toString() + " not found in Polynomial 1.");
				}
				
				//Found
				else
				{
					System.out.println("Removing " + removedTerm.toString() + " from Polynomial 1.");
					polynomial1.getPolynomial().remove(removedTerm);
				}
			}
		else if(polynomialChoice == 2)
			{
				//Not Found
				if(!polynomial2.getPolynomial().contains(removedTerm))
				{
					System.out.println("ERROR: " +removedTerm.toString() + " not found in Polynomial 2.");
				}
				
				//Found
				else
				{
					System.out.println("Removing " + removedTerm.toString() + " from Polynomial 2.");
					polynomial2.getPolynomial().remove(removedTerm);
				}
			}
	}
	
	public static void addPolynomials() 
	{
		Polynomial sum = new Polynomial();
		sum.add(polynomial1);
		sum.add(polynomial2);
		System.out.println("Polynomial 1 + Polynomial 2 = ");
		System.out.println(sum.toString());
	}
	
	public static void display()
	{
		if(polynomial1.getPolynomial().isEmpty()) 
		{
			 System.out.println("Polynomial 1: EMPTY");
		}
		else 
		{
			System.out.println("Polynomial 1: " + polynomial1);
		}
		
		if(polynomial2.getPolynomial().isEmpty()) 
		{
			 System.out.println("Polynomial 2: EMPTY");
		}
		else 
		{
			System.out.println("Polynomial 2: " + polynomial2);
		}
	}
	
	public static void clear() 
	{
		Scanner input = new Scanner(System.in);
		int polynomialChoice;
		System.out.println("Would you like to clear Polynomial 1 or 2? ");
		polynomialChoice = input.nextInt();
		
		//Polynomial Choice Input Validation
		while(polynomialChoice != 1 && polynomialChoice != 2 ) 
			{
				System.out.println("Please enter a valid option (1 or 2).");
				polynomialChoice = input.nextInt();
			}
		
		//Chooses which Polynomial to clear
		if(polynomialChoice == 1) 
		{
			System.out.println("Clearing Polynomial 1.");
			polynomial1.clear();
		}
		else if(polynomialChoice == 2)
		{
			System.out.println("Clearing Polynomial 2.");
			polynomial2.clear();
		}
	}
	
}
