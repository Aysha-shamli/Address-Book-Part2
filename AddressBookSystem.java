package addressBookSystem;
import java.util.*;

public class AddressBookSystem {
    private List<Contacts> data;
    private Map<String, List<Contacts>> addressBooks;

    public AddressBookSystem() {
        this.data = new ArrayList<>();
        this.addressBooks = new HashMap<>();
    }

    public void addItem(Contacts contact) {
        data.add(contact);
    }

    public void multipleContact() {
        Scanner scanner = new Scanner(System.in);
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
            addItem(newContact);
        }
        System.out.println("Contacts added successfully!");
    }

    public void addAddressBook(String name) {
        List<Contacts> addressBook = new ArrayList<>();
        addressBooks.put(name, addressBook);
        System.out.println("Address Book '" + name + "' created successfully!");
    }

    public void addContactToAddressBook(String addressBookName) {
        if (addressBooks.containsKey(addressBookName.toUpperCase())) {
            multipleContact();
            addressBooks.get(addressBookName.toUpperCase()).addAll(data);
        } else {
            System.out.println("Address Book with name does not exist. Please create it first.");
        }
    }

    public void viewAllAddressBooks() {
        System.out.println("List of Address Books:");
        for (String addressBookName : addressBooks.keySet()) {
            System.out.println(addressBookName);
        }
    }

    public void viewContactsInAddressBook(String addressBookName) {
        List<Contacts> addressBook = addressBooks.get(addressBookName.toUpperCase());
        if (addressBook != null && !addressBook.isEmpty()) {
            System.out.println("Contacts in Address Book '" + addressBookName + "':");
            for (Contacts contact : addressBook) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
                System.out.println("Address: " + contact.getAddress());
                System.out.println("City: " + contact.getCity());
                System.out.println("State: " + contact.getState());
                System.out.println("Zip: " + contact.getZip());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                System.out.println();
            }
        } else {
            System.out.println("No contacts found in Address Book '" + addressBookName + "'.");
        }
    }

    public static void main(String[] args) {
        AddressBookSystem addressBookSystem = new AddressBookSystem();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Address Book System Menu:");
            System.out.println("1. Add Address Book");
            System.out.println("2. Add Contact to Address Book");
            System.out.println("3. View All Address Books");
            System.out.println("4. View Contacts in Address Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the Address Book to add: ");
                    String addressBookName = scanner.nextLine();
                    addressBookSystem.addAddressBook(addressBookName);
                    break;

                case 2:
                    System.out.print("Enter the name of the Address Book to add the contact: ");
                    String addressBookNameToAddContact = scanner.nextLine();
                    addressBookSystem.addContactToAddressBook(addressBookNameToAddContact);
                    break;

                case 3:
                    addressBookSystem.viewAllAddressBooks();
                    break;

                case 4:
                    System.out.print("Enter the name of the Address Book to view contacts: ");
                    String addressBookNameToViewContacts = scanner.nextLine();
                    addressBookSystem.viewContactsInAddressBook(addressBookNameToViewContacts);
                    break;

                case 5:
                    System.out.println("Exiting Address Book System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 5);

        // Close the scanner
        scanner.close();
    }
}
