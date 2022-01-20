package br.com.poo.schoolarplanning.tests;

import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

public class TestGrade {
    public static void main(String[] args) {
        Grade grade = new Grade();
        Subject subject1 = new Subject("POO", "Atilio", "programcao orientada a objetos");
        Subject subject2 = new Subject("Processos de software", "Carla", "Engenharia de processos de software");
        Subject subject3 = new Subject("Discreta", "PH", "matematica discreta e suas aplicacoes");
        Subject subject4 = new Subject("Estatistica", "Elvis", "estatisca matematica");
        Subject subject5 = new Subject("Arquitetura de computadores", "Igor", "arquitetura de computadores");

        grade.add(subject1);
        grade.add(subject2);
        grade.add(subject3);
        grade.add(subject4);
        grade.add(subject5);

        System.out.println(grade);

        System.out.println("-----------------");
        grade.remove(subject5);
        Subject subject = new Subject("Discreta", "Araruna", "matematica discreta e suas aplicacoes");
        grade.update(subject3, subject);
        System.out.println(grade.describeSubjects());

    }
}
