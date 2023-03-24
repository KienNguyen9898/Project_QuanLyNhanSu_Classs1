import dao.DepartmentDAO;
import dao.EmployeeDAO;
import model.Departments;
import model.Employees;
import service.AuthenService;

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
        System.out.println("10. Thêm nhân viên vào phòng ban");
        System.out.println("11. Xóa nhân viên khỏi phòng ban");
        System.out.println("12. Chuyển phòng ban cho nhân viên");
        System.out.println("13. Tính thuế thu nhập cá nhân cho nhân viên");
        System.out.println("0. Thoát");
    }

        private static void option1() {
            List<Employees> employeesList = employeeDAO.getAll();
            System.out.printf("%-10s %-25s %-25s %-25s %-25s %-25s %-25s %-25s","STT", "Mã nhân viên", "Họ tên", "Giới tính", "Số điện thoại", "Vị trí", "Mã phòng ban", "Mã người quản lý");
            System.out.println();
            for (int i = 0; i < employeesList.size(); i++) {
                Employees e = employeesList.get(i);
                System.out.printf("%-10s %-25s %-25s %-25s %-25s %-25s %-25s %-25s\n",(i+1), e.getEmployee_id(), e.getFullname(),
                        e.getGender(), e.getPhone(), e.getPosition(), e.getDepartment_id(), e.getManager_id());
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

                    break;
                case 10:

                    break;
                case 11:

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
