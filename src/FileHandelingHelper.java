import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandelingHelper {
    public static ArrayList<Contact> readContactsFromFile(String filePath) {
        ArrayList<Contact> contacts = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()) {
                String[] splitContact = sc.nextLine().split(";");
                contacts.add(new Contact(splitContact[0].trim(), splitContact[1].trim()));
            }
        } catch(IOException e) {
            System.out.println("Sh went wrong: " + e);
        }

        return contacts;
    }

    public static void writeContactsToFile(String filePath, ArrayList<Contact> contacts) {
        try {
            FileWriter myWriter = new FileWriter(filePath);

            for(int i = 0; i < contacts.size(); i++) {
                Contact currContact = contacts.get(i);
                myWriter.write(currContact.getName() + ";" + currContact.getNumber() + "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("Sth went wrong: " + e);
        }
    }

    public static void generateHTMLFile(String filePath, ArrayList<Contact> contacts) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            String content = generateHTMLContent(contacts);

            myWriter.write(content);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("Sth went wrong: " + e);
        }

    }

    private static String generateHTMLContent(ArrayList<Contact> contacts) {
        StringBuilder string = new StringBuilder();
        string.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"utf-8\" />" +
                "    <title>MyContacts</title>" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />" +
                "</head>" +
                "<body><table><tr><th>Name</th><th>Number</th></tr>");

        for (Contact contact : contacts) {
            string.append("<tr><td>" + contact.getName() + "</td>" + "<td>" + contact.getNumber() + "</td></tr>");
        }

        string.append("</table></body></html>");

        return string.toString();
    }
}
