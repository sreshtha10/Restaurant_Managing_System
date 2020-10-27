import java.io.*;
import java.util.*;

public class Order {
	int orderNo;
	String orderName;
	
	public void getOrder() throws IOException{
		try {
			System.out.println("Please enter the number of the dish you want to order.");
			Scanner sc = new Scanner(System.in);
			FileInputStream veg = new FileInputStream("C:\\Users\\Sreshtha\\eclipse-workspace\\Restaurants Billing System\\src\\Menu\\veg.txt");
			FileInputStream nonveg = new FileInputStream("C:\\Users\\Sreshtha\\eclipse-workspace\\Restaurants Billing System\\src\\Menu\\non-veg.txt");
			InputStreamReader v = new InputStreamReader(veg);
			InputStreamReader nv = new InputStreamReader(nonveg);
			System.out.println("What do you want to order? Veg/NonVeg");
			String opt = sc.nextLine();
			BufferedReader reader;
			if(opt.toUpperCase().startsWith("V")) {
				reader = new BufferedReader(v);
			}
			else {
				reader = new BufferedReader(nv);
			}
			System.out.println("Enter the order no.");
			int num = sc.nextInt();
			while(reader.readLine() != null) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				if(st.nextToken() == opt) {
					
				}
			}
			
			
		}
		catch(Exception e) {
			
		}
		
		
	}
}
