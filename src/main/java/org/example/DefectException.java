package org.example;

public class DefectException extends Exception{
    public DefectException() {
        super("Ошибка стадии - брак");
    }
}
