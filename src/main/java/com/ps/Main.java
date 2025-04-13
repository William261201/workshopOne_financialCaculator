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

                //get monthly payment user receive
                System.out.print("What is the monthly payment you receive?: ");
                float payment = scanner.nextFloat();

                //get how many years user want to receive payment
                System.out.print("For how many years do you want to receive the payment?: ");
                int years = scanner.nextInt();

                //get the annual interest rate user will get
                System.out.print("What is the annual interest rate?: ");
                float annual = scanner.nextFloat();

                //change annual interest to monthly rate
                float monthly = annual / 100 / 12;

                //get total number of months form user's year choice
                int total_months = years * 12;

                //calculate present value of the annuity
                double PV = payment * (1 - Math.pow(1 + monthly, -total_months)) / monthly;

                // show the result
                System.out.printf("To receive $%.2f monthly for %d years at %.2f%% interest,\n", payment, years, annual);
                System.out.printf("you need to invest $%.2f today.\n", PV);

            default:

                //Print out error message if user choose number not included
                System.out.print("Please only choose between 1, 2, 3");
        }
    }
}