import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some test Employee PayrollData objects
        EmployeePayrollData emp1 = new EmployeePayrollData(1, "Eren", 500000000);
        EmployeePayrollData emp2 = new EmployeePayrollData(2, "Levi Ackerman", 1000000);
        EmployeePayrollData emp3 = new EmployeePayrollData(3, "Mikasa Ackerman", 45000000);
        // Store these objects in a list
        List<EmployeePayrollData> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        // Write Employee Payroll to a file
        String filename = "employeePayroll.txt";
        writeEmployeePayrollToFile(employeeList, filename);

        // Print the employee payroll entries from the file
        printEmployeePayrollFromFile(filename);

        // Count the number of entries in the file to ensure the operation worked
        countFileEntries(filename);
    }

    // Method to write employee payroll data to a file
    private static void writeEmployeePayrollToFile(List<EmployeePayrollData> employeeList, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (EmployeePayrollData employee : employeeList) {
                writer.write(employee.toString());
                writer.newLine();
            }
            System.out.println("Employee payroll data written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to print employee payroll data from a file
    private static void printEmployeePayrollFromFile(String filename) {
        System.out.println("\nPrinting Employee Payroll Data from File:\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    // Method to count the number of entries in the file
    private static void countFileEntries(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("\nNumber of entries in the file: " + lineCount);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}