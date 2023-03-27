import dao.DepartmentDAO;
import dao.EmployeeDAO;
import model.Departments;
import model.Employees;
import service.AuthenService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static boolean isLoginSuccess = false;

    // Khai bao service
    private static AuthenService authenService = new AuthenService();
    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private static DepartmentDAO departmentDAO = new DepartmentDAO();

    private static void showMenu() {
        System.out.println("---QUAN LY NHAN SU---");
        System.out.println("1. Xem danh sách nhân viên");
        System.out.println("2. Thêm mới nhân viên");
        System.out.println("3. Cập nhật nhân viên");
        System.out.println("4. Xóa nhân viên");
        System.out.println("5. Xem danh sách phòng ban");
        System.out.println("6. Thêm mới phòng ban");
        System.out.println("7. Cập nhật phòng ban");
        System.out.println("8. Xóa phòng ban");
        System.out.println("9. Tìm kiếm nhân viên");
        System.out.println("10. Chuyển phòng ban cho nhân viên");
        System.out.println("11. Tính thuế thu nhập cá nhân cho nhân viên");
        System.out.println("0. Thoát");
    }

        private static void option1() {
            List<Employees> employeesList = employeeDAO.getAll();
            System.out.printf("%-10s %-25s %-25s %-25s %-25s %-25s %-25s","STT", "Mã nhân viên", "Họ tên", "Giới tính", "Số điện thoại", "Vị trí", "Mã phòng ban");
            System.out.println();
            for (int i = 0; i < employeesList.size(); i++) {
                Employees e = employeesList.get(i);
                System.out.printf("%-10s %-25s %-25s %-25s %-25s %-25s %-25s\n",(i+1), e.getEmployee_id(), e.getFullname(),
                        e.getGender(), e.getPhone(), e.getPosition(), e.getDepartment_id());
            }
        }

        private static void option2(Scanner in){
            Employees e = new Employees();
            System.out.print("\tNhập id nhân viên: ");
            e.setEmployee_id(in.nextLine());
            System.out.print("\tNhập họ tên: ");
            e.setFullname(in.nextLine());
            System.out.print("\tNhập giới tính: ");
            e.setGender(Long.parseLong(in.nextLine()));
            System.out.print("\tNhập ngày sinh: ");
            e.setDate(in.nextLine());
            System.out.println("\tNhập ngày bắt đầu làm việc: ");
            e.setHire_date(in.nextLine());
            System.out.println("\tNhập ngày email: ");
            e.setEmail(in.nextLine());
            System.out.println("\tNhập số điện thoại: ");
            e.setPhone(in.nextLine());
            System.out.println("\tNhập địa chỉ: ");
            e.setAddress(in.nextLine());
            System.out.println("\tNhập vị trí công việc: ");
            e.setPosition(in.nextLine());
            System.out.println("\tNhập lương: ");
            e.setSalary(Integer.parseInt(in.nextLine()));
            System.out.println("\tNhập id phòng ban: ");
            e.setDepartment_id(in.nextLine());
            System.out.println("\tNhập id quản lý: ");
            e.setManager_id(in.nextLine());
            employeeDAO.insert(e);
        }
    private static void option3(Scanner in){
        Employees e = new Employees();
        System.out.print("Nhập id nhân viên cần cập nhật: ");
        String employee_id = in.nextLine();
        System.out.print("\tNhập họ tên: ");
        e.setFullname(in.nextLine());
        System.out.print("\tNhập giới tính: ");
        e.setGender(Long.parseLong(in.nextLine()));
        System.out.print("\tNhập ngày sinh: ");
        e.setDate(in.nextLine());
        System.out.println("\tNhập ngày bắt đầu làm việc: ");
        e.setHire_date(in.nextLine());
        System.out.println("\tNhập ngày email: ");
        e.setEmail(in.nextLine());
        System.out.println("\tNhập số điện thoại: ");
        e.setPhone(in.nextLine());
        System.out.println("\tNhập địa chỉ: ");
        e.setAddress(in.nextLine());
        System.out.println("\tNhập vị trí công việc: ");
        e.setPosition(in.nextLine());
        System.out.println("\tNhập lương: ");
        e.setSalary(Integer.parseInt(in.nextLine()));
        System.out.println("\tNhập id phòng ban: ");
        e.setDepartment_id(in.nextLine());
        System.out.println("\tNhập id quản lý: ");
        e.setManager_id(in.nextLine());
        employeeDAO.update(e, employee_id);

    }
    private static void option4(Scanner in){
        System.out.print("\tNhập id nhân viên muốn xóa: ");
        String employee_id =in.nextLine();
        employeeDAO.delete(employee_id);
    }

    private static void option5() {
        List<Departments> departmentsList = departmentDAO.getAll();
        System.out.printf("%-25s %-25s %-25s %-25s","STT", "Mã phòng ban", "Tên phòng ban", "Thông tin phòng ban");
        System.out.println();
        for (int i = 0; i < departmentsList.size(); i++) {
            Departments d = departmentsList.get(i);
            System.out.printf("%-25s %-25s %-25s %-25s \n", (i+1), d.getDepartment_id(), d.getDepartment_name(), d.getDepartment_dese());
        }
    }

    private static void option6(Scanner in){
        Departments d = new Departments();
        System.out.print("\tNhập id phòng ban: ");
        d.setDepartment_id(in.nextLine());
        System.out.print("\tNhập tên phòng ban: ");
        d.setDepartment_name(in.nextLine());
        System.out.print("\tNhập thông tin phòng ban: ");
        d.setDepartment_dese(in.nextLine());
        departmentDAO.insert(d);
    }

    private static void option7(Scanner in){
        Departments d = new Departments();
        System.out.print("Nhập id phòng ban cần cập nhật: ");
        String department_id = in.nextLine();
        System.out.print("\tNhập tên phòng ban: ");
        d.setDepartment_name(in.nextLine());
        System.out.print("\tNhập thông tin phòng ban: ");
        d.setDepartment_dese(in.nextLine());
        departmentDAO.update(d, department_id);
    }

    private static void option8(Scanner in){
            System.out.print("\tNhập id phòng ban muốn xóa: ");
            String department_id = in.nextLine();
            departmentDAO.delete(department_id);
    }

    private static void option9(Scanner in){
        System.out.print("\tNhập Id, Tên, Số điện thoại muốn tìm kiếm: ");
        String fullname = in.nextLine();
        System.out.println(employeeDAO.filterEmployee(fullname));
    }

    private static void  option10(Scanner in){
        Employees e=new Employees();
        System.out.print("\tNhập mã nhân viên: ");
        String employee_id=in.nextLine();
        while(employeeDAO.getById(employee_id)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            employee_id =in.nextLine();
        }
        e.setEmployee_id(employee_id);

        System.out.println("Chọn phòng ban: ");
        List<Departments> departmentsList = departmentDAO.getAll();
        System.out.printf("\t\t%-20s %-20s %-20s\n","STT", "Mã phòng ban","Tên phòng ban");
        for (int i = 0; i < departmentsList.size(); i++) {
            Departments d = departmentsList.get(i);
            System.out.printf("\t\t%-20d %-20s %-20s \n",(i+1), d.getDepartment_id(), d.getDepartment_name());
        }
        System.out.println("\tNhập mã phòng ban: ");
        String department_id=in.nextLine();
        while (departmentDAO.getById(department_id)==null){
            System.out.println("Mã phòng ban không hợp lệ, vui lòng nhập lại mã phòng ban: ");
            department_id=in.nextLine();
        }
        e.setDepartment_id(department_id);

        employeeDAO.update_employee_department(e,employee_id);
    }

    public static void option11(Scanner in){
        Employees e=new Employees();
        System.out.print("\tNhập mã nhân viên: ");
        String employee_id=in.nextLine();
        while(employeeDAO.getById(employee_id)==null) {
            System.out.print("\tMã nhân viên chưa tồn tại, vui lòng nhập lại mã NV: ");
            employee_id =in.nextLine();
        }
        e.setEmployee_id(employee_id);
        String leftAlignFormat = " %-12s  %-25s  %-2s %n";
        System.out.format(" Mã nhân viên  Tên nhân viên              Lương%n");
        Employees employee = employeeDAO.getById(employee_id);
        System.out.format(leftAlignFormat, employee.getEmployee_id(),
                employee.getFullname(),employeeDAO.getById(employee_id).getSalary());

        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.print("\tNhập số người phụ thuộc: ");
        int soNguoiPT = in.nextInt();

        //Mức đóng: BHXH (8%), BHYT (1.5%), BHTN (1%)
        //Bảo hiểm bắt buộc = luongBh x 8% + luongBh x 1.5% + luongBh x 1%
        double BHBB = (employee.getSalary() * 0.08) + (employee.getSalary() * 0.015) + (employee.getSalary() * 0.01);
        System.out.println("\t-Bảo hiểm bắt buộc = "+formatter.format(BHBB)+" VNĐ");

        // giảm trừ bản thân : 11000000
        int GTBT = 11000000;
        System.out.println("\t-Giảm trừ bản thân = "+formatter.format(GTBT)+" VNĐ");

        //Giảm trừ người phụ thuộc = soNguoiPT x 4,400,000 = mặc định
        int GTNPT = soNguoiPT * 4400000;
        System.out.println("\t-Giảm trừ người phụ thuộc = "+formatter.format(GTNPT)+" VNĐ");

        //Thu nhập tính thuế = lương - BHBB - GTBT - GTNPT;
        double luong = employeeDAO.getById(employee_id).getSalary();
        double TNTT = luong - BHBB - GTBT - GTNPT;
        System.out.println("\t-Thu nhập tính thuế = "+formatter.format(TNTT)+" VNĐ");

        // Thuế thu nhập cá nhân phải nộp
        double TTNCN;
        if (luong <= 5000000 ){
            TTNCN = TNTT * 0.05;
        }else if (luong <= 10000000){
            TTNCN = (TNTT * 0.1) - 0.25;
        }else if (luong <= 18000000){
            TTNCN = (TNTT * 0.15) - 0.75;
        }else if (luong <= 32000000){
            TTNCN = (TNTT * 0.2) - 1.65;
        }else if (luong <= 52000000){
            TTNCN = (TNTT * 0.25) - 3.25;
        }else if (luong <= 80000000){
            TTNCN = (TNTT * 0.3) - 5.85;
        }else {
            TTNCN = (TNTT * 0.35) - 9.85;
        }
        if (luong > 0){
            System.out.println("\t-Thuế thu nhập cá nhân phải nộp = "+formatter.format(TTNCN)+" VNĐ");
        }else {
            System.out.println("\t-Thuế thu nhập cá nhân phải nộp = 0 VNĐ");
        }

    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" --- LOGIN--- ");
        int count = 3;
        while (count != 0){
            count = count -1;
            System.out.print("Nhập username: ");
            String username = in.nextLine();
            System.out.print("Nhập password: ");
            String password = in.nextLine();
            // verify
            isLoginSuccess = authenService.login(username, password);
            if(isLoginSuccess == true) {
                break;
            }
            if(count==0){
                continue;
            }else {
                System.out.printf("\tSai tài khoản hoặc mật khẩu. \n\tBạn còn %d lần đăng nhập \n ", count);
            }
        }
        if(isLoginSuccess == false){
            System.out.println("\tĐăng nhập thất bại.");
            System.exit(0);
        }
        else {
            System.out.println("\tĐăng nhập thành công");
        }

        // Dang nhap thanh cong
        showMenu();
        int option = -1;

        do {
            showMenu();
            System.out.print("Nhập lựa chọn: ");
            try {
                option = Integer.parseInt(in.nextLine());

            } catch (Exception exception) {
                System.out.println("Nhap sai dinh dang");
                continue;

            }
            if (option < 1 || option > 13) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    option3(in);
                    break;
                case 4:
                    option4(in);
                    break;
                case 5:
                    option5();
                    break;
                case 6:
                    option6(in);
                    break;
                case 7:
                    option7(in);
                    break;
                case 8:
                    option8(in);
                    break;
                case 9:
                    option9(in);
                    break;
                case 10:
                    option10(in);
                    break;
                case 11:
                    option11(in);

                    break;
                case 12:

                    break;
                case 13:

                    break;
            }

        }
        while (option != 0);
        in.close();

    }

}
