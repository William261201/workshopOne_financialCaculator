package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // let java know this will be taking user's input


        System.out.println("""
                Welcome To Mortgage Calculator!
                What would you like to calculate?
                You can chose Mortgage for 1, Future Value for 2, Present Value for 3.\s""");

        int userChoice;
        userChoice = scanner.nextInt();

        switch(userChoice) {

            case 1:

                ///get user's loan amount input with a variable 'LoanAmount'
                System.out.print("What is the loan amount?: ");
                int loanAmount = scanner.nextInt();
                //System.out.print(P);

                ///get how many months the payment would be
                System.out.print("How many years are you paying this amount?: ");
                int paymentYears = scanner.nextInt();
                //change payment years to months and store the value with 'MonthlyRate'
                int paymentMonth = paymentYears * 12;
                //System.out.print(n);

                /// get user's monthly interest rate with a variable 'interest_rate'
                ///calculate annual rate first then divide by 12 to get monthly interest rate
                System.out.print("What is the annual interest rate?: ");
                double annualInterestPercentage = scanner.nextFloat();
                double MonthlyRate = annualInterestPercentage/(12*100);
                //System.out.print(r);

                ///calculate the monthly payment
                double M;
                double interestRatePower = Math.pow((1+MonthlyRate), paymentMonth);
                M = (loanAmount * MonthlyRate * interestRatePower)/(interestRatePower - 1);

                //print out monthly payment amount for user's loan
                System.out.printf("Your monthly payment for loan %d is %.2f\n", loanAmount, M );

                ///calculate total payment and print out the amount
                double totalPaid = M * paymentMonth;
                System.out.printf("The total payment after %d year is %.2f", paymentYears, totalPaid);

                break;

            case 2:

                //get the amount of deposit user would like to make.
                System.out.print("How much is your initial deposit?: ");
                float deposit;
                deposit = scanner.nextFloat();

                //get the percentage of that user would earn annually
                System.out.print("What is annual interest rate?: ");
                float annualRate;
                float ratePercentage = scanner.nextFloat();
                annualRate = (ratePercentage/100);

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
                compound = (float) (deposit * Math.pow((1 + annualRate/12), power));

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
                float estimatedPayment;
                estimatedPayment = scanner.nextFloat();

                // get the annual interest rate
                System.out.print("What is the estimated annual interest rate?: ");
                float annualInterest;
                annualInterest = scanner.nextFloat();

                // convert annual interest rate to monthly interest rate by dividing with 12 * 100
                float monthlyInterest;
                monthlyInterest = annualInterest / (12 * 100);

                // get estimated year of user to keep the money
                System.out.print("How many years you would like to keep the money?: ");
                float estimatedYear;
                estimatedYear = scanner.nextFloat();

                // convert to month because we will calculate in month
                float estimatedMonth = estimatedYear * 12;

                // calculate the power part first of calculation
                double upperPart;
                upperPart = (1- Math.pow(1+monthlyInterest, (-estimatedMonth)));

                // calculate the present value
                double presentValue = estimatedYear * (upperPart)/monthlyInterest;
                System.out.printf("Your present value is %.2f", presentValue);

                break;

            default:

                //Print out error message if user choose number not included
                System.out.print("Please only choose between 1, 2, 3");
        }
    }
}