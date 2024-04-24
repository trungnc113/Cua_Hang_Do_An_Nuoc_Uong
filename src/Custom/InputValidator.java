/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputValidator {

    //kiểm tra rỗng
    public static boolean IsEmpty(String str) {
        if (str.isEmpty() || str.trim().equals("")) {
            return true;
        }
        return false;
    }
    //kiểm tra số điện thoại
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String pattern = "^0\\d{9}$";

        Pattern regex = Pattern.compile(pattern);

        Matcher matcher = regex.matcher(phoneNumber);

        return matcher.matches();
    }
    //kiểm tra số dương
    public static boolean isPositiveNumber(String number){
        String pattern = "\\d+";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(number);
        return matcher.matches();
    }
}
