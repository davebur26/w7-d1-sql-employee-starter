package example.codeclan.com.employee_starter;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;

import db.SqlRunner;

public class Department {
    private int id;
    private String title;

    public Department(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void save() {
        String sql = String.format("INSERT INTO departments (title) VALUES ('%s');", this.title);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all(){
        String sql = "SELECT * FROM departments;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while( rs.next() ){
                String name = rs.getString("title");
                System.out.println(name);
            }
        } catch (Exception e){
            System.err.println(e.getClass().getName() + "+" + e.getMessage());
            System.exit(0);
        }finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll(){
        String sql = "DELETE FROM departments;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete(){
        String sql = String.format("DELETE FROM departments WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update(){
        String sql = String.format("UPDATE departments SET title = '%s' WHERE id = %d", this.title, this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void findNamesByDepartment(Department departmentToSearch){
        String sql = String.format("SELECT * FROM employees WHERE department_id = %d", departmentToSearch.getId());
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