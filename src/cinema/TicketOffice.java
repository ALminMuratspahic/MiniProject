package cinema;

import java.util.Scanner;

public class TicketOffice {

	public static void main(String[] args) {
		
		String[][] seats=new String[5][8];
		
		Cinema cinema= new Cinema(seats);
		cinema.goingToTheCinema();
		
	}
	
	

}

