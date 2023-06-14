package service;

import attoEnum.enumProfile;
import attoEnum.enumRole;
import container.componentContainer;
import dto.dtoProfile;
import util.phoneValidationUtil;

import java.time.LocalDateTime;

public class serviceProfile {

    public boolean password(String one, String two) {
        return (one.equals(two));
    }

    public void registr(dtoProfile dtoProfile) {
        String phone = dtoProfile.getPhone();
        //validate phone
        if (!phoneValidationUtil.isValidPhone(phone)){
            System.err.println("PHONE INPUT ERROR");
        }
        //check phone unique
        dtoProfile existProfile = componentContainer.profileRepo.getProfileByPhone(dtoProfile.getPhone());
        if (existProfile != null){
            System.out.println("This phone is already registered");
            return;
        }
        // set detail
        dtoProfile.setCreated_date(LocalDateTime.now());
        dtoProfile.setRole(enumRole.USER);
        dtoProfile.setStatus(enumProfile.ACTIVE);
        //save
        boolean result =componentContainer.profileRepo.addProfile(dtoProfile);
        if (result) {
            System.out.println("you have successfully registered");
            System.out.println("Login to your account!");
        } else {
            System.out.println("Something went wrong");
        }
    }

    public void login(String login, String password) {





    }
}
