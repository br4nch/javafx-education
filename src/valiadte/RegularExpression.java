/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valiadte;

import dialog.FxDialog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Le Tam
 */
public class RegularExpression {

    public void doValidate(String text) {
        Pattern pattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
        Matcher matcher = pattern.matcher(text.toUpperCase());
        if (!matcher.matches()) {
            FxDialog.showError("Lỗi", "Email bạn nhập chưa hợp lệ");
        }
    }
}
