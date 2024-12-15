

//ONLINE QUIZ SYSTEM: 
//SYED IMRAN MURTAZA | MUHAMMAD SHEREYAR

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizSystem {

    
    private Quiz quiz;

    public QuizSystem() {
        
        quiz = new Quiz();
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Welcome to the Quiz!");
            System.out.print("Press l to login, r to register, a for admin panel, or e to exit: ");
            String choice = scanner.nextLine();

            if (choice.equals("l")) {
                login();
            } else if (choice.equals("r")) {
                register();
            } else if (choice.equals("a")) {
                quiz.adminPanel();  // Access admin panel using the quiz instance
            } else if (choice.equals("e")) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid Input! Please choose 'l' to login, 'r' to register, 'a' for admin panel, or 'e' to exit.");
            }
        }
    }

    // Node storing names:
    private static class Node {
        String regName;
        Node next;

        Node(String name) {
            this.regName = name;
            this.next = null;
        }
    }

    // Node storing passwords:
    private static class Node2 {
        String regPass;
        Node2 next;

        Node2(String password) {
            this.regPass = password;
            this.next = null;
        }
    }

    private Node head;
    private Node2 head2;

    void login() {
        if (head == null || head2 == null) {
            System.out.println("No registered users. Please register first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String pass = scanner.nextLine();

        if (validateUser(name, pass)) {
            System.out.println();
            System.out.println("Welcome, " + name + "! You are successfully logged in.");
            quiz.startQuiz();  // Start the quiz with the quiz instance
        } else {
            System.out.println("Invalid name or password. Try again.");
        }
    }

    void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String pass = scanner.nextLine();

        addUser(name, pass);
        System.out.println("You are successfully registered!");
        saveData();
    }

    void addUser(String name, String pass) {
        Node newNameNode = new Node(name);
        Node2 newPassNode = new Node2(pass);

        if (head == null) {
            head = newNameNode;
            head2 = newPassNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNameNode;

            Node2 temp2 = head2;
            while (temp2.next != null) {
                temp2 = temp2.next;
            }
            temp2.next = newPassNode;
        }
    }

    boolean validateUser(String name, String pass) {
        Node nameNode = head;
        Node2 passNode = head2;

        while (nameNode != null && passNode != null) {
            if (nameNode.regName.equals(name) && passNode.regPass.equals(pass)) {
                return true;
            }
            nameNode = nameNode.next;
            passNode = passNode.next;
        }
        return false;
    }

    void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userData.txt"))) {
            Node nameNode = head;
            Node2 passNode = head2;

            while (nameNode != null && passNode != null) {
                writer.write(nameNode.regName + "," + passNode.regPass);
                writer.newLine();
                nameNode = nameNode.next;
                passNode = passNode.next;
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("userData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                addUser(data[0], data[1]);
            }
        } catch (IOException e) {
            System.out.println("No previous data found or error loading data: " + e.getMessage());
        }
    }





/////




    public static void main(String[] args) {
        QuizSystem main = new QuizSystem();
        main.loadData();
        main.start();
    }
}