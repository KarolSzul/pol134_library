package org.example.library.view;

import org.example.library.ActiveUser;
import org.example.library.ApplicationContext;
import org.example.library.controller.ViewController;

public class MainMenuView implements View {
    private final ViewController viewController;

    public MainMenuView() {
        this.viewController = new ViewController();
    }

    @Override
    public void display() {
        ActiveUser activeUser = ApplicationContext.getActiveUser();
        viewController.showMenu(activeUser);
    }
}
