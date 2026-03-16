package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PurchaseHistory ph = new PurchaseHistory();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Digite o código do cliente");
            String customerCode = sc.nextLine().toUpperCase();

            ph.printCustomerProducts(customerCode);

            System.out.println("Digite 1 para parar ou 0 para continuar");
            int quit = sc.nextInt();
            sc.nextLine();
            
            if (quit == 1){
                break;
            }

        }
        sc.close();

    }

    //Customers codes for tests: 99N6OU01, 07578401, YYYYFA01
}
