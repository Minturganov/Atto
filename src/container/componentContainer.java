package container;

import repo.repoProfile;

import java.util.Scanner;

public class componentContainer {

    public static Scanner stringScanner = new Scanner(System.in);
    public static Scanner intScanner = new Scanner(System.in);
    public static service.serviceProfile profileService = new service.serviceProfile();

    public static repoProfile profileRepo = new repoProfile();

}
