package com.team6.dva.run;

import com.team6.dva.view.LoginMenu;
import com.team6.dva.view.MainMenu;
import com.team6.dva.model.User;

public class Application {

    public static void main(String[] args) {
        LoginMenu login = new LoginMenu();
        MainMenu mainMenu = new MainMenu();

        User user = new User();
//        mainMenu.showMenu(user);
        User loginUser = login.start();

    }
}
