package student.management.system;

public class Student {
    //Instance Variables
    private int id;
    private String name;
    private int grade;
    private double feesPaid;
    private double feeTotal;

    /**
     * The constructor allows you to set an ID, name and grade.
     * It automatically sets feePaid to 0 and feeTotal to 50,000.
     * We would need to create a setter method to updateFeesPaid.
     */
    public Student(int id, String name, int grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.feeTotal= 50000;
    }

    /**
     * Setter method for setting feesPaid.
     * We take in a fee as the parameter then keep adding it to the existing feesPaid.
     * We also need a setter method to change grade
     */
    public void payFees(double fee){
        feesPaid+=fee;
        School.updateTotalMoneyEarned(fee);
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    /**
     * Getter methods
     */
    public int getStudentId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getGrade(){
        return grade;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getFeeTotal() {
        return feeTotal;
    }

    public double getRemainingFees(){
        return feeTotal - feesPaid;
    }
}
