package com.beta.replyservice.common;

public enum TYPE {
    NONE(0),
    REVERSE(1),
    MD5SUM(2);

    private final int value;

    TYPE(int value) {
        this.value = value;
    }

    public static TYPE toValue(String value){
        for(TYPE t: values()){
            if(Integer.parseInt(value)==t.value)
                return t;
        }
        return null;
    }
}
