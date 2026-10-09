package com.hibernate.javaSpringHibernate.entityConvertor;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConvertor implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean ? "yes" : "no";
//        if(aBoolean == true) {
//            return "yes";
//        }
//        return "no";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        return s.equals("yes");
//        return (s == "yes") ? true : false;
//        if(s == "yes") {
//            return true;
//        }
//        return false;
    }
}
