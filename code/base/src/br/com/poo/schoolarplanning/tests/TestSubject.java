package br.com.poo.schoolarplanning.tests;


import br.com.poo.schoolarplanning.domain.subjects.Subject;

public class TestSubject {
    public static void main(String[] args) {
        Subject subject = new Subject("POO", "Atilio", "programcao orientada a objetos");

        System.out.println(subject);
    }
}
