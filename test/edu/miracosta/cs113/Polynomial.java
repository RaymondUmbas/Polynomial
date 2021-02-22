package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.ListIterator;



public class Polynomial {
	private LinkedList<Term> polynomial; //Keeps List of Terms
	int numOfTerms;
	
	
	/*------------------------
	      Constructors
	----------------------- */
	//Default
	public Polynomial() 
	{
		this.numOfTerms = 0;
		this.polynomial = new LinkedList<Term>();
	}
	
	//Copy 
	public Polynomial(Polynomial other) 
	{
		other.numOfTerms = this.numOfTerms;
		other.polynomial = this.polynomial;
	}
	/*
	 *Getters and Setters 
	 */
	
	public int getNumTerms() {return numOfTerms;}
	public Term getTerm(int i) {return polynomial.get(i);}
	public LinkedList <Term> getPolynomial() {return polynomial;}
	
	/*
	 * Other Methods
	 */
	public void addTerm(Term term)
	{

		//No Terms Added Yet
		if(polynomial.isEmpty()) 
		{
			//Add term to front of list
			polynomial.offerFirst(term);
			numOfTerms++;
		}
		
		//Not Empty
		else
		{
			for(int i = 0; i < this.numOfTerms; i++) 
			{
				
				//Like Terms Can Combine
				if(polynomial.get(i).getExponent() == term.getExponent())
				{
					
					//Cancel each other
					if(polynomial.get(i).getCoefficient() + term.getCoefficient() == 0) 
					{
						polynomial.remove(i);
						numOfTerms--;
					}
					
					//Add Like Terms Together
					else
					{
						int sumCoefficients = polynomial.get(i).getCoefficient() + term.getCoefficient();
						this.polynomial.get(i).setCoefficient(sumCoefficients);
					}
					
					break; //Term Found Exit Loop
				}
				
				//Polynomial only has 1 term
				else if(polynomial.size() == 1) 
				{
					if(polynomial.get(0).getExponent() < term.getExponent()) 
					{
						polynomial.offerFirst(term);
						numOfTerms++;
						break; //Term Found Exit Loop
					}
					else
					{
					
						polynomial.offerLast(term);
						numOfTerms++;
						break; //Term Found Exit Loop
					}
				}
				
				//Last Term - exponents not equal
				else if(i == (this.numOfTerms-1)) 
				{
				
					polynomial.add(term);
					numOfTerms++;
					break; //Term Found Exit Loop
				}
				else if(polynomial.get(i+1).getExponent() < term.getExponent())
				{
					
					polynomial.add(i+1,term);
					numOfTerms++;
					break; //Term Found Exit Loop
					
				}
			}
		}
		
	}
	
	
	public void add(Polynomial other) 
	{
		//Add each term from Other to the polynomial
		for(int i = 0; i < other.numOfTerms; i++) 
		{
			this.addTerm(other.getTerm(i));
		}
	}
	
	public void clear() 
	{
		polynomial.clear();
		numOfTerms = 0;
	}
	
	@Override
	public String toString() {
		String list = "";
		if(this.polynomial.isEmpty()) {return "0";}
		
		//First Term Positive
		if(this.polynomial.get(0).getCoefficient() > 0)
		{
			list += this.polynomial.get(0).toString().substring(1);
		}
		
		//First Term Negative
		else 
		{
			list +=this.polynomial.get(0).toString();
		}
		
		//Adds Rest of the polynomial to the String
		for(int i = 1; i < numOfTerms; i++) {
			list += this.polynomial.get(i);
		}
		return list;
	}
	
	
}
