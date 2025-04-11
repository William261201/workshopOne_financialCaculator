package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To Mortgage Calculator");

        Scanner scanner = new Scanner(System.in);

        ///get user's loan amount input with a variable 'P'
        System.out.print("What is the loan amount?: ");
        int P = scanner.nextInt();
        //System.out.print(P);

        ///get how many months the payment would be
        System.out.print("How many years are you paying this amount?: ");
        int payment_years = scanner.nextInt();
        //change payment years to months and store the value with 'n'
        int n = payment_years * 12;
        //System.out.print(n);

        /// get user's monthly interest rate with a variable 'interest_rate'
        ///calculate annual rate first then divide by 12 to get monthly interest rate
        System.out.print("What is the annual interest rate?: ");
        double annual_interest_percentage = scanner.nextFloat();
        double r = annual_interest_percentage/(12*100);
        //System.out.print(r);

        ///calculate the monthly payment
        double M;
        double interest_rate_power = Math.pow((1+r), n);
        M = (P * r * interest_rate_power)/(interest_rate_power - 1);

        //print out monthly payment amount for user's loan
        System.out.printf("Your monthly payment for loan %d is %.2f\n", P, M );

        ///calculate total payment and print out the amount
        double Total_paid = M * n;
        System.out.printf("The total payment after %d year is %.2f", payment_years, Total_paid);



    }
}