import java.util.Date;
import java.util.Scanner; // import the Scanner class 
import java.lang.Math;
import java.text.DecimalFormat;

public class Loan{

  private double annualInterestRate = 2.5;
  private int numberOfYears = 1;
  private double loanAmount = 1000;
  Date loanDate = new Date();
  private static final DecimalFormat df = new DecimalFormat("0.00");

  //constructor no need to put return type
  public Loan(){
    this.loanDate = new Date();
  }

  public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
  }

  public double getAnnualInterestRate(){
    return this.annualInterestRate;
  }

  public int getNumberOfYears(){
    return this.numberOfYears;
  }

  public double getLoanAmount(){
    return this.loanAmount;
  }

  public void getLoanDate(){
      System.out.println("The loan was created on "+ loanDate.toString());
  }

  public void setAnnualInterestRate(double annualInterestRate){
    this.annualInterestRate = annualInterestRate;
  }

  public void setNumberOfYears(int numberOfYears){
    this.numberOfYears = numberOfYears;
  }

  public void setLoanAmount(double loanAmount){
    this.loanAmount = loanAmount;
  }

  public double getMonthlyPayment(){
    double monthlyP = (this.loanAmount*(this.annualInterestRate/100/12))/(1-(1/(Math.pow((1+((this.annualInterestRate)/100/12)), (this.numberOfYears*12)))));
    return monthlyP;
  }

  public double getTotalPayment(){
    double totalP = getMonthlyPayment() * this.numberOfYears * 12;
    return totalP;
  }

  public static void main(String [] args){

    Scanner input = new Scanner(System.in);

    System.out.println("Enter annual interest rate, for example, 8.25: "); 
    double annualInterestRate = input.nextDouble();
    
    System.out.println("Enter number of years as an integer: "); 
    int numberOfYears = input.nextInt();

    System.out.println("Enter loan amount, for example, 120000.95: "); 
    double loanAmount = input.nextDouble();

    Loan getDate = new Loan(annualInterestRate, numberOfYears, loanAmount);
    getDate.getLoanDate();

    Loan getMonthly = new Loan(annualInterestRate, numberOfYears, loanAmount);
    System.out.println("The monthly payment is " + df.format(getMonthly.getMonthlyPayment()));

    Loan getTotal = new Loan(annualInterestRate, numberOfYears, loanAmount);
    System.out.println("The total payment is " + df.format(getTotal.getTotalPayment()));
  }
}