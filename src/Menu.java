import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Menu {
	boolean shownAlreadyVg = false;
	boolean shownAlreadyNVg = false;
	//types of food - Veg, Non veg, Starters, Beverages,Dessert,Main Course,Bread
	int opt;
	Menu(){
		System.out.println("Choose from the following options");
		System.out.println("1. Vegetarian");
		System.out.println("2. Non-Vegetarian");
		Scanner scanner = new Scanner(System.in);
		this.opt = scanner.nextInt();
		this.choose(this.opt);
		scanner.close();
	}
	public void choose(int opt) {
		this.opt = opt;
		this.display(opt);
	}
	private void askAgain(int opt) {
		Scanner scanner2 = new Scanner(System.in);
		System.out.println();
		if(opt == 1) {
			System.out.println("Do you want to see the non-veg dishes? y/n");
			String x = scanner2.nextLine();
			if(x.toLowerCase().startsWith("y")){
				this.display(2);
			}
			else {
				//
			}
		}
		else {
			System.out.println("Do you want to see the veg dishes? y/n");
			String x = scanner2.nextLine();
			if(x.toLowerCase().startsWith("y")){
				this.display(1);
			}
			else {
				//
			}
		}
		scanner2.close();
	}
	private void display(int opt) {
		if(opt == 1) {// veg
			try {
				File vegFile = new File("C:\\Users\\Sreshtha\\eclipse-workspace\\Restaurants Billing System\\src\\Menu\\veg.txt");
				Scanner scanner = new Scanner(vegFile);
				String item = scanner.nextLine();
				System.out.println("Vegetarian Dishes\n");
				while(scanner.hasNext()) {
					System.out.println(item);
					item = scanner.nextLine();
				}
				this.shownAlreadyVg = true;
				scanner.close();
				if(!this.shownAlreadyNVg) {
					askAgain(1);
				}
			}
			catch (FileNotFoundException e) {
				System.out.println("No Vegetarian dishes are available");
			}
		}
		else if(opt == 2) { // non veg 
			try {
				File nvegFile = new File("C:\\Users\\Sreshtha\\eclipse-workspace\\Restaurants Billing System\\src\\Menu\\non-veg.txt");
				Scanner scanner = new Scanner(nvegFile);
				String item = scanner.nextLine();
				System.out.println("Non Veg Dishes:");
				while(scanner.hasNext()) {
					System.out.println(item);
					item = scanner.nextLine();
				}
				scanner.close();
				this.shownAlreadyNVg = true;
				if(!shownAlreadyVg) {
					askAgain(2);
				}
			}
			catch (FileNotFoundException e) {
				System.out.println("No Non-vegetarian dishes are available");
			}
		}
		else {
			System.out.println("Invalid option");
			System.out.print("Enter the option again: ");
			Scanner scanner = new Scanner(System.in);
			opt = scanner.nextInt();
			this.choose(opt);
			scanner.close();
		}
	}
}
