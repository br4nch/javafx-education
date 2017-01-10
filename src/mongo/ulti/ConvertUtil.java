/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.ulti;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import model.Course;

/**
 *
 * @author Le Tam
 */
public class ConvertUtil {

    public static Object convertJSONToPojo(String json) {
        Course c = new Course();
        Type type = new TypeToken<Course>() {
        }.getType();

        return new Gson().fromJson(json, type);
    }
}
