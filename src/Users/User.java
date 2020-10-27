import java.io.File;
import java.io.IOException;
public class User {
	String nameString;
	long phoneNo;
	String addressString;
	User(String name,long phoneNo,String addressString){
		this.nameString = name;
		this.phoneNo = phoneNo;
		this.addressString = addressString;
	}
	public void createFile() {
		try {
			//creating file as name.phoneNo.txt
			File userFile = new File("C:\\eclipse-workspace\\Restaurants Billing System\\src\\Users\\"+this.nameString+"."+this.phoneNo+".txt");
			if(userFile.exists()) {
				System.out.println("Welcome back !");
				return;
			}
			else {
				userFile.createNewFile();
				System.out.println("Welcome !");
			}
		}
		catch (IOException e) {
			System.out.println("Restaurant is closed !");
			return;
		}
	}
	public void write() {
		
	}
}
