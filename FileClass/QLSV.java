package FileClass;
import java.io.*;
import java.util.Scanner;

public class QLSV {
    protected String path;

    public QLSV(String path) {
        this.path = path;
    }

    //Create a file
    public void createFile() throws IOException {
        File fileName = new File(path);
        fileName.createNewFile();
    }

    //Write a Students List
    public void writeStudents() {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) { // dùng append
            System.out.print("Enter number of students: ");
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("Student " + (i + 1));
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter age: ");
                int age = Integer.parseInt(scanner.nextLine());

                writer.write(name + ", " + age);  // hoặc tách thành nhiều dòng nếu muốn
                writer.newLine(); // ghi xuống dòng
            }
            System.out.println("✅ Students written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format.");
        }
    }
    
    //Read a Students list
    public void readStudents()
    {
        try {
            BufferedReader readList = new BufferedReader(new FileReader(path));
            String readLine;
            while ((readLine = readList.readLine()) != null)
            {
                System.out.println(readLine);
            }
        }catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    //Display File information
    public void fileInformation()
    {
        File file = new File(path);
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Can Write: " + file.canWrite());
        System.out.println("Can Read: " + file.canRead());
        System.out.println("File length: " + file.length());
    }
    
    //Check if file exists
    public void checkExists()
    {
        File file = new File(path);
        if(file.exists())
        {
            System.out.println("File exists");
        }else
        {
            System.out.println("File does not exists");
        }
    }
    
    //Count lines
    public void countLines() throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader readList = new BufferedReader(new FileReader(path));
        int count = 0;
        while (readList.readLine() != null)
        {
            count++;
        }
        System.out.println("Count Lines: " + count);
    }
    
    
}
