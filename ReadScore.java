import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadScores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = input.nextLine();

        try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);

            double total = 0;
            int count = 0;

            while (fileReader.hasNext()) {
                if (fileReader.hasNextDouble()) {
                    total += fileReader.nextDouble();
                    count++;
                } else {
                    fileReader.next(); // skip invalid data
                }
            }

            fileReader.close();

            if (count > 0) {
                double average = total / count;
                System.out.println("Total: " + total);
                System.out.println("Average: " + average);
            } else {
                System.out.println("No valid scores found in the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        input.close();
    }
}
