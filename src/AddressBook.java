import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    String addressBookName;
    HashMap<String, Contact> contactMap;

    public AddressBook() {
        contactMap = new HashMap<>();
    }

    public AddressBook(String addressBookName) {
        this.addressBookName = addressBookName;
        contactMap = new HashMap<>();
    }

    public AddressBook(HashMap<String, Contact> contactMap) {
        this.contactMap = new HashMap<>();
        this.contactMap = contactMap;
    }

    public HashMap<String, Contact> getContactMap() {
        return contactMap;
    }

    public void setContactMap(HashMap<String, Contact> contactMap) {
        this.contactMap = contactMap;
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public void createNewContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your details to create contact : ");
        System.out.print(" First name = ");
        String firstName = sc.next();
        System.out.print("\n Last name = ");
        String lastName = sc.next();
        System.out.print("\n Phone no = ");
        String phoneNo = sc.next();
        System.out.print("\n Email Id = ");
        String emailId = sc.next();
        System.out.print("\n Area = ");
        String area = sc.next();
        System.out.print("\n City = ");
        String city = sc.next();
        System.out.print("\n State = ");
        String state = sc.next();
        System.out.print("\n Zip = ");
        int zip = sc.nextInt();
        Address address = new Address(area, city, state, zip);
        Contact contact = new Contact(firstName, lastName, Long.parseLong(phoneNo), emailId, address);
        contactMap.put(contact.getFirstName() + contact.getLastName(), contact);
        System.out.println(contactMap.get(contact.getFirstName() + contact.getLastName()));
    }

    public void editContact(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new phone no = ");
        String phoneNo = sc.next();
        contactMap.get(name).setPhoneNumber(Long.parseLong(phoneNo));
        System.out.println(contactMap.get(name));
    }

    public void deleteContact(String name) {
        System.out.println("Deleted : " + contactMap.remove(name));
    }

    @Override
    public String toString() {
        return " contactList = \n" + contactMap;
    }

}