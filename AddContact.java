package addressBookSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddContact {
    private List<Contacts> data;
    public AddContact() {
        this.data = new ArrayList<>();
    }
    public void addItem(Contacts contact) {
        data.add(contact);
    }
    public void viewContacts() {
        for (Contacts contact : data) {
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
            System.out.println("Address: " + contact.getAddress());
            System.out.println("City: " + contact.getCity());
            System.out.println("State: " + contact.getState());
            System.out.println("Zip: " + contact.getZip());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email: " + contact.getEmail());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddContact A = new AddContact();

        System.out.print("Enter the number of contacts to add: ");
        int numberOfContacts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfContacts; i++) {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            System.out.print("Enter City: ");
            String city = scanner.nextLine();
            System.out.print("Enter State: ");
            String state = scanner.nextLine();
            System.out.print("Enter Zip: ");
            String zip = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            Contacts newContact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
            A.addItem(newContact);
        }

        A.viewContacts();
    }
}
