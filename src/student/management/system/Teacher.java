package student.management.system;

public class Teacher {
    //Instance Variables
    private int id;
    private String name;
    private double salary;
    private int salaryEarned;

    /**
     * Creates a new Teacher object.
     * The salary of the teacher isn't fixed
     * so we don't set a value to it like we did for feeTotal in Student class.
     */
    public Teacher(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
    }
    /**
     * We need to set getters for id, name and salary.
     * We need a setter for salary since we need to assign
     * a specific salary for different teachers.
     */
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getTeacherSalary() {
        return salary;
    }

    /**
     *
     * @param salary Setter which allows us to set a salary
     */
    public void setSalary(double salary){
        this.salary = salary;
    }

    /**
     * Adds to salaryEarned
     * Deducts from the total money earned by school
     * @param salary
     */
    public void recievedSalary(double salary){
        salaryEarned+=salary;
        School.updateTotalMoneySpent(salary);
    }
}
