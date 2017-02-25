package ru.reeson2003.monster_to_data.exceptions;

/**
 * Created by reeson on 23.02.17.
 */
public class BaseIsEmtyException extends Exception {
    public BaseIsEmtyException() {
        super("Base does not contain any items");
    }
}
