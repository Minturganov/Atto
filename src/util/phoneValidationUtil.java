package util;

public class phoneValidationUtil {
    public static boolean isValidPhone(String phone) {
        if (!phone.startsWith("+998") && phone.length() != 13) return false;
        return phone.substring(2).chars().allMatch(Character::isDigit);
    }
}
