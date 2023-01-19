import java.util.ArrayList;
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
        contacts = new ArrayList<Person>();
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
        int input = s.nextInt();
        System.out.println("Please fill in the following information:.\nFirst Name:");
        String firstName = s.nextLine();
        System.out.println("Last Name:");
        String lastName = s.nextLine();
        System.out.println("Phone Number");
        String number = s.nextLine();
        if (input == 1) {
            System.out.println("Grade:");
            int grade = s.nextInt();
            contacts.add(new Student(firstName, lastName, number, grade));
        }
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
        int length = contacts.size();
        Person temp;
        if (sortBy == 1) {
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length - i; j++) {
                    // Checks if first element is greater than its following element
                    if (contacts.get(i-1).getFirstName().compareTo(contacts.get(i).getFirstName()) == -1) {
                        // Swaps the two
                        temp = contacts.get(i-1);
                        contacts.set(i-1, contacts.get(i));
                        contacts.set(i, temp);
                    }
                }
            }
        }
        else if (sortBy == 2) {
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length - i; j++) {
                    // Checks if first element is greater than its following element
                    if (contacts.get(i-1).getLastName().compareTo(contacts.get(i).getLastName()) == -1) {
                        // Swaps the two
                        temp = contacts.get(i-1);
                        contacts.set(i-1, contacts.get(i));
                        contacts.set(i, temp);
                    }
                }
            }
        }
        else if (sortBy == 3) {
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length - i; j++) {
                    // Checks if first element is greater than its following element
                    if (contacts.get(i-1).getPhoneNumber().compareTo(contacts.get(i).getPhoneNumber()) == -1) {
                        // Swaps the two
                        temp = contacts.get(i-1);
                        contacts.set(i-1, contacts.get(i));
                        contacts.set(i, temp);
                    }
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
        printMenuOptions();

        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
