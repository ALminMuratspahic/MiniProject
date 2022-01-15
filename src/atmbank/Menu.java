package atmbank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu extends Acc {
	
	Scanner menuInput =new Scanner(System.in);
	Map<Integer, Integer>accRegister= new HashMap<>();
	int select;
	
	public void logIn() throws IOException {
		int x=1;
	
		do {
			try {
				accRegister.put(1234567,1111);
				accRegister.put(12121212, 2222);
				System.out.println("*** WELCOME AT ATM ***");
				System.out.println("Please input your CARD NUMBER:");
				setCardNumber(menuInput.nextInt());
				System.out.println("Please input your PIN NUMBER");
				setPinNumber(menuInput.nextInt());
					
			} catch (Exception e) {
				System.out.println("Wrong caracter.Input number");
				x=2;
			}
			
			for(int i:accRegister.keySet()) {
				
				if(i==getCardNumber() && accRegister.get(i)==getPinNumber()) {
					startMenu();
				}
				
			}
			System.out.println("\n"+"Wrong Customer number or Pin number"+"\n");
			
		} while (x==1);
	}

	private void startMenu() {
		
		System.out.println("Select number from the list: ");
		System.out.println(" 1 - View Account Balance.");
		System.out.println(" 2 - Make Depozit");
		System.out.println(" 3 - Make Withdraw");
		System.out.println(" 4 - Convert Value");
		System.out.println(" 5 - Exit");
		System.out.println("Your input: ");
		select=menuInput.nextInt();
		
		switch (select) {
		case 1: {
			System.out.printf("Your Account balance is: %.2f KM\n ",getAccBalance());
			startMenu();
			break;
		}
		case 2:{
			makeingDepozit();
			startMenu();
			break;	
		}
		case 3:{
			makingWithdraw();
			startMenu();
			break;
		}
		case 4:{
			subMenuConvert();
			startMenu();
			break;
		}
		case 5:{
			System.out.println("THANK YOU FOR USEING OUR SERVICES");
			break;
		}
		default:
			System.out.println("Illega choices");
			startMenu();
		}	
		
	
		
	}
	
	public void subMenuConvert() {
		
		System.out.println("1 - Convert to EUR");
		System.out.println("2 - Convert to AUD");
		
		select=menuInput.nextInt();
		
		switch (select) {
		case 1: {
			makeConvertToEuro();
			startMenu();
			break;
		}
		case 2 :{
			makeConvertToAUD();
			startMenu();
			break;
		}
		default:
			System.out.println("WRONG INPUT!!!");
			System.out.println("Please input number from list.");
			subMenuConvert();
		}
		
	}

}
