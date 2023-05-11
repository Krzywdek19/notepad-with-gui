package com.example.gui;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.stage.Stage;

import java.io.*;
import java.security.Provider;

public class UserLoginService {
    private String fileName = "accounts";
    private Boolean isLogged = false;


    private boolean registrationScene = true;

    private String username = "";

    public Boolean isLogged() {
        return isLogged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isRegistrationScene() {
        return registrationScene;
    }

    public void setRegistrationScene(boolean registrationScene) {
        this.registrationScene = registrationScene;
    }

    public UserLoginService() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Wystąpił problem podczas tworzenia pliku");
            }
        }
    }

    public boolean handleAuthorization(String login, String password){
        if(this.registrationScene){
            this.createAccount(login,password);
            return false;
        }else {
            return this.login(login, password);
        }
    }

    public void createAccount(String login, String password) {
        if (this.loginIsFree(login)) {
            if (login != null && login.length() > 4) {
                try {
                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName, true)));
                    writer.println(login + "|" + password);
                    System.out.println("dziala");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Wystąpił problem podczas zapisywania danych do pliku");
                }
            }
        }
    }

    public boolean login(String login, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
            while (reader.ready()) {
                String[] loginData = reader.readLine().split("\\|");
                if (loginData[0].equals(login)) {
                    if (loginData[1].equals(password)) {
                        this.isLogged = true;
                        this.setUsername(login);
                        return true;
                    } else {
                        System.out.println("Podane hasło jest nieprawidłowe");
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Wystąpił problem podczas odczytywania danych z pliku");
            return false;
        }
        System.out.println("Podany login jest nieprawidłowy");
        return false;
    }

    public boolean loginIsFree(String login) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
            while (reader.ready()) {
                String[] loginData = reader.readLine().split("\\|");
                if (loginData[0].equals(login)) {
                    return false;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("There was a problem while reading data from file");
            return false;
        }
        return true;
    }
}
