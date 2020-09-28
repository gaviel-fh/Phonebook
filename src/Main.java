public class Main {
    public static void main(String[] args) {
        Contact pers1 = new Contact("david raese", "+43 677 4535234");
        Contact pers2 = new Contact("christine schiller", "+43 297 3790687");
        Contact pers3 = new Contact("david kaise", "+43 659 6824164");
        // Testing Contact Class
//        Contact newContact = new Contact("david raese", "+43 677 627489");
//        String contactStringTest = newContact.toString();
//        System.out.println(contactStringTest);

        // Testing Phonebook class
        Phonebook myPhonebook = new Phonebook();
        myPhonebook.addContact(pers1);
        myPhonebook.addContact(pers2);
        myPhonebook.addContact(pers3);

        myPhonebook.proceed();


    }
}
