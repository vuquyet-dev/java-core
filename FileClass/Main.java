package FileClass;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String path = scanner.nextLine();
        QLSV qlsv = new QLSV(path);
        while (true)
        {
            System.out.println("===================================");
            System.out.println("1. Create a new file");
            System.out.println("2. Write students list to file");
            System.out.println("3. Read students list from file");
            System.out.println("4. Display information");
            System.out.println("5. Check exists");
            System.out.println("6. Count Lines");
            System.out.println("7. Exit");
            System.out.println("===================================");
            System.out.println("\nEnter selection: ");
            int choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose)
            {
                case 1:
                    System.out.println("Create file");
                    break;
                case 2:
                    System.out.println("Write student list: ");
                    qlsv.writeStudents();
                    break;
                case 3:
                    System.out.println("Read students list: ");
                    qlsv.readStudents();
                    break;
                case 4:
                    System.out.println("Display information: ");
                    qlsv.fileInformation();
                    break;
                case 5:
                    System.out.print("Check exists: ");
                    qlsv.checkExists();
                    break;
                case 6:
                    qlsv.countLines();
                    break;
                case 7:
                    scanner.close();
                    break;
                    
            }
        }


    }
}
