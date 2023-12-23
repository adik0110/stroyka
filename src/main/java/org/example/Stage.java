package org.example;

public abstract class Stage {
    protected String name;
    public Status status;

    public Stage(String name){
        this.name=name;
        status = Status.PLANNED;
    }

    public void upgradeStatus() throws DefectException {

        if(status==Status.COMPLETED){
            System.out.println("Стадия уже выполнена");
        }

        if (status==Status.PROGRESS){
            if((int)(Math.random()*99+1)<10) status=Status.DEFECT;
            else{
                status=Status.COMPLETED;
                System.out.println("Этап выполнен");
            }
        }

        if (status==Status.PLANNED){
            if((int)(Math.random()*99+1)<25) status=Status.DEFECT;
            else{
                status=Status.PROGRESS;
                System.out.println("Этап выполняется");
            }
        }

        if(status==Status.DEFECT){
            throw new DefectException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
