package org.itkarasa.loginapp.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by mohsen on 10,June,2020
 */
public class Validators {

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static List<String> isPasswordValid(String passwordHere, String confirmHere) {

        ArrayList<String> errorList = new ArrayList();

        Pattern specialCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");


        if (passwordHere.length() < 6)
            errorList.add("Password length must have at least 6 character !!");

        if (!lowerCasePatten.matcher(passwordHere).find())
            errorList.add("Password must have at least one lowercase character !!");

        if (!UpperCasePatten.matcher(passwordHere).find())
            errorList.add("Password must have at least one uppercase character !!");


        if (!digitCasePatten.matcher(passwordHere).find())
            errorList.add("Password must have at least one digit character !!");

        if (!specialCharPatten.matcher(passwordHere).find())
            errorList.add("Password must have at least one special character !!");

        if (!passwordHere.equals(confirmHere))
            errorList.add("password and confirm password does not match");


        return errorList;

    }
}
