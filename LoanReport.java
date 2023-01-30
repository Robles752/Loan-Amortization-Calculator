import javax.swing.JOptionPane; 
import java.io.FileNotFoundException;

/*This class demonstrates the Amortization class.*/

public class LoanReport 
{

	public static void main(String[] args) throws FileNotFoundException
	
	{
		/* Creates a string variable named response.*/
		String response;
		
		/* Loop that asks the user information about their loan and ends when the user
		   no longer wants to make another report. */
		do
		{
			/* Asks the user to enter the amount of their loan. The users
			   input will be stored in the userloanAmount variable. */
			String userloanAmount = JOptionPane.showInputDialog("Enter the loan amount.");
			
			
			/* Asks the user to enter the annual interest. The users input
			   will be stored in the userInterestRate variable. */
			String userInterestRate = JOptionPane.showInputDialog("Enter the annual interest rate in decimal format.");
			
			/* Asks the user to enter the years of the loan. The users input
			   will be stored in the userLoanYears variable.*/
			String userLoanYears = JOptionPane.showInputDialog("Enter the years of the loan.");
			
			/* Creates an object named file from the Amortization class. The file object
			   will pass the variables stored for the loan amount, interest rate, and years
			   for the loan into the amortization class.*/
			Amortization file = new Amortization(Double.parseDouble(userloanAmount),
			Double.parseDouble(userInterestRate), Integer.parseInt(userLoanYears));
			
			/* Tells the user that the amortization report will be saved to text file 
			   named "LoanAmortization" */
			JOptionPane.showMessageDialog(null, "Report Saved to the file LoanAmortization.txt");
			file.saveReport("LoanAmortization.txt");
	 	
			/* If the User puts Y or y, the loop will continue and ask the user the same 
		       questions to create a new amortization report. If the user puts N or n,
		       the loop will end. */	
			response = JOptionPane.showInputDialog("would you like another report? Enter Y for yes or N for no.");
		} 	while (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("y"));
	}
		
}