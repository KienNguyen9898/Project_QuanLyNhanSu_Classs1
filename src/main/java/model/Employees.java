package model;

public class Employees {
    private String employee_id;
    private String fullname;
    private Long gender;
    private String date;
    private String hire_date;
    private String email;
    private String phone;
    private String address;
    private String position;
    private int salary;
    private String department_id;
    private String manager_id;

    public Employees() {
    }

    public Employees(String employee_id, String fullname, Long gender, String date, String hire_date, String email, String phone, String address, String position, int salary, String department_id, String manager_id) {
        this.employee_id = employee_id;
        this.fullname = fullname;
        this.gender = gender;
        this.date = date;
        this.hire_date = hire_date;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.position = position;
        this.salary = salary;
        this.department_id = department_id;
        this.manager_id = manager_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "employees{" +
                "employee_id='" + employee_id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", date='" + date + '\'' +
                ", hire_date='" + hire_date + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", department_id='" + department_id + '\'' +
                ", manager_id='" + manager_id + '\'' +
                '}';
    }
}
