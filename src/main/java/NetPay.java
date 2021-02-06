import java.util.Scanner;

// this is the main class
public class NetPay {
	// // you need to uncomment the constants 
	// // and declare the values of various deduction types
	 private static final double FEDERAL_TAX_PERCENT = 10.00;
	 private static final double STATE_TAX_PERCENT = 4.50;
	 private static final double SS_PERCENT = 6.20;
	 private static final double MEDICARE_PERCENT = 1.45;
	 private static final double PAY_PER_HOUR = 7.25;

    public static void main(String[] args) {
        boolean notValid = true;
        while(notValid) {
            System.out.print("How many hours did you work this week?");
            Scanner input = new Scanner(System.in);
            if(!input.hasNextInt()){
                System.out.println("Input is not valid");
            }
            else{
                int numberOfHours = input.nextInt();
                if(numberOfHours < 0){
                    System.out.println("Input is not valid");
                }
                 else {
                    notValid = false;
                    double netPayValue = netPay(numberOfHours);
                }   
        }
    }
}
        // an example of testing your code
        //int numberOfHours = 35;
        //double netPayValue = netPay(numberOfHours);
        //another example of testing your code
        //numberOfHours = 30;
        //netPayValue = netPay(numberOfHours);



    // This method calculates and displays all of the calculations and deductions
    public static double netPay(int numberOfHours) {
        double grossPay = (PAY_PER_HOUR * numberOfHours);
        double formatGross = ((Math.round(grossPay * 100.00)) / 100.00);
        double federal = (grossPay * (FEDERAL_TAX_PERCENT / 100));
        double formatFed = ((Math.round(federal * 100.00)) / 100.00);
        double state = (grossPay * (STATE_TAX_PERCENT / 100));
        double formatState = ((Math.round(state * 100.00)) / 100.00);
        double socialSecurity = (grossPay * (SS_PERCENT / 100));
        double formatSec = ((Math.round(socialSecurity * 100.00)) / 100.00);
        double medicare = (grossPay * (MEDICARE_PERCENT / 100));
        double formatMed = ((Math.round(medicare * 100.00)) / 100.00);
        double netPay = (grossPay - (formatFed + formatState + formatSec + formatMed));
        double formatNet = ((Math.round(netPay * 100.00)) / 100.00);
        System.out.println("Hours per Week: " + numberOfHours);
        System.out.println("Gross Pay: " + formatGross);
        System.out.println("");
        System.out.println("Deductions");
        System.out.println("Federal: " + formatFed);
        System.out.println("State: " + formatState);
        System.out.println("Social Security: " + formatSec);
        System.out.println("Medicare: " + formatMed);
        System.out.println("");
        System.out.println("Net Pay: " + formatNet);
        System.out.println("------------------------------");
        return formatNet;
    }
}