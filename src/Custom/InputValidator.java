/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom;

/**
 *
 * @author nguye
 */
public class InputValidator {

    public static boolean IsEmpty(String str) {
        if (str.isEmpty() || str.trim().equals("")) {
            return true;
        }
        return false;
    }
}
