package org.example;

public class Main {
    public static void main(String[] args) {
        Building myBuild = new Building();
        myBuild.start();
        System.out.println(myBuild.next().status);
        System.out.println(myBuild.next().status);
        System.out.println(myBuild.next().status);
        System.out.println(myBuild.next().status);
        System.out.println(myBuild.next().status);
    }
}
