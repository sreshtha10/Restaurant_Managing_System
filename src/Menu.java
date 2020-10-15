import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
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
	private void display(int opt) {
		if(opt == 1) {// veg
			try {
				File vegFile = new File("Menu\\veg.txt");
				Scanner scanner = new Scanner(vegFile);
				String item = scanner.nextLine();
				System.out.println("Vegetarian Dishes");
				while(scanner.hasNext()) {
					System.out.println(item);
					item = scanner.nextLine();
				}
				scanner.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("No Vegetarian dishes are available");
			}
		}
		else if(opt == 2) { // non veg 
			try {
				File nvegFile = new File("Menu\\non-veg.txt");
				Scanner scanner = new Scanner(nvegFile);
				String item = scanner.nextLine();
				System.out.println("Non Veg Dishes:");
				while(scanner.hasNext()) {
					System.out.println(item);
					item = scanner.nextLine();
				}
				scanner.close();
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
