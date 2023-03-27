package dao;

import connection.MyConnection;
import model.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    //in ra
    public List<Employees> getAll() {

        final String sql = "SELECT * FROM `employees`";

        List<Employees> employeesList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employees e = new Employees();
                e.setEmployee_id(rs.getString("employee_id"));
                e.setFullname(rs.getString("fullname"));
                e.setGender(rs.getLong("gender"));
                e.setDate(rs.getString("date"));
                e.setHire_date(rs.getString("hire_date"));
                e.setEmail(rs.getString("email"));
                e.setPhone(rs.getString("phone"));
                e.setAddress(rs.getString("address"));
                e.setPosition(rs.getString("position"));
                e.setSalary(rs.getInt("salary"));
                e.setDepartment_id(rs.getString("department_id"));
                e.setManager_id(rs.getString("manager_id"));
                employeesList.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeesList;
    }

    // tim theo id
    public Employees getById(String employee_id) {
        final String sql = "SELECT * FROM `employees` WHERE  `employee_id` = '" + employee_id + "'";
        Employees e = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                e = new Employees();
                e.setEmployee_id(rs.getString("employee_id"));
                e.setFullname(rs.getString("fullname"));
                e.setGender(rs.getLong("gender"));
                e.setDate(rs.getString("date"));
                e.setHire_date(rs.getString("hire_date"));
                e.setEmail(rs.getString("email"));
                e.setPhone(rs.getString("phone"));
                e.setAddress(rs.getString("address"));
                e.setPosition(rs.getString("position"));
                e.setSalary(rs.getInt("salary"));
                e.setDepartment_id(rs.getString("department_id"));
                e.setManager_id(rs.getString("manager_id"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    //tim theo ten
    public List<Employees> filterEmployee(String keyword) {
        Connection connection = null;
        try {

            List<Employees> e = new ArrayList<>();
            connection = MyConnection.getConnection();
            String sql = "SELECT * FROM employees WHERE `employee_id` LIKE ? OR `fullname` LIKE ? OR `phone` LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            preparedStatement.setString(3, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employees employees = new Employees();
                employees.setEmployee_id(rs.getString("employee_id"));
                employees.setFullname(rs.getString("fullname"));
                employees.setGender(rs.getLong("gender"));
                employees.setDate(rs.getString("date"));
                employees.setHire_date(rs.getString("hire_date"));
                employees.setEmail(rs.getString("email"));
                employees.setPhone(rs.getString("phone"));
                employees.setAddress(rs.getString("address"));
                employees.setPosition(rs.getString("position"));
                employees.setSalary(rs.getInt("salary"));
                employees.setDepartment_id(rs.getString("department_id"));
                employees.setManager_id(rs.getString("manager_id"));
                e.add(employees);
            }
            return e;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }



    //them nv
    public void insert(Employees e) {
        final String sql = String.format("INSERT  INTO `employees` VALUES ( '%s','%s','%d','%s','%s','%s','%s','%s','%s','%d','%s','%s' ) ",
                e.getEmployee_id(), e.getFullname(), e.getGender(), e.getDate(), e.getHire_date(), e.getEmail(), e.getPhone(), e.getAddress(),
                e.getPosition(), e.getSalary(), e.getDepartment_id(), e.getManager_id()
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //sua
    public void update(Employees employees, String employee_id) {
        Employees tmp = getById(employee_id);
        if (tmp == null) {
            throw new RuntimeException("Nhân viên không tồn tại!");
        }

        final String sql = String.format("UPDATE `employees` SET `fullname`='%s',`gender`='%d',`date`='%s',`hire_date`='%s',`email`='%s', `phone`='%s', `address`='%s', `position`='%s',`salary`='%d' WHERE `employee_id` = '%s'",
                employees.getFullname(), employees.getGender(), employees.getDate(), employees.getHire_date(), employees.getEmail(), employees.getPhone(), employees.getAddress(),
                employees.getPosition(), employees.getSalary(), employee_id
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //xoa
    public void delete(String employee_id) {
        Employees employees = getById(employee_id);
        if (employees == null) {
            throw new RuntimeException("Nhân viên không tồn tại!");
        }

        final String sql = "DELETE FROM `employees` WHERE  `employee_id` = '" + employee_id +"'";
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //thue
    public void update_employee_department(Employees e, String employee_id) {
        Employees tmp = getById(employee_id);
        if(tmp == null){
            System.out.println("Không tồn tại nhân viên có id = " + employee_id);
            return;
        }
        final String sql = String.format("UPDATE employees SET `department_id`='%s' WHERE `employee_id`='%s' " ,
                e.getDepartment_id(), employee_id
        );

        System.out.println(sql);
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    //thue


    }
