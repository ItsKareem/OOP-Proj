import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Please choose your role, enter g for guest, a for admin, r for receptionist: ");
        char choice  = scan.next().charAt(0);

        if (choice == 'g'){
            System.out.print("Would you like to login or signup? Type l for login and s for signup: ");
            choice  = scan.next().charAt(0);
            if (choice == 'l'){
                Guest.login();
            }
            else if (choice == 's'){
                Guest.register();
            }
            else{
                throw new IllegalArgumentException("Invalid choice");
            }

            System.out.print("1.View Profile and Active Reservations \n" + "2. View Available Rooms \n" + "3. Cancel Reservation \n" + "4. Checkout and Pay \n");
            System.out.print("Type your choice 1-4: ");
            int option = scan.nextInt();
            switch (option){
                case 1:
                    ( (Guest) Database.getCurrentUser() ).displayDetails();
                    ( (Guest) Database.getCurrentUser() ).viewreservations();
                    break;
                case 2:
                    ( (Guest) Database.getCurrentUser() ).viewavailablerooms();
                    break;
                case 3:
                    System.out.print("Please enter the room number of the reservation you want to cancel: ");
                    int roomnumber = scan.nextInt();
                    ( (Guest) Database.getCurrentUser() ).cancelreservation(roomnumber);
                    break;
                case 4:
                    System.out.print("Please enter the room number of the reservation you want to check out from: ");
                    int roomnumber2 = scan.nextInt();
                    ( (Guest) Database.getCurrentUser()).checkoutandPay(roomnumber2);


            }

        }

        else if (choice == 'a'){
            Admin.login();
        }
        else if (choice == 'r'){
            Receptionist.login();
        }
        else{
            throw new IllegalArgumentException("Invalid choice");
        }

    }

}
