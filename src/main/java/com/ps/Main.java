package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // let java know this will be taking user's input


        System.out.println("""
                Welcome To Mortgage Calculator!
                What would you like to calculate?
                You can chose Mortgage for 1, Future Value for 2, Present Value for 3.\s""");

        int user_choice;
        user_choice = scanner.nextInt();

        switch(user_choice) {

            case 1:

                ///get user's loan amount input with a variable 'LoanAmount'
                System.out.print("What is the loan amount?: ");
                int LoanAmount = scanner.nextInt();
                //System.out.print(P);

                ///get how many months the payment would be
                System.out.print("How many years are you paying this amount?: ");
                int payment_years = scanner.nextInt();
                //change payment years to months and store the value with 'MonthlyRate'
                int PaymentMonth = payment_years * 12;
                //System.out.print(n);

                /// get user's monthly interest rate with a variable 'interest_rate'
                ///calculate annual rate first then divide by 12 to get monthly interest rate
                System.out.print("What is the annual interest rate?: ");
                double annual_interest_percentage = scanner.nextFloat();
                double MonthlyRate = annual_interest_percentage/(12*100);
                //System.out.print(r);

                ///calculate the monthly payment
                double M;
                double interest_rate_power = Math.pow((1+MonthlyRate), PaymentMonth);
                M = (LoanAmount * MonthlyRate * interest_rate_power)/(interest_rate_power - 1);

                //print out monthly payment amount for user's loan
                System.out.printf("Your monthly payment for loan %d is %.2f\n", LoanAmount, M );

                ///calculate total payment and print out the amount
                double Total_paid = M * PaymentMonth;
                System.out.printf("The total payment after %d year is %.2f", payment_years, Total_paid);

                break;

            case 2:

                //get the amount of deposit user would like to make.
                System.out.print("How much is your initial deposit?: ");
                float deposit;
                deposit = scanner.nextFloat();

                //get the percentage of that user would earn annually
                System.out.print("What is annual interest rate?: ");
                float annual_rate;
                float rate_percentage = scanner.nextFloat();
                annual_rate = (rate_percentage/100);

                //get the number of time interest is compound per year
                //System.out.print("What is the number of times the interest will compound per year?: ");
                //int n1;
                //n1 = scanner.nextInt();

                //get the time the deposit will stay
                System.out.print("How many years would you like to keep that deposit?");
                float time ;
                time = scanner.nextInt();

                /// Start calculating the future compounding value
                float compound;
                float power = 12 * time;
                compound = (float) (deposit * Math.pow((1 + annual_rate/12), power));

                //Print out the future value
                System.out.printf("Your future value is %.2f ", compound);

                //calculate interest earned
                float interest_earned = compound - deposit;
                System.out.printf("Your interest earned amount is %.2f", interest_earned);

                break;

            case 3:

                // Present value of an ordinary annuity formula: PV = PMT * ((1-(1+r)^-n)/r)

                // get user's payment per period amount
                System.out.print("What is your estimated payment per period would like to receive?: ");
                float estimated_payment;
                estimated_payment = scanner.nextFloat();

                // get the annual interest rate
                System.out.print("What is the estimated annual interest rate?: ");
                float annual_interest;
                annual_interest = scanner.nextFloat();

                // convert annual interest rate to monthly interest rate by dividing with 12 * 100
                float monthly_interest;
                monthly_interest = annual_interest / (12 * 100);

                // get estimated year of user to keep the money
                System.out.print("How many years you would like to keep the money?: ");
                float estimated_year;
                estimated_year = scanner.nextFloat();

                // convert to month because we will calculate in month
                float estimated_month = estimated_year * 12;

                // calculate the power part first of calculation
                double upper_part;
                upper_part = (1- Math.pow(1+monthly_interest, (-estimated_month)));

                // calculate the present value
                double present_value = estimated_payment * (upper_part)/monthly_interest;
                System.out.printf("Your present value is %.2f", present_value);

                break;

            default:

                //Print out error message if user choose number not included
                System.out.print("Please only choose between 1, 2, 3");
        }
    }
}