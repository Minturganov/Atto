package controller;

import container.componentContainer;
import dto.dtoProfile;
import util.getAction;


public class menuController {
    public void start() {
        boolean t = true;
        while (t) {
            show();
            switch (getAction.getAction()) {

                case 1 -> login();
                case 2 -> registration();
                case 0 -> t = false;
            }
        }
    }

    private void login() {
        System.out.println("Enter your login: ");
        String login=componentContainer.stringScanner.nextLine();
        System.out.println("Enter your password");
        String password=componentContainer.stringScanner.nextLine();
        componentContainer.profileService.login(login, password);
    }

    private void registration() {

        System.out.println("Enter your name : ");
        String name = componentContainer.stringScanner.next();
        System.out.println("Enter your surname : ");
        String surname = componentContainer.stringScanner.next();
        System.out.println("Enter your phone : ");
        System.out.println("Example: +998901234567");
        String phone = componentContainer.stringScanner.next();
        System.out.println("Enter your login : ");
        String login = componentContainer.stringScanner.next();
        System.out.println("Enter your password : ");
        String password1 = componentContainer.stringScanner.next();
        System.out.println("Repeat the password : ");
        String password2 = componentContainer.stringScanner.next();

        if (componentContainer.profileService.password(password1, password2)) {
            dto.dtoProfile dtoProfile = new dtoProfile();
            dtoProfile.setName(name);
            dtoProfile.setSurname(surname);
            dtoProfile.setPhone(phone);
            dtoProfile.setLogin(login);
            dtoProfile.setPassword(password1);
            componentContainer.profileService.registr(dtoProfile);
        } else {
            System.err.println("!!! password error !!!");
            System.out.println("*****  TRY AGAIN  *****");
        }
    }

    public void show() {
        System.out.println("**MENU**");
        System.out.println("1. Login.");
        System.out.println("2. Registration.");
        System.out.println("0. Exit.");

    }
}
