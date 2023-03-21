package model;

public class Departments {
    private String department_id;
    private String department_name;
    private String department_dese;

    public Departments() {
    }

    public Departments(String department_id, String department_name, String department_dese) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_dese = department_dese;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_dese() {
        return department_dese;
    }

    public void setDepartment_dese(String department_dese) {
        this.department_dese = department_dese;
    }

    @Override
    public String toString() {
        return "departments{" +
                "department_id='" + department_id + '\'' +
                ", department_name='" + department_name + '\'' +
                ", department_dese='" + department_dese + '\'' +
                '}';
    }
}
