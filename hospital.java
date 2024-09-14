// Develop a sophisticated Java program to manage various aspects of a
// hospital or healthcare facility. This system should include modules for
// patient registration, appointment scheduling, electronic health records
// (EHR), billing and invoicing, inventory management for medical supplies,
// and staff management.
package Jvaprojects;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class hospitalmanagement {
    
    String name ;
    int age;
    String address ;
    String contactnumber;
    String gender ;
    
    public void register(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("\nEnter name:");
        this.name = sc.nextLine();
        System.out.println("\nEnter age:");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.println("\nEnter the address:");
        this.address = sc.nextLine();
        System.out.println("\nEnter contact number:");
        this.contactnumber = sc.nextLine();
        System.out.println("\nEnter the gender (male or female):");
        this.gender = sc.nextLine();
        System.out.println("\nEnter your Id:");
        this.id = sc.nextInt();
        sc.nextLine();
        System.out.println("\nEnter your password:");
        this.password = sc.nextLine();
        System.out.println("\nRegistration is succesful.");
    }

    public void appointmentschedule(){
      String [] columnNames ={"SNo.","Names","Age"};
        int numRows = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of rows of data you want to input:"));
        String [][] data = new String[numRows][3];
        for(int i = 0; i <numRows ; i++){
            data[i][0] = String.valueOf(i +1);
            data[i][1] = JOptionPane.showInputDialog("Enter the name for row "+ (i+1) +":");
            data[i][2]=JOptionPane.showInputDialog("Enter the age for the row" + (i+1)+":");
        }


        JTable table = new JTable(data , columnNames);
         JFrame frame = new JFrame("Table Demo");

        frame.add(new JScrollPane(table));

         frame.setSize(500,300);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
     
    }

    public void billing(){
        Scanner in = new Scanner(System.in);
         System.out.println("Enter the cost of the surgery:\n");

        double charges = in.nextDouble();
        double tax = 0.05 * charges;
        double supplies = (charges + tax)*0.18;
        double totalBill = charges + tax + supplies;

        System.out.printf("The cost of the surgery:%f\n",charges);
        System.out.printf("tax:%f\n",tax);
        System.out.printf("supplies:%f\n",supplies);
        System.out.printf("Total bill:%f\n",totalBill);

    }
    public void medicalSupplies(){
        String [] columnNames ={"SNo.","ProductName","Chemist","Quantity"};
        int numRows = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of rows of data you want to input:"));
        String [][] data = new String[numRows][4];
        for(int i = 0; i <numRows ; i++){
            data[i][0] = String.valueOf(i +1);
            data[i][1] = JOptionPane.showInputDialog("Enter the product name for row "+ (i+1) +":");
            data[i][2]=JOptionPane.showInputDialog("Enter the chemist shop name for the row" + (i+1)+":");
            data[i][3]= JOptionPane.showInputDialog("Enter the quantiy of the product for the row:"+(i+1)+":");
        }
        JTable table = new JTable(data , columnNames);
         JFrame frame = new JFrame("Table Demo");

        frame.add(new JScrollPane(table));

         frame.setSize(500,300);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
    }
    int id ;
    int salary;
    String designation;
    String password;


   public void staff(){
    Scanner sc = new Scanner(System.in);
    System.out.println("\nEnter your name:");
    this.name = sc.nextLine();
    System.out.println("\nEnter your age:");
    this.age= sc.nextInt();
    sc.nextLine();
    System.out.println("\nEnter your Id:");
    this.id= sc.nextInt();
    sc.nextLine();
    System.out.println("\nEnter your address:");
    this.address = sc.nextLine();
    System.out.println("\nEnter your contact number:");
    this.contactnumber = sc.nextLine();
    System.out.println("\nEnter your Salary:");
    this.salary = sc.nextInt();
    System.out.println("\nEnter your designation:");
    this.designation = sc.nextLine();
    System.out.println("\nEnter your password:");
    this.password = sc.nextLine();
    System.out.println("\nStass registration successful.");

    }
   public boolean login(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
       
        System.out.println("\nEnter your ID:");
        int enteredId = sc.nextInt();
        sc.nextLine(); 
        if (enteredId == id) {
            System.out.println("\nEnter your password: ");
            String enteredPassword = sc.nextLine();
            if (enteredPassword.equals(password)) {
                System.out.println("\nLogin Successful.");
                return true;
            } else {
                System.out.println("\nIncorrect Password.");
                return false;
            }
        } else {
            System.out.println("\nID not found.");
            return false;
        }
    }

    }



public class hospital {
    public static int takenIntegerInput(int limit ){
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try  {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if ( flag && input>limit || input<1) {
                    System.out.println("Choose the number between 1 to" +limit);
                      flag = false;

                }

            } catch (Exception e) {
                System.out.println("Enter only interger value.");
                 flag = false;

            }
        }
        return input;

    }
       public static void main(String[] args) {
        System.out.println("******************************WELCOME TO THE LIFE SAVER HOSPITAL**************************************");
        System.out.println("choose any one option:");
        System.out.println("\n1- Register as patient\n2- Register as staff\n3- exit");
        int choose= takenIntegerInput(3);
        hospitalmanagement b = new hospitalmanagement();
        if(choose==1){
            b.register();;
            System.out.println("Enter your choise:");
            System.out.println("\n1- login\n2- exit");
            int ch = takenIntegerInput(2);
            if (ch==1&& b.login()) {
                b.login();
                System.out.println("Enter your choise:");
                System.out.println("\n1- Schedule Appointment\n2- exit");
                int sch = takenIntegerInput(2);
                if (sch==1) {
                    b.appointmentschedule();
                
                }
            }
        }
        else if (choose == 2) {
            b.staff();
            System.out.println("Enter your choise:");
            System.out.println("\n1- login\n2- Information of medical supplies\n3- for billing\n4- exit");
            int st = takenIntegerInput(4);
            if (st == 1 && b.login()) {
                System.out.println("Login Successful.");
            } else if (st == 2) {
                b.medicalSupplies();
            } else if (st == 3) {
                b.billing();
            }

        }else{
            System.exit(0);
        }
    }
}
    
