package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Validator {

    public static List validate(Address address) {

        List<String> listWithNullFields = new ArrayList<>();

        for (Field field: address.getClass().getDeclaredFields()){
            NotNull notNull = field.getAnnotation(NotNull.class);


            if(notNull != null) {
                Object obj;
                try {
                    field.setAccessible(true);
                    obj=field.get(address);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

                if (obj == null){
                    listWithNullFields.add(field.getName());
                }

            }
        }

        return listWithNullFields;

    }
    public static Map<String, List<String>> advancedValidate(Address address) {

        Map<String, List<String>> map = new HashMap<>();

         Field[] fields = address.getClass().getDeclaredFields();
         for (Field field : fields) {
             MinLength minL = field.getAnnotation(MinLength.class);
             NotNull notNull = field.getAnnotation(NotNull.class);

             List<String> list= new ArrayList<>();

             if(minL != null) {
                 Object obj;
                 field.setAccessible(true);
                 try {
                     obj = field.get(address);
                 } catch (IllegalAccessException e) {
                     throw new RuntimeException(e);
                 }
                 if (obj.toString().length() < minL.minLength()) {
                     list.add(String.format("length less than %s", minL.minLength() ));

                 }



             }
             if(notNull != null) {
                 Object obj;
                 try {
                     field.setAccessible(true);
                     obj=field.get(address);
                 } catch (IllegalAccessException e) {
                     throw new RuntimeException(e);
                 }

                 if (obj == null){
                     list.add("can not be null");
                 }


             }
             map.put(field.getName(), list);
         }
            return map;
        }
}

// END
