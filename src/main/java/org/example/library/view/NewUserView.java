package org.example.library.view;

import org.apache.commons.validator.routines.EmailValidator;
import org.example.library.api.NewUserData;
import org.example.library.controller.NewUserController;
import org.example.library.dao.RoleDao;
import org.example.library.dao.UserDao;
import org.example.library.service.UserService;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewUserView implements View {

    private final Scanner scanner;
    private Optional<String> message;
    private UserService userService;
    private NewUserController newUserController;


    public NewUserView() {
        this.scanner = new Scanner(System.in);
        this.userService = new UserService(new UserDao());
    }

    public NewUserView(Optional<String> message) {
        this.scanner = new Scanner(System.in);
        this.message = message;
        this.userService = new UserService(new UserDao());
        this.newUserController = new NewUserController();
    }

    @Override
    public void display() {
        NewUserData newUserData = new NewUserData();
        newUserData.setLogin(getAndVerifyLogin());
        newUserData.setEmail(getAndVerifyEmail());
        System.out.println("podaj imie");
        newUserData.setName(scanner.nextLine());
        System.out.println("podaj haslo");
        newUserData.setPassword(scanner.nextLine());
        System.out.println("--------------------");
        System.out.println("podaj adres");
        newUserData.setPostalCode(getAndVerifyPostalCode());
        System.out.println("podaj miasto");
        newUserData.setCity(scanner.nextLine());
        System.out.println("podaj nazwe ulicy");
        newUserData.setStreet(scanner.nextLine());
        System.out.println("podaj numer domu");
        newUserData.setBuildingNo(scanner.nextLine());
        System.out.println("podaj numer mieszkania");
        newUserData.setApartmentNo(scanner.nextLine());
        newUserController.addNewUser(newUserData).display();
    }

    public String getAndVerifyLogin() {
        message.ifPresent(System.out::println);
        System.out.println("podaj login");
        String login = scanner.nextLine();
        if (isLoginPresent(login)) {
            System.out.println("Login juz istnieje!");
            getAndVerifyLogin();
        }
        return login;
    }

    public String getAndVerifyEmail() {
        message.ifPresent(System.out::println);
        System.out.println("podaj e-mail");
        String email = scanner.nextLine();
        if (!isEmailFormatCorrect(email)) {
            System.out.println("Zly format e-mail!");
            getAndVerifyEmail();
        }
        return email;
    }

    public String getAndVerifyPostalCode() {
        message.ifPresent(System.out::println);
        System.out.println("podaj kod-pocztowy");
        String postalCode = scanner.nextLine();
        if (!isPostalCodeFormatCorrect(postalCode)) {
            System.out.println("Zly format kodu pocztowego!");
            getAndVerifyPostalCode();
        }
        return postalCode;
    }

    public boolean isLoginPresent(String login) {
        return userService.checkLoginExisting(login);
    }

    public boolean isEmailFormatCorrect(String emial) {
        return EmailValidator.getInstance().isValid(emial);
    }

    public boolean isPostalCodeFormatCorrect(String postalCode) {
        Pattern pattern = Pattern.compile("[0-9]{2}-[0-9]{3}");
        Matcher matcher = pattern.matcher(postalCode);
        return matcher.matches();
    }
}
