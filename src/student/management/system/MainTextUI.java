package student.management.system;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTextUI {
    private static Scanner kbd = new Scanner(System.in);
    /**
     * Created School object that has 2 empty ArrayList parameters
     */
    private static School school = new School(new ArrayList<>(), new ArrayList<>());

    public static void main(String[] args) {


        /**
         * ----MAIN MENU----
         */

        while(true){
            System.out.println("\n=========================================");
            System.out.println("   SCHOOL MANAGEMENT SYSTEM");
            System.out.println("=========================================");
            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. School Finances");
            System.out.println("4. Exit");
            System.out.println("-----------------------------------------\nEnter your choice: ");

            int choice = getIntInput();

            switch (choice){
                case 1 -> studentMenu();
                case 2 -> teacherMenu();
                case 3 -> financeMenu();
                case 4 -> {
                    System.out.println("Thank you for using the School Management System");
                    return;
                }
                default -> System.out.println("Invalid choice. try again.");
            }
        }
    }

    /**
     *
     * -----STUDENT MENU-----
     */

    private static void studentMenu() {
        while (true) {
            System.out.println("\n=========================================");
            System.out.println("         STUDENT MANAGEMENT");
            System.out.println("=========================================");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Grade");
            System.out.println("3. Record Student Fee Payment");
            System.out.println("4. View All Students");
            System.out.println("5. View Student by ID");
            System.out.println("6. Back to Main Menu");
            System.out.println("-----------------------------------------\nEnter your choice: ");

            int choice = getIntInput();

            switch (choice){
                case 1 -> addStudent();
                case 2 -> updateStudentGrade();
                case 3 -> recordStudentFee();
                case 4 -> viewAllStudents();
                case 5 -> viewStudentById();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     *
     *  Main logic for Student Console Menu
     */

    private static void addStudent(){
        System.out.print("Create student ID");
        int id = getIntInput();
        System.out.print("Enter student name: ");
        String name = kbd.nextLine();
        System.out.print("Enter student grade: ");
        int grade = getIntInput();

        Student student = new Student(id, name, grade);
        school.addStudent(student);
        System.out.println("Student has been added successfully!");
    }

    private static void updateStudentGrade(){
        System.out.print("Enter student ID: ");
        int id = getIntInput();
        Student student = findStudentByID(id);

        if(student != null){
            System.out.print("Enter new grade: ");
            int grade = getIntInput();
            student.setGrade(grade);
            System.out.println("Grade updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void recordStudentFee(){
        System.out.print("Enter student ID");
        int id = getIntInput();
        Student student = findStudentByID(id);
        if(student != null){
            System.out.print("Enter amount: ");
            double fee = getDoubleInput();
            student.payFees(fee);
            System.out.println("Payment successful!");
            System.out.println(student.getName() + " has paid " + student.getFeesPaid() +
                    ". Remaining fees: " + student.getRemainingFees());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents(){
        if(school.getStudent().isEmpty()){
            System.out.println("No student found.");
            return;
        }
        System.out.println("List of all students:");
        for(Student s : school.getStudent()){
            printStudentInfo(s);
        }
    }
    private static void viewStudentById(){
        System.out.print("Enter student ID: ");
        int id = getIntInput();
        Student student = findStudentByID(id);
        if(student != null){
            printStudentInfo(student);
        } else {
            System.out.println("Student not found.");
        }
    }
    /**
     * Method to print Student Information
     */
    private static void printStudentInfo(Student s){
        System.out.println("-----------------------------------------");
        System.out.println("ID: " + s.getStudentId() + " | Name: " + s.getName() + " | Grade: " + s.getGrade());
        System.out.println("Fees Paid: " + s.getFeesPaid() + " | Remaining: " + s.getRemainingFees());
        System.out.println("-----------------------------------------");
    }

    /**
     *
     * @param id Method which find students by their ID
     *           It loops through the ArrayList of students and checks if the student
     *           id exist. If it exists then it returns the ID, if not then in returns null
     * @return
     */
    private static Student findStudentByID(int id){
        for(Student s : school.getStudent()){
            if(s.getStudentId() == id){
                return s;
            }
        }
        return null;
    }
    /**
     * -----Teacher Menu------
     */

    private static void teacherMenu(){
        while (true){
            System.out.println("\n=========================================");
            System.out.println("         TEACHER MANAGEMENT");
            System.out.println("=========================================");
            System.out.println("1. Add Teacher");
            System.out.println("2. Update Teacher Salary");
            System.out.println("3. Record Teacher Salary Payment");
            System.out.println("4. View All Teachers");
            System.out.println("5. View Teacher by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("-----------------------------------------\nEnter your choice: ");

            int choice = getIntInput();

            switch (choice){
                case 1 -> addTeacher();
                case 2 -> updateTeacherSalary();
                case 3 -> recordTeacherSalary();
                case 4 -> viewAllTeachers();
                case 5 -> viewTeacherById();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice, Try again.");
            }
        }
    }

    private static void addTeacher(){
        System.out.print("Create an ID: ");
        int id = getIntInput();
        System.out.print("Enter a name: ");
        String name = kbd.nextLine();
        System.out.print("Enter salary: ");
        double salary = getDoubleInput();

        Teacher teacher = new Teacher(id, name, salary);
        school.addTeacher(teacher);
    }

    private static void updateTeacherSalary(){
        System.out.print("Enter teacher ID: ");
        int id = getIntInput();
        Teacher teacher = findTeacherById(id);
        if(teacher != null){
            System.out.print("Enter new teacher salary: ");
            double salary = getDoubleInput();
            teacher.setSalary(salary);
            System.out.println("Teacher salary successfully updated!");
        } else {
            System.out.println("Teacher not found");
        }
    }

    private static void recordTeacherSalary(){
        System.out.print("Enter teacher ID : ");
        int id = getIntInput();
        Teacher teacher = findTeacherById(id);

        if(teacher != null){
            System.out.print("Enter salary: ");
            double salary = getDoubleInput();
            teacher.recievedSalary(salary);
            System.out.println("Salary has been successfully recorded.");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private static void viewAllTeachers(){
        if(school.getTeacher().isEmpty()){
            System.out.println("No teachers found.");
        }
        for(Teacher t : school.getTeacher()){
            printTeacherInfo(t);
        }
    }

    private static void viewTeacherById(){
        System.out.println("Enter teacher ID: ");
        int id = getIntInput();
        Teacher teacher = findTeacherById(id);

        if(teacher != null){
            printTeacherInfo(teacher);
        } else {
            System.out.println("Teacher not found");
        }
    }

    /**
     * Finding teacher by ID
     * @param id
     * @return
     */
    private static Teacher findTeacherById(int id){
        for(Teacher t : school.getTeacher()){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    /**
     *
     * @param t Print Teacher Information
     */
    private static void printTeacherInfo(Teacher t){
        System.out.println("-----------------------------------------");
        System.out.println("ID: " + t.getId() + " | Name: " + t.getName() + " | Salary: " + t.getTeacherSalary());
        System.out.println("-----------------------------------------");
    }














    /**
     *
     * @return User input methods!
     */
    private static int getIntInput(){
        while(true){
            try {
                int choice = Integer.parseInt(kbd.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number: ");
            }
        }
    }

    private static double getDoubleInput(){
        while(true){
            try{
                double choice = Double.parseDouble(kbd.nextLine());
            } catch (Exception e) {
                System.out.println("Invalide input. Enter a decimal number");
            }
        }
    }
}

