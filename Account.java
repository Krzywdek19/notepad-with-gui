package com.example.gui;

public class Account {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if((Account) obj == this){
            return true;
        }
        return this.password.equals(((Account) obj).getPassword()) && this.login.equals(((Account) obj).getLogin());
    }
}
