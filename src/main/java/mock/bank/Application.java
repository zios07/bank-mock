package mock.bank;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		String username = null;
		String password = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome !");
		System.out.print("Username : \t");
		username = sc.nextLine();

		System.out.println();
		System.out.print("Password : \t");
		Scanner sc2 = new Scanner(System.in);
		password = sc2.nextLine();

		
		// closing ressources
		sc.close();
		sc2.close();

		System.out.println(username + " ******** " + password);
	}

}
