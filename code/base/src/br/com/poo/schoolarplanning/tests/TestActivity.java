package br.com.poo.schoolarplanning.tests;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.time.LocalDate;

public class TestActivity {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.now().plusDays(3);

        Subject materia = new Subject("POO", "Francisco", "programacao orientada a objetos");
        Activity ativEx = new Activity( "Trabalho de POO", "Fazer um projeto", localDate1, localDate2, materia);

        System.out.println(ativEx);
    }
}
