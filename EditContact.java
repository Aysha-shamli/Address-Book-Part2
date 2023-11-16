package addressBookSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EditContact {
    private List<Contacts> data;

    public EditContact() {
        this.data = new ArrayList<>();
    }
    public void addItem(Contacts contact) {
        data.add(contact);
    }
    public void editContact(String firstName, String lastName) {
        for (Contacts contact : data) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Editing Contact: " + firstName + " " + lastName);
                System.out.print("Enter New Address: ");
                String newAddress = scanner.nextLine();
                System.out.print("Enter New City: ");
                String newCity = scanner.nextLine();
                System.out.print("Enter New State: ");
                String newState = scanner.nextLine();
                System.out.print("Enter New Zip: ");
                String newZip = scanner.nextLine();
                System.out.print("Enter New Phone Number: ");
                String newPhoneNumber = scanner.nextLine();
                System.out.print("Enter New Email: ");
                String newEmail = scanner.nextLine();

                contact.setAddress(newAddress);
                contact.setCity(newCity);
                contact.setState(newState);
                contact.setZip(newZip);
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);

                System.out.println("Contact edited successfully!");
                return;
            }
        }
        System.out.println("Contact not found with the given name.");
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
        Contacts one = new Contacts("James", "Smith", "xyz(H)", "Bangalore", "Karnataka", "251125", "3253622525", "abc@gmail.com");
        Contacts two = new Contacts("John", "Mathew", "abc(H)", "Mumbai", "Maharashtra", "254725", "32535854215", "xyz@gmail.com");

        EditContact address = new EditContact();

        address.addItem(one);
        address.addItem(two);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Name of the contact to edit: ");
        String editFirstName = scanner.nextLine();
        System.out.print("Enter Last Name of the contact to edit: ");
        String editLastName = scanner.nextLine();
        address.editContact(editFirstName, editLastName);

        address.viewContacts();
    }
}
