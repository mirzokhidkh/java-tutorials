package com.mk.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtil {

    public static Map<String, Object> getCustomFieldNamesAndValues(Object object) {
        Map<String, Object> fieldMap = new HashMap<>();
        if (object == null) {
            return fieldMap;
        }

        Class<?> clazz = object.getClass();
        
        // Get declared fields only from the current class
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // To access private fields
            try {
                fieldMap.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Handle exception appropriately
            }
        }

        return fieldMap;
    }
}
