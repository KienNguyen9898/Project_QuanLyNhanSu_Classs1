package dao;

import connection.MyConnection;
import model.Departments;
import model.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    //in ra
    public List<Departments> getAll(){
        final String sql = "SELECT * FROM `departments`";
        List<Departments> departmentsList = new ArrayList<>();
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Departments d = new Departments();
                d.setDepartment_id(rs.getString("department_id"));
                d.setDepartment_name(rs.getString("department_name"));
                d.setDepartment_dese(rs.getString("department_dese"));
                departmentsList.add(d);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return departmentsList;
    }

    //tim id
    public Departments getById(String department_id) {
        final String sql = "SELECT * FROM `departments` WHERE  `department_id` = '" + department_id + "'";
        Departments d = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                d = new Departments();
                d.setDepartment_id(rs.getString("department_id"));
                d.setDepartment_name(rs.getString("department_name"));
                d.setDepartment_dese(rs.getString("department_dese"));

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return d;
    }

    //them
    public void insert(Departments d) {
        final String sql = String.format("INSERT  INTO `departments` VALUES ( '%s','%s','%s' ) ",
                d.getDepartment_id(), d.getDepartment_name(), d.getDepartment_dese()
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

    //Cap nhat
    public void update(Departments departments, String department_id) {
        Departments tmp = getById(department_id);
        if (tmp == null) {
            throw new RuntimeException("Nhân viên không tồn tại!");
        }

        final String sql = String.format("UPDATE `departments` SET `department_name`='%s',`department_dese`='%s' WHERE `department_id` = '%s'",
                departments.getDepartment_name(), departments.getDepartment_dese(), department_id
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

    //Xóa
    public void delete(String department_id) {
        Departments departments = getById(department_id);
        if (departments == null) {
            throw new RuntimeException("Phòng ban không tồn tại!");
        }

        final String sql = "DELETE FROM `departments` WHERE  `department_id` = '" + department_id +"'";
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
    public List<Departments> filterDepartment(String keyword) {
        Connection connection = null;
        try {

            List<Departments> d = new ArrayList<>();
            connection = MyConnection.getConnection();
            String sql = "SELECT * FROM departments WHERE `department_id` LIKE ? OR `department_name` LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Departments departments = new Departments();
                departments.setDepartment_id(rs.getString("department_id"));
                departments.setDepartment_name(rs.getString("department_name"));
                departments.setDepartment_dese(rs.getString("department_dese"));
                d.add(departments);
            }
            return d;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
