//package student.management.system;
//
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) {
//        /**
//         * Teacher objects
//         */
//        Teacher Jamie = new Teacher(1, "Jamie", 1200);
//        Teacher Kira = new Teacher(2, "Kira", 700);
//        Teacher Janet = new Teacher(3, "Janet", 2000);
//
//        /**
//         * Student objects
//         */
//        Student Kerwin = new Student(1, "Kerwin", 2);
//        Student Zack = new Student(2, "Zach", 4);
//        Student Jala = new Student(3, "Jala", 6);
//
//        /**
//         * School object
//         * When a school object is created, it takes in an ArrayList of Teachers and Students
//         *
//         * So we first need to create an ArrayList of Teachers and Students then add
//         * the teachers and students from the Teacher and Student objects
//         */
//        ArrayList<Teacher> teacherList = new ArrayList<>();
//        teacherList.add(Jamie);
//        teacherList.add(Kira);
//        teacherList.add(Janet);
//
//        ArrayList<Student>studentList = new ArrayList<>();
//        studentList.add(Kerwin);
//        studentList.add(Zack);
//        studentList.add(Jala);
//
//        School chss = new School(teacherList, studentList);
//
//        System.out.println("Total Money Earned: " + chss.getTotalMoneyEarned());
//
//        Kerwin.payFees(10000);
//        System.out.println("Remaining Fees: $" + Kerwin.getRemainingFees());
//        System.out.println("Total Money Earned: " + chss.getTotalMoneyEarned());
//
//        Jamie.recievedSalary(Jamie.getTeacherSalary());
//
//        System.out.println("CHSS has paid the salary to " + Jamie.getName() +
//        " and now has " + chss.getTotalMoneyEarned());
//    }
//}
