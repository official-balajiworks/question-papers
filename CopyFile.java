import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("file1.txt");
            FileOutputStream fout = new FileOutputStream("file2.txt");

            int c;
            while ((c = fin.read()) != -1) {
                fout.write(c);
            }

            fin.close();
            fout.close();

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
