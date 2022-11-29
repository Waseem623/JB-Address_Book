package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    public static final int CREATE_CONTACT = 1;
    public static final int EDIT_CONTACT = 2;
    public static final int DELETE_CONTACT = 3;
    public static final int CHANGE_ADDRESS_BOOK = 4;
    public static final int PRINT_CONTACTS = 5;
    public static final int ZERO = 0;
    AddressBook addressBook;
    static Scanner sc;

    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        sc = new Scanner(System.in);
        HashMap<String, AddressBook> addressBookMap = new HashMap<>();

        System.out.println("How many address book do you want to add ? : ");
        int noOfAddressBook = sc.nextInt();

        for (int i = 0; i < noOfAddressBook; i++) {
            System.out.println("Enter address book name : ");
            String addressBookName = sc.next();
            boolean isAddressBookPresent = addressBookMap.containsKey(addressBookName);
            if (isAddressBookPresent)
                System.out.println("Address book already exist");
            else
                addressBookMap.put(addressBookName, new AddressBook(addressBookName));
        }

        addressBookMain.selectAddressBook(addressBookMap);
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
                        addressBookMain.addressBook.createNewContact();
                    }
                    break;
                case EDIT_CONTACT:
                    System.out.println("Enter firstname and last name to edit contact : ");
                    firstName = sc.next();
                    lastName = sc.next();
                    addressBookMain.addressBook.editContact(firstName + lastName);
                    break;
                case DELETE_CONTACT:
                    System.out.println("Enter firstname and last name to edit contact : ");
                    firstName = sc.next();
                    lastName = sc.next();
                    addressBookMain.addressBook.deleteContact(firstName + lastName);
                    break;
                case CHANGE_ADDRESS_BOOK:
                    addressBookMain.selectAddressBook(addressBookMap);
                    break;
                case PRINT_CONTACTS:
                    System.out.println(addressBookMain.addressBook);
                    break;
                case ZERO:
                    return;
                default:
                    System.out.println("Invalid choice ");
                    break;
            }
        }
    }


    private void selectAddressBook(HashMap<String, AddressBook> addressBookMap) {
        System.out.println("Select address book to create/edit/delete contact : ");
        for (String addressBook : addressBookMap.keySet()) {
            System.out.println(addressBook);
        }
        String addressBookName = sc.next();
        addressBook = addressBookMap.get(addressBookName);
    }
}