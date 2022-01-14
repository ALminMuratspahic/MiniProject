package cinema;

import java.util.Scanner;

public class Cinema {
	
	String[][]cinemaSeats;
	Scanner choseSeat=new Scanner(System.in);
	private boolean haveSeat;
	private boolean isFree;
	private int soldSeats;
	
	public Cinema(String [][]cinemaSeats) {
		this.cinemaSeats=cinemaSeats;
	}
	
	public void goingToTheCinema() {
			int numberOfAllSeats=cinemaSeats.length*cinemaSeats[0].length;
			System.out.println("WELCOM TO CINEMA");
			System.out.println("WE have "+cinemaSeats.length+" row,and "+cinemaSeats[0].length+" column.");
			System.out.println("Total: "+numberOfAllSeats+" seats free ");
			System.out.println("  1 2 3 4 5 6 7 8");
			seeAllSeats(cinemaSeats);
			choseSeat();	 	
	}
	public void choseSeat() {
		do {
			haveSeat=false;
			System.out.println("Chose a Row: ");
			int row=choseSeat.nextInt()-1;
			
			System.out.println("Choce a Seat Number");
			int column=choseSeat.nextInt()-1;
			
			takeSeat(row,column);
			System.out.println("  1 2 3 4 5 6 7 8");
			seeAllSeats(cinemaSeats);
			System.out.println("Number of tickets sold is: "+getSoldSeats());
			haveSeat= isFull();	
		} while (haveSeat);	
	}
	
	public void seeAllSeats(String [][]cinemaSeats) {
		for(int i=0;i<cinemaSeats.length;i++) {
			System.out.print(i+1+" ");
			for(int j=0;j<cinemaSeats[i].length;j++) {
				if(cinemaSeats[i][j]==null) {
					cinemaSeats[i][j]=" ";
				}
				System.out.print(cinemaSeats[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void takeSeat(int row,int seatNumber) {
		chackSeat(row, seatNumber);
		if(isFree) {
			cinemaSeats[row][seatNumber]="S";
			soldSeats++;
		}else {
			System.out.println("Sorry!That seat is already taken.Please chose another one.");
		}
	}
	
	public boolean chackSeat(int row,int seatNumber) {
		
		try {
			if(cinemaSeats[row][seatNumber]=="S") {
				isFree=false;	
			}else {
				isFree=true;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("That seat does not exist!");
			System.out.println("Please chose a different seat.");
			choseSeat();
		}
		return isFree;
	}

	public boolean isFull() {
		for(int i=0;i<cinemaSeats.length;i++) {
			for(int j=0;j<cinemaSeats[i].length;j++) {
				if(cinemaSeats[i][j]!="S") {
					haveSeat=true;
					break;
				}
			}
		}
		if(!haveSeat) {
			System.out.println("All Seats is taken!");
			System.out.println("Enjoy in Movie");
		}
		return haveSeat;
	}

	public String[][] getCinemaSeats() {
		return cinemaSeats;
	}
	public int getSoldSeats() {
		return soldSeats;
	}
	
}
