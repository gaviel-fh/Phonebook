import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {
    private ArrayList<Contact> contacts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void proceed() {
        boolean isRunning = true;

        while(isRunning) {
            int userChoice = getUserChoice();

            switch(userChoice) {
                case 1: showOptions(); break;
                case 2: showContacts(contacts); break;
                case 3: addContact(); break;
                case 4: findContactByName(); break;
                case 5: deleteContactByExactName(); break;
                case 7: isRunning = false; break;
                default:
                    System.out.println("Invalid choice");
                    showOptions();
            }
        }
    }

    private void showOptions() {
        System.out.println("1. Show Options");
        System.out.println("2. Print all Contacts");
        System.out.println("3. Add Contact");
        System.out.println("4. Search Contact");
        System.out.println("5. Delete Contact by name");
        System.out.println("6. Edit Contact by name");
        System.out.println("7. quit");
    }

    private void showContacts(ArrayList<Contact> contacts) {
        if (contacts.size() == 0) {
            System.out.println("No contacts found");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                Contact currContact = contacts.get(i);
                System.out.println((i+1) + ". " + currContact.getName() + " -> " + currContact.getNumber());
            }
        }
    }

    public void addContact(Contact newContact) {
        contacts.add(newContact);
    }

    private void addContact() {
        System.out.print("Enter contact name: ");
        sc.nextLine(); // hack doesn't work without it
        String name = sc.nextLine();

        System.out.print("Enter contact number: ");
        String number = sc.nextLine();

        addContact(new Contact(name, number));
    }

    private ArrayList<Contact> findContactByName(String name) {
        ArrayList<Contact> foundContacts = new ArrayList<>();

        for (int i = 0; i < contacts.size(); i++) {
            Contact currContact = contacts.get(i);
            boolean contactContainsName =  currContact.getName().contains(name);

            if(contactContainsName) {
                foundContacts.add(currContact);
            }
        }

        return foundContacts;
    }

    private void findContactByName() {
        System.out.print("Enter name: ");
        sc.nextLine(); // hack doesn't work without it
        String name = sc.nextLine();

        ArrayList<Contact> foundContacts = findContactByName(name);
        showContacts(foundContacts);
    }

    private void deleteContactByExactName(String name) {
        ArrayList<Contact> foundContacts = findContactByName(name);

        if(foundContacts.size() == 1) {
            Contact contact = foundContacts.get(0);
            contacts.remove(contact);
        }
    }

    private void deleteContactByExactName() {
        System.out.print("Enter name of contact you want to delete: ");
        sc.nextLine(); // hack doesn't work without it
        String name = sc.nextLine();

        deleteContactByExactName(name);
    }

    private int getUserChoice() {
        System.out.print("Enter option: ");
        return sc.nextInt();
    }
}
