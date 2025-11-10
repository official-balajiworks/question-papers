import java.util.ArrayList;
import java.util.HashSet;

class PhoneBook {
    String name;
    int phoneNumber;

    // Constructor
    PhoneBook(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // toString method to display phone details
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<PhoneBook> phoneList = new ArrayList<>();

        // Adding at least 5 PhoneBook objects (including duplicates)
        phoneList.add(new PhoneBook("Alice", 987654321));
        phoneList.add(new PhoneBook("Bob", 912345678));
        phoneList.add(new PhoneBook("Charlie", 998877665));
        phoneList.add(new PhoneBook("Alice", 987654321));  // duplicate name
        phoneList.add(new PhoneBook("David", 900000111));

        // Remove duplicate names
        ArrayList<PhoneBook> uniqueList = new ArrayList<>();
        HashSet<String> namesSet = new HashSet<>();

        for (PhoneBook pb : phoneList) {
            if (!namesSet.contains(pb.name)) {
                namesSet.add(pb.name);
                uniqueList.add(pb);
            }
        }

        // Display unique PhoneBook entries
        System.out.println("Unique PhoneBook Entries:");
        for (PhoneBook pb : uniqueList) {
            System.out.println(pb);
        }
    }
}
