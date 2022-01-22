package br.com.poo.schoolarplanning.tests;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.managers.Kanban;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.time.LocalDate;

public class TestKanban {
    public static void main(String[] args) {
        Kanban kanban = new Kanban();

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.plusDays(3);

        Subject materia = new Subject("POO", "Francisco", "programacao orientada a objetos");
        Subject materia1 = new Subject("Arquitetura", "Francisco", "programacao orientada a objetos");
        Subject materia2 = new Subject("Discreta", "Francisco", "programacao orientada a objetos");

        Activity ativEx1 = new Activity( "Trabalho 1", "Fazer um projeto", localDate1, localDate2, materia);
        Activity ativEx2 = new Activity( "Trabalho 2", "Fazer um projeto", localDate1, localDate2, materia2);
        Activity ativEx3 = new Activity( "Trabalho 3", "Fazer um projeto", localDate1, localDate2, materia1);
        Activity ativEx4 = new Activity( "Trabalho 4", "Fazer um projeto", localDate1, localDate2, materia);
        Activity ativEx5 = new Activity( "Trabalho 5", "Fazer um projeto", localDate1, localDate2, materia1);

        kanban.add(ativEx1);
        kanban.add(ativEx2);
        kanban.add(ativEx3);
        kanban.add(ativEx4);
        kanban.add(ativEx5);

        System.out.println(kanban.describe());
        System.out.println(kanban);
    }
}
