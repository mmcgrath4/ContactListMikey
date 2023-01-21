import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    private ArrayList<Person> contacts;
    private Scanner s;

    public ContactList() {
        contacts = new ArrayList<>();
        s = new Scanner(System.in);
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        System.out.println("Select a type of contact to add:\n1. Student\n2. Adult");
        // Can we assume that this will be a valid input?
        int input = s.nextInt();
        s.nextLine();
        System.out.println("Please fill in the following information:.\nFirst Name:");
        String firstName = s.nextLine();
        System.out.println("Last Name:");
        String lastName = s.nextLine();
        System.out.println("Phone Number");
        String number = s.nextLine();
        // Asks grade for students
        if (input == 1) {
            System.out.println("Grade:");
            int grade = s.nextInt();
            contacts.add(new Student(firstName, lastName, number, grade));
        }
        // Asks job for adults
        else {
            System.out.println("Job:");
            String job = s.nextLine();
            contacts.add(new Adult(firstName, lastName, number, job));
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        if (sortBy == 1) {
            sortByFirstName();
        }
        else if (sortBy == 2) {
            sortByLastName();
        }
        else if (sortBy == 3) {
            sortByPhoneNumber();
        }
    }

    public void sortByFirstName() {
        int length = contacts.size();
        Person temp;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                // Checks if first element is greater than its following element
                if (contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0) {
                    // Swaps the two

                }
            }
        }
    }

    public void sortByLastName() {
        int length = contacts.size();
        Person temp;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                // Checks if first element is greater than its following element
                if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                    // Swaps the two
                    Collections.swap(contacts, j, j+1);
                }
            }
        }
    }

    public void sortByPhoneNumber() {
        int length = contacts.size();
        Person temp;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                // Checks if first element is greater than its following element
                if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0) {
                    // Swaps the two
                    Collections.swap(contacts, j, j+1);
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person contact: contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person contact: contacts) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact: contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        for (Person contact: contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        int input;
        do {
            printMenuOptions();
            input = s.nextInt();
            s.nextLine();
            //Add Contact
            if (input == 1) {
                addContact();
            }
            // List by first name
            else if (input == 2) {
                sort(1);
                printContacts();
            }
            // List by last name
            else if (input == 3) {
                sort(2);
                printContacts();
            }
            // List by phone numbe
            else if (input == 4) {
                sort(3);
                printContacts();
            }
            // List all students
            else if (input == 5) {
                listStudents();
            }
            // search by first name
            else if (input == 6) {
                System.out.println("Enter a Name:");
                String name = s.nextLine();
                if (searchByFirstName(name) == null) {
                    System.out.println(name + " is not in the list.");
                }
                else {
                    System.out.println(searchByFirstName(name));
                }
            }
            // Search by last name
            else if (input == 7) {
                System.out.println("Enter a Name:");
                String name = s.nextLine();
                if (searchByLastName(name) == null) {
                    System.out.println(name + " is not in the list.");
                }
                else {
                    System.out.println(searchByLastName(name));
                }
            }
            // Search by phone number
            else if (input == 8) {
                System.out.println("Enter a Phone Number:");
                String number = s.nextLine();
                if (searchByPhoneNumber(number) == null) {
                    System.out.println(number + " is not in the list.");
                }
                else {
                    System.out.println(searchByPhoneNumber(number));
                }
            }
        } while (input != 0);

    }

    public static void main(String[] args)
    {
//        String x = "x";
//        String a = "a";
//        System.out.println(x.compareTo(a));
//        if (x.compareTo(a) == -1) {
//            System.out.println("swap");
//        }
        ContactList cl = new ContactList();
        cl.run();
    }
}
