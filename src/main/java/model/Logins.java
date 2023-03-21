package model;

public class Logins {
    private long account_id;
    private String username;
    private String password;

    public Logins() {
    }

    public Logins(long account_id, String username, String password) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "logins{" +
                "account_id=" + account_id +
                ", username='" + username + '\'' +
                '}';
    }
}
