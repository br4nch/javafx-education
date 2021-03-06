/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import dialog.FxDialog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Le Tam
 */
public class RegularExpression {

    public static boolean doValidate(String text) {
        Pattern pattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
        Matcher matcher = pattern.matcher(text.toUpperCase());
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
}
