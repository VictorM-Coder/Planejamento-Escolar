package br.com.poo.schoolarplanning.main;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.enums.KanbanStage;
import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.managers.Kanban;
import br.com.poo.schoolarplanning.domain.subjects.Subject;
import br.com.poo.schoolarplanning.main.elements.Menus;
import br.com.poo.schoolarplanning.main.elements.Form;
import br.com.poo.schoolarplanning.persistence.Serializer;

/**
 * This class is responsible for controlling the application and interacting with the user.
 * @author Higor Santiago
 * @author Victor Martins 
 */

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);
        Grade grade = new Grade(Serializer.readSubjectList());
        Kanban kanban = new Kanban(Serializer.readActivitiesList());

        while (true) {

            Menus.menuPrincipal();
            String option = scanner.next();
            scanner.nextLine();
            try {
                if(option.equalsIgnoreCase("grade")){
                    gradeScene(grade, kanban);

                } else if(option.equalsIgnoreCase("activities")){
                    if (checkListIsNotEmpty("subject", grade.getSubjects())){
                        kanbanScene(kanban, grade);
                    }

                }else if(option.equalsIgnoreCase("exit")){
                    Serializer.writeActivitiesList(kanban.getActivies());
                    Serializer.writeSubjectsList(grade.getSubjects());
                    break;

                } else{
                    soutErrorInvalidValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    /*MAIN CLASS*/
    private static void gradeScene(Grade grade, Kanban kanban){
        while (true) {
            Menus.menuSubject();
            String option = new Scanner(System.in).nextLine();

            if ("add".equalsIgnoreCase(option)) {
                grade.add(Form.subjectForm());

            } else if ("show".equalsIgnoreCase(option)) {
                System.out.print(grade.describe());

            } else if ("remove".equalsIgnoreCase(option)) {
                if (checkListIsNotEmpty("subject", grade.getSubjects())){
                    Subject subject = Form.switchSubject(grade);
                    System.out.print("Are you sure about that? (all activities of this subject will be deleted) [yes/no]: ");
                    String answer = new Scanner(System.in).nextLine();

                    if (answer.equalsIgnoreCase("yes")){
                        grade.remove(subject);

                        for (Activity activity: kanban.getActivitiesBySubject(subject)){
                            kanban.remove(activity);
                        }
                    }
                }

            } else if ("update".equalsIgnoreCase(option)) {
                if (checkListIsNotEmpty("subject", grade.getSubjects())){
                    grade.update(Form.switchSubject(grade), Form.subjectForm());
                }

            } else if ("exit".equalsIgnoreCase(option)) {
                break;
            }else{
                soutErrorInvalidValue();
            }
        }
    }

    private static void kanbanScene(Kanban kanban, Grade grade){
        while (true) {
            Menus.menuAtiv();
            String option = new Scanner(System.in).nextLine();

            if ("add".equalsIgnoreCase(option)) {
                kanban.add(Form.activityForm(grade));

            } else if ("show".equalsIgnoreCase(option)) {
                System.out.print(kanban);

            } else if ("remove".equalsIgnoreCase(option)) {
                if (checkListIsNotEmpty("activity", kanban.getActivies())){
                    kanban.remove(Form.switchActivity(kanban));
                }

            } else if ("update".equalsIgnoreCase(option)) {
                if (checkListIsNotEmpty("activity", kanban.getActivies())){
                    kanban.update(Form.switchActivity(kanban), Form.activityForm(grade));
                }

            } else if ("kanban".equalsIgnoreCase(option)) {
                kanbanActionsScene(kanban);
            } else if ("exit".equalsIgnoreCase(option)) {
                break;
            }else{
                soutErrorInvalidValue();
            }
        }
    }

    private static void kanbanActionsScene(Kanban kanban){
        while (true){
            System.out.println(kanban.describe());
            Menus.menuKanban();

            String option = new Scanner(System.in).nextLine();

            if (option.equalsIgnoreCase("do")){
                if (checkListIsNotEmpty("activity to do", kanban.getActivitiesByPhase(KanbanStage.TO_DO))){
                    kanban.doActivity(Form.switchActivity(kanban));
                }

            }else if (option.equalsIgnoreCase("done")){
                if (checkListIsNotEmpty("activity doing", kanban.getActivitiesByPhase(KanbanStage.DOING))){
                    kanban.doneActivity(Form.switchActivity(kanban));
                }

            }else if (option.equalsIgnoreCase("exit")){
                break;
            }else{
                soutErrorInvalidValue();
            }
        }
    }

    private static void soutErrorInvalidValue(){
        System.out.println("error: invalid value");
    }

    private static boolean checkListIsNotEmpty(String nameList, List list){
        if (list.isEmpty()){
            System.out.println("Error: you need to add a " + nameList + " first");
            return false;
        }
        return true;
    }
}