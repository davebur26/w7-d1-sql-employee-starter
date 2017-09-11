package example.codeclan.com.employee_starter;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;

import db.SqlRunner;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;

    public Employee(String name, double salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void save() {
        String sql = String.format("INSERT INTO employees (name, salary, department_id) VALUES ('%s', %7.2f, %d);",this.name, this.salary,this.department.getId());
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all(){
        String sql = "SELECT * FROM employees;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while (rs.next()) {
                String name = rs.getString("name");
                Double salary = rs.getDouble("Salary");
                int department_id = rs.getInt("department_id");
                System.out.println(name);
                System.out.println(salary);
                System.out.println(department_id);
            }
        }catch( Exception e){
            System.err.println(e.getClass().getName() + " + " + e.getMessage());
            System.exit(0);
        }finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll(){
        String sql = "DELETE FROM employees;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete() {
        String sql = String.format("DELETE FROM employees WHERE id = %d", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update(){
        String sql = String.format("UPDATE employees SET name = '%s', salary = %7.2f, department_id = %d WHERE id = %d", this.name, this.salary, this.department.getId(), this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void findName(String nameToFind){
        String sql = String.format("SELECT * FROM employees WHERE name = '%s'", nameToFind);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while (rs.next()) {
                String name = rs.getString("name");
                Double salary = rs.getDouble("Salary");
                int department_id = rs.getInt("department_id");
                System.out.println(name);
                System.out.println(salary);
                System.out.println(department_id);
            }
        }catch( Exception e){
            System.err.println(e.getClass().getName() + " + " + e.getMessage());
            System.exit(0);
        }finally {
            SqlRunner.closeConnection();
        }
    }


}
