package ru.reeson2003.monster_to_data.exceptions;

/**
 * Created by reeson on 23.02.17.
 */
public class IllegalFieldException extends Exception {
    private String field;
    private String value;

    public IllegalFieldException(String field, String value) {
        super("Illegal argument: <" + field +
                "> which value is: <" + value + ">");
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }
}
