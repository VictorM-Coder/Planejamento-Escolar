package br.com.poo.schoolarplanning.main.elements;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.subjects.Subject;
import br.com.poo.schoolarplanning.main.elements.Menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Form {

    public static Subject subjectForm(){
        System.out.println("[SUBJECT FORM]");

        String name = scanRequiredField("Subject name");
        String teacherName = scanRequiredField("teacher");
        String description = scanRequiredField("description");
        return new Subject(name, teacherName, description);
    }

    public static Activity activityForm(Grade grade){
        System.out.println("[ACTIVITY FORM]");
        String name = scanRequiredField("Activity name");
        String description = scanRequiredField("Description");
        LocalDate startDate = scanLocalDateField("Start date");
        LocalDate deadLine = scanLocalDateField("DeadLine");
        Subject subject = scanSubjectField(grade);
        

        return new Activity(name, description, startDate, deadLine, subject);
    }

    private static String scanRequiredField(String fieldName){
        Scanner input = new Scanner(System.in);
        String value = "";
        do {
            System.out.print("\t" + fieldName  + ": ");
            value = input.nextLine();

            if (value.length() == 0){
                System.out.println("\terror: this field can't be empty");
            }
        }while (value.length() == 0);

        return value;
    }

    private static LocalDate scanLocalDateField(String fieldName){
        Scanner input = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();
        boolean dateIsValid;

        do {
            try{
                System.out.print("\t" + fieldName + "[MM-dd-yyyy]: ");
                localDate = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                dateIsValid = true;
            }catch (DateTimeParseException exception){
                System.out.println("\terror: this is an invalid date format");
                dateIsValid = false;
            }
        }while (!dateIsValid);

        return localDate;
    }

    private static Subject scanSubjectField(Grade grade){
        boolean valueIsValid;
        Subject subject = null;

        Scanner input = new Scanner(System.in);
        System.out.println("\tSwitch a subject:");
        System.out.print(subjectsOptions(grade.getSubjects()));

        do{
            try {
                System.out.print("\tnumber: ");
                int index = input.nextInt();

                subject = grade.getSubjects().get(index);
                valueIsValid = true;

            }catch (Exception exception){
                valueIsValid = false;
                System.out.println("\terror: invalid value");
            }
        }while (!valueIsValid);

        return subject;
    }

    private static String subjectsOptions(List<Subject> subjects){
        String out = "";

        for (int cont = 0; cont < subjects.size(); cont++){
            out += "\t[" + cont + "] - " + subjects.get(cont).getName() + ":" + subjects.get(cont).getTeacherName() + "\n";
        }

        return out;
    }

}
