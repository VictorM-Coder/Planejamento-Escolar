package br.com.poo.schoolarplanning.main;

import java.util.Locale;
import java.util.Scanner;

import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.managers.Kanban;
import br.com.poo.schoolarplanning.domain.managers.exceptions.ManagerExceptions;
import br.com.poo.schoolarplanning.main.elements.Menus;
import br.com.poo.schoolarplanning.main.elements.Form;


public class Main {
    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);
        Grade grade = new Grade();
        Kanban kanban = new Kanban();

        while (true) {

            Menus.menuPrincipal();
            int Opcao = scanner.nextInt();
            scanner.nextLine();
            try {
                if(Opcao == 1){
                    gradeScene(grade);

                } else if(Opcao == 2){
                    kanbanScene(kanban, grade);

                } else if(Opcao == 3){
                    break;

                } else{
                    throw new ManagerExceptions("Opcao Invalida");
                }
            } catch (Exception e) {
                //System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    /*MAIN CLASS*/
    public static void gradeScene(Grade grade){
        while (true) {
            Menus.menuSubject();
            String Opcao2 = new Scanner(System.in).nextLine();
            String ui[] = Opcao2.split("  ");

            if ("add".equals(ui[0])) {
                grade.add(Form.subjectForm());

            } else if ("show".equals(ui[0])) {
                System.out.print(grade.describe());

            } else if ("remove".equals(ui[0])) {
                grade.remove(Form.switchSubject(grade));

            } else if ("update".equals(ui[0])) {
                grade.update(Form.switchSubject(grade), Form.subjectForm());

            } else if ("exit".equals(ui[0])) {
                break;
            }
        }
    }

    public static void kanbanScene(Kanban kanban, Grade grade){
        while (true) {
            Menus.menuAtiv();
            String Opcao2 = new Scanner(System.in).nextLine();
            String ui[] = Opcao2.split("  ");

            if ("add".equals(ui[0])) {
                kanban.add(Form.activityForm(grade));

            } else if ("show".equals(ui[0])) {
                System.out.print(kanban);

            } else if ("remove".equals(ui[0])) {
                kanban.remove(Form.switchActivity(kanban));

            } else if ("update".equals(ui[0])) {
                kanban.update(Form.switchActivity(kanban), Form.activityForm(grade));

            } else if ("kanban".equals(ui[0])) {
                kanbanActionsScene(kanban);
            } else if ("exit".equals(ui[0])) {
                break;
            }
        }
    }

    public static void kanbanActionsScene(Kanban kanban){
        while (true){
            System.out.println(kanban.describe());
            Menus.menuKanban();

            String option = new Scanner(System.in).nextLine();

            if (option.equalsIgnoreCase("do")){
                kanban.doActivity(Form.switchActivity(kanban));

            }else if (option.equalsIgnoreCase("done")){
                kanban.doneActivity(Form.switchActivity(kanban));

            }else if (option.equalsIgnoreCase("exit")){
                break;
            }
        }
    }
}






