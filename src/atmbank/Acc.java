package atmbank;

import java.util.Scanner;

public class Acc {
	
	private int cardNumber;
	private int pinNumber;
	private double accBalance;
	
	Scanner inputCustomer=new Scanner(System.in);
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public double getAccBalance() {
		return accBalance;
	}
	
	public double calculateDepozit(double amount) {
		accBalance=(accBalance+amount);
		return accBalance;
	}
	
	public double calculateWithdraw(double amount) {
		accBalance=(accBalance-amount);
		return accBalance;
	}
	
	public void makeingDepozit() {
		System.out.printf("Account Balance is: %.2f KM\n",accBalance);
		System.out.println("Input how much money you want to DEPOZIT: ");
		double amount=inputCustomer.nextDouble();
		calculateDepozit(accBalance+amount);
		System.out.printf("Now Your Account Balance is : %.2fKM\n ",accBalance);		
	}
	
	public void makingWithdraw() {
		System.out.printf("Account Balance is: %.2f",accBalance);
		System.out.println("Input how much money you want to WITHDRAW: ");
		double amount=inputCustomer.nextDouble();
		
		if(accBalance-amount>=0) {
			calculateWithdraw(amount);
			System.out.printf("Now yout Acc BALANCE is: %.2f KM\n",accBalance);
		}else {
			System.out.println("Your Account Balance can't be negativ");
		}
	}
	
	public double converValuteToEuro(double amount) {
		double euro=amount/1.95583;
		return euro;
	}	
	public void makeConvertToEuro() {
		System.out.printf("Account Balance is: %.2f KM\n",accBalance);
		double euro=converValuteToEuro(accBalance);
		System.out.printf("Account Balace is: %.2f EUR\n",euro);
	}
	
	public double converValuteToAUD(double amount) {
		double euro=amount/1.234460;
		return euro;
	}
	public void makeConvertToAUD() {
		System.out.printf("Account Balance is: %.2f KM\n",accBalance);
		double aud=converValuteToAUD(accBalance);
		System.out.printf("Account Balance is: %.2f AUD\n",aud);
	}
	

}
