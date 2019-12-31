//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.service.excel;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FieldUtil {
    public FieldUtil() {
    }

    public static String[] getFields(Class<?> clazz) {
        Field[] selfFields = clazz.getDeclaredFields();
        int length = selfFields.length;
        String[] fields = new String[length];

        for(int i = 0; i < length; ++i) {
            fields[i] = selfFields[i].getName();
        }

        return fields;
    }

    public static Field getFieldByName(String fieldName, Class<?> clazz) {
        Field[] selfFields = clazz.getDeclaredFields();
        Field[] var3 = selfFields;
        int var4 = selfFields.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Field field = var3[var5];
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            return getFieldByName(fieldName, superClazz);
        } else {
            return null;
        }
    }

    public static void setFieldValueByName(String fieldName, Object fieldValue, Object o, String dateformat) throws Exception {
        Field field = getFieldByName(fieldName, o.getClass());
        if (dateformat == null || dateformat.trim().equals("")) {
            dateformat = "EEE MMM dd HH:mm:ss ZZZ yyyy";
        }

        if (fieldValue != null && !fieldValue.toString().trim().equals("")) {
            if (field == null) {
                throw new ExcelException(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
            } else {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                if (String.class == fieldType) {
                    field.set(o, String.valueOf(fieldValue));
                } else if (Integer.TYPE != fieldType && Integer.class != fieldType) {
                    if (Long.TYPE != fieldType && Long.class != fieldType) {
                        if (Float.TYPE != fieldType && Float.class != fieldType) {
                            if (Short.TYPE != fieldType && Short.class != fieldType) {
                                if (Double.TYPE != fieldType && Double.class != fieldType) {
                                    if (Character.TYPE == fieldType) {
                                        if (fieldValue != null && fieldValue.toString().length() > 0) {
                                            field.set(o, fieldValue.toString().charAt(0));
                                        }
                                    } else if (Date.class == fieldType) {
                                        field.set(o, (new SimpleDateFormat(dateformat, Locale.UK)).parse(fieldValue.toString()));
                                    } else {
                                        field.set(o, fieldValue);
                                    }
                                } else {
                                    field.set(o, Double.valueOf(fieldValue.toString()));
                                }
                            } else {
                                field.set(o, Short.valueOf(fieldValue.toString()));
                            }
                        } else {
                            field.set(o, Float.valueOf(fieldValue.toString()));
                        }
                    } else {
                        field.set(o, Long.valueOf(fieldValue.toString()));
                    }
                } else {
                    field.set(o, Integer.parseInt(fieldValue.toString()));
                }

            }
        }
    }

    public static Object getFieldValueByName(String fieldName, Object o) throws Exception {
        Object value = null;
        Field field = getFieldByName(fieldName, o.getClass());
        if (field != null) {
            field.setAccessible(true);
            value = field.get(o);
            return value;
        } else {
            throw new ExcelException(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
        }
    }
}
