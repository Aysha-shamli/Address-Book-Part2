package addressBookSystem;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DeleteContact {
    private List<Contacts> data;

    public DeleteContact() {
        this.data = new ArrayList<>();
    }
    public void addItem(Contacts contact) {
        data.add(contact);
    }
    public void removeContact(Contacts contact) {
        data.remove(contact);
    }
    public void deleteContact(String firstName, String lastName) {
        Contacts contactToRemove = null;
        for (Contacts contact : data) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                contactToRemove = contact;
                break;
            }
        }

        if (contactToRemove != null) {
            removeContact(contactToRemove);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found with the given name.");
        }
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

        DeleteContact address = new DeleteContact();

        address.addItem(one);
        address.addItem(two);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Name of the contact to delete: ");
        String deleteFirstName = scanner.nextLine();
        System.out.print("Enter Last Name of the contact to delete: ");
        String deleteLastName = scanner.nextLine();
        address.deleteContact(deleteFirstName, deleteLastName);

        address.viewContacts();
    }
}
