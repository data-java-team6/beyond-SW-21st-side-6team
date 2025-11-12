package com.team6.dva.run;

import com.team6.dva.menu.LoginMenu;
import com.team6.dva.menu.MainMenu;
import com.team6.dva.model.User;

public class Application {

    public static void main(String[] args) {
        LoginMenu login = new LoginMenu();
        MainMenu mainMenu = new MainMenu();

//        User loginUser = login.start();
        User user = new User();
        mainMenu.showMenu(user);
    }
}
