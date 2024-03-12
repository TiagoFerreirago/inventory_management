package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.entities.Client;
import br.com.entities.Order;
import br.com.entities.OrderItem;
import br.com.entities.Product;
import br.com.entities.enums.OrderStatus;

public class Application {

	public static void main(String [] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Name: ");
		String name =sc.nextLine();
		
		System.out.print("\nEmail: ");
		String email= sc.nextLine();
		
		System.out.print("\nBirthDate: ");
		Date data= fmt.parse(sc.next());
		
		Client client= new Client(name, email, data);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		System.out.println("\nHow many items to this order? ");
		int qtdOrder= sc.nextInt();
		
		for(int i =0; i < qtdOrder; i++) {
			
			System.out.println("Enter "+(i+1)+" item data");
			
			System.out.print("Product name: ");
			sc.nextLine();
			String product = sc.nextLine();
			System.out.print("\nProduct price: ");
			Double price = sc.nextDouble();
			System.out.println("\nQuantity: ");
			int quantity = sc.nextInt();
			Product registerP = new Product(product, price);
			
			OrderItem registerOI= new OrderItem(quantity, price, registerP);
			order.addItem(registerOI);
			
		}
		System.out.println();
		System.out.println(order);
		
	}
}
