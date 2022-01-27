package br.com.poo.schoolarplanning.tests;

import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.managers.Kanban;
import br.com.poo.schoolarplanning.main.elements.Form;

public class TestForm {
    public static void main(String[] args) {
        Grade grade = new Grade();
        Kanban kanban = new Kanban();

        grade.add(Form.subjectForm());

        kanban.add(Form.activityForm(grade));
        kanban.add(Form.activityForm(grade));

        Form.switchActivity(kanban);

        System.out.println("------------------");
        System.out.println(kanban.describe());
    }
}
