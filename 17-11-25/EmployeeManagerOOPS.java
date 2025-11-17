class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    double calculateBonus(){
        return 0.10 * salary;
    }

    public void printDetails(){
        System.out.println("Name - " + name);
        System.out.println("Salary - " + salary);
        System.out.println("Bonus - " + calculateBonus());
    }
}

class Manager extends Employee{
    int teamSize;

    public Manager(int teamSize, String name, double salary) {
        super(name, salary);
        this.teamSize = teamSize;
    }
    
    @Override
    double calculateBonus(){
        return 0.20 * salary;
    }
}

public class EmployeeManagerOOPS {
    public static void main(String[] args) {
        Employee[] E = new Employee[2];
        E[0] = new Employee("Harsh", 30000);
        E[1] = new Manager(2, "Rhucha", 50000);
        for(Employee E1 : E){
            E1.printDetails();
        }
    }
}