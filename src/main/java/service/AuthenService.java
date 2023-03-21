package service;

import dao.LoginDAO;
import model.Logins;

public class AuthenService {
    private LoginDAO loginDAO = new LoginDAO();

    // Service ve viec dang nhap

    public boolean login(String userName, String password) {
        Logins logins = loginDAO.getByUserNameAndPassword(userName, password);
        if(logins == null){
            return false;
        }
        // Dang nhap thanh cong
        return true;
    }
}