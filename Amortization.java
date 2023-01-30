import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/*This class demonstrates the Amortization class.*/

/* Fields */
public class Amortization {
	private double loanAmount; 		// Double variable, holds amount of the loan
	private double interestRate; 	// Double variable, holds annual interest rate
	private double loanBalance; 	// Double variable, holds loan balance
	private double term; 			// Double variable used in calculation of monthly payment
	private double payment; 		// Double variable, holds amount of monthly payment
	private int loanYears; 			// int variable, holds number of years of the loan
	

	/** Constructor.
	 * @param amount Gets the amount of the loan.
	 * @param rate Gets the loans interest rate.
	 * @param years Gets the number of years of the loan.
	 **/
	public Amortization(double amount, double rate, int years) {
		loanAmount = amount;
		loanBalance = amount; 
		interestRate = rate;
		loanYears = years;
		calcPayment();
	}
	
	/*Used to calculate term and payment*/	 
	private void calcPayment() { 
		double newterm = (1.0 + (interestRate / 12.0));
		double termpow = (12 * loanYears);
		term = Math.pow(newterm, termpow);
		
		// Used to calculate monthly payment
		payment = ((loanAmount * interestRate / 12.0) * term) / (term - 1.0); 
		
	}
	
	/**Accessor method.
	 * @return the number of payments
	 */
	public int getNumberofPayments() 
	{
		return 12 * loanYears; 
	}
	
	/**
	 * @param filename the report.
	 * @throws FileNotFoundException throws a file that does not exist yet.
	 */
	/* Method that calculates and creates the amortization report. */
	public void saveReport(String filename) throws FileNotFoundException 
	{
		/* declaration of the interest and principal variables.*/
		double interest;
		double principal = payment;
		
		/* Creates a printWriter object */
		PrintWriter saveReport = new PrintWriter(filename);
		
		/* Header for the Amortization Report. */
		saveReport.printf("Monthly Payment: " + "%.2f",payment);
		saveReport.println();
		saveReport.println("Month     Interest    Principal    Balance ");
		saveReport.println("------------------------------------------------");
		
		/* declaration of the month variable. as long as month is less than or equal to the
		   number of payments, the following code will continue to execute, with the  month 
		   incrementing until it reaches the total amount of years, in months, that the user
		   submitted. The loop will calculate the interest, principal, and balance for each 
		   month and create the report. */
		for(int month = 1; month <= getNumberofPayments(); month++)
		{
			interest = interestRate / 12 * loanBalance ;
			
			if(month != getNumberofPayments())
			{
				principal = payment - interest;
			} 
			else
			{
				principal = loanBalance;
				payment = loanBalance + interest;
			}
			
             loanBalance -= principal; 
			
            /* rounds the calculations by two decimal places . */
			DecimalFormat df = new DecimalFormat("0.00");
			saveReport.format(month + "         " + df.format(interest) + "       " +
			df.format(principal) + "       " + df.format(loanBalance) + "\n");

		} 
		saveReport.close();
	}
	
	/** Accessor Method.
	 * @return the loan amount.
	 */
	public double getLoanAmount() 
	{
		return loanAmount; 
	}
	
	/** Accessor Method.
	 * @return the interest rate.
	 */
	public double getInterestRate() 
	{
		return interestRate; 
	}
	
	/**  Accessor Method.
	 * @return the loan years.
	 */
	public int getLoanYears() {
		return loanYears; 
	}
	
	/**  Accessor Method.
	 * @return the payment.
	 */
	public double getPayment()
	{
		return payment;
	}
}