package student.management.system;
import java.util.ArrayList;

/**
 * This class holds many teachers and students using ArrayList.
 * Setting the instance variables as static allows us to use them
 * outside the School class
 */
public class School {
    private final ArrayList <Teacher> teachers;
    private final ArrayList <Student> students;
    private static double totalMoneyEarned;
    private static double totalMoneySpent;

    public School(ArrayList<Teacher> teachers, ArrayList<Student> students){
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }
    /**
     * getters for all instance variables.
     * Pay close attention to how methods with ArrayLists are done.
     * ------------------------------------------------------------------------------
     * The getTeacher and getStudent methods return the list of teachers
     * and students when they are called.
     */
    public ArrayList<Teacher> getTeacher(){
        return teachers;
    }
    public ArrayList<Student> getStudent(){
        return students;
    }
    public double getTotalMoneyEarned(){
        return totalMoneyEarned;
    }

    /**
     *
     * @return Total money spent
     */
    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * setters for all instance variables.
     * In this instance we want to add a teacher to the ArrayList.
     * ------------------------------------------------------------------------------
     * By doing so we need to use the teacher object and NOT the ArrayList<Teacher>
     * of teachers.
     * ------------------------------------------------------------------------------
     * Remember we used the .add() method to add data to an ArrayList.
     * Or it adds a teacher to the school or adds a student to the school.
     */
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public void addStudent(Student student){
        students.add(student);
    }

    /**
     * Adds the money earned by the school
     * @param moneyEarned is the money being added
     * keyword static allows us to use method outside the class
     */
    public static void updateTotalMoneyEarned(double moneyEarned){
        totalMoneyEarned+=moneyEarned;
    }

    /**
     *
     * @param moneySpent Everytime money is spent, then it is added to TotalMoneySpent
     */
    public static void updateTotalMoneySpent(double moneySpent){
        totalMoneySpent += moneySpent;
    }

    public double getSchoolNetBalance(){
        return getTotalMoneyEarned() - getTotalMoneySpent();
    }
}
