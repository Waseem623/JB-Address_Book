import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookOperations {
    public static final int CREATE_CONTACT = 1;
    public static final int EDIT_CONTACT = 2;
    public static final int DELETE_CONTACT = 3;
    public static final int CHANGE_ADDRESS_BOOK = 4;
    public static final int PRINT_CONTACTS = 5;
    public static final int ZERO = 0;
    HashMap<String, AddressBook> addressBookMap;

    void generateMenuToOperateAddressBook(AddressBook addressBook) {
        Scanner sc = new Scanner(System.in);
        String firstName;
        String lastName;
        while (true) {
            System.out.println("Enter your choice : ");
            System.out.println("1 : Create new contact ");
            System.out.println("2 : Edit existing contact ");
            System.out.println("3 : Delete contact ");
            System.out.println("4 : Change address book ");
            System.out.println("5 : Print all contacts ");
            System.out.println("0 : Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case CREATE_CONTACT:
                    System.out.println("Enter how many contacts do you want to add : ");
                    int noOfContacts = sc.nextInt();
                    for (int i = 0; i < noOfContacts; i++) {
                        addressBook.createNewContact();
                    }
                    break;
                case EDIT_CONTACT:
                    System.out.println("Enter firstname and last name to edit contact : ");
                    firstName = sc.next();
                    lastName = sc.next();
                    addressBook.editContact(firstName + lastName);
                    break;
                case DELETE_CONTACT:
                    System.out.println("Enter firstname and last name to edit contact : ");
                    firstName = sc.next();
                    lastName = sc.next();
                    addressBook.deleteContact(firstName + lastName);
                    break;
                case CHANGE_ADDRESS_BOOK:
                    selectAddressBook();
                    break;
                case PRINT_CONTACTS:
                    System.out.println(addressBook);
                    break;
                case ZERO:
                    return;
                default:
                    System.out.println("Invalid choice ");
                    break;
            }
        }
    }

    public void addAddressBooks() {
        Scanner sc = new Scanner(System.in);
        addressBookMap = new HashMap<>();

        System.out.println("How many address book do you want to add ? : ");
        int noOfAddressBook = sc.nextInt();

        for (int i = 0; i < noOfAddressBook; i++) {
            System.out.println("Enter address book name : ");
            String addressBookName = sc.next();
            boolean isAddressBookPresent = addressBookMap.containsKey(addressBookName);
            if (isAddressBookPresent) {
                System.out.println("Address book already exist");
                i--;
            } else
                addressBookMap.put(addressBookName, new AddressBook(addressBookName));
        }
    }

    AddressBook selectAddressBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select address book to create/edit/delete contact : ");
        ArrayList<String> addressBookNames = new ArrayList<String>(addressBookMap.keySet());
        for (int i = 0; i < addressBookNames.size(); i++) {
            System.out.println(i + 1 + " : " + addressBookNames.get(i));
        }
        int addressBookNameIndex = sc.nextInt() - 1;
        if (addressBookNameIndex >= addressBookNames.size()) {
            System.out.println("Address book not available. ");
            return null;
        }
        return addressBookMap.get(addressBookNames.get(addressBookNameIndex));
    }
}