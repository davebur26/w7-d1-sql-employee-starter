package example.codeclan.com.employee_starter;

/**
 * Created by user on 22/02/2017.
 */

public class Runner {
    public static void main(String[] args){
        Department department1 = new Department("HR");
        Department department2 = new Department("Marketing");
        Department department3 = new Department("Sales");
        Department department4 = new Department("Finance");
        Department department5 = new Department("Admin");

        Department.deleteAll();
        department1.save();
        department2.save();
        department3.save();
        department4.save();
        department5.save();

        Employee employee1 = new Employee("Suzie Smith", 45000, department1);
        Employee employee2 = new Employee("Jamie Jones", 25000, department1);
        Employee employee3 = new Employee("Paul Smith", 34000, department2);
        Employee employee4 = new Employee("Clare May", 38990, department2);
        Employee employee5 = new Employee("Terry Jones", 23000, department3);
        Employee employee6 = new Employee("Bruce Willis", 98000, department3);
        Employee employee7 = new Employee("Terresa May", 12000, department4);
        Employee employee8 = new Employee("Jamie Murray", 32090, department4);
        Employee employee9 = new Employee("Sue Barker", 21500, department5);
        Employee employee10 = new Employee("Jonathon Ross", 56000, department5);

        Employee.deleteAll();
        employee1.save();
        employee2.save();
        employee3.save();
        employee4.save();
        employee5.save();
        employee6.save();
        employee7.save();
        employee8.save();
        employee9.save();
        employee10.save();

        Employee.findName("Suzie Smith");
        Department.findNamesByDepartment(department1);
    }
}
