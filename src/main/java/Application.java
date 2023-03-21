import service.AuthenService;

import java.util.Scanner;

public class Application {

    private static boolean isLoginSuccess = false;

    // Khai bao service
    private static AuthenService authenService = new AuthenService();

    private static void showMenu(){
        System.out.println("---QUAN LY NHAN SU---");
        System.out.println("1. Thêm mới nhân viên");
        System.out.println("2. Cập nhật nhân viên");
        System.out.println("3. Xóa nhân viên");
        System.out.println("4. Thêm mới phòng ban");
        System.out.println("5. Cập nhật phòng ban");
        System.out.println("6. Xóa phòng ban");
        System.out.println("7. Tìm kiếm nhân viên");
        System.out.println("8. Thêm nhân viên vào phòng ban");
        System.out.println("9. Xóa nhân viên khỏi phòng ban");
        System.out.println("10. Chuyển phòng ban cho nhân viên");
        System.out.println("11. Tính thuế thu nhập cá nhân cho nhân viên");
        System.out.println("12. Thoát");


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
        in.close();
    }
}
