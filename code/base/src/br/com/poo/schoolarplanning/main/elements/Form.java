package br.com.poo.schoolarplanning.main.elements;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.activities.GroupActivity;
import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.managers.Kanban;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** this class models a form that is used to interact with the user
 * @author Victor Martins
 * @author Higor Santiago
 */
public class Form {

    /**
     * Creates a form to receive all the attributes of a Subject
     * @return a new Subject
     */
    public static Subject subjectForm(){
        System.out.println("[SUBJECT FORM]");

        String name = scanRequiredField("Subject name");
        String teacherName = scanRequiredField("teacher");
        String description = scanRequiredField("description");
        
        return new Subject(name, teacherName, description);
    }

    /**
     * Creates a form to receive all the attributes of an Activity
     * @return a new Activity
     */
    public static Activity activityForm(Grade grade){
        System.out.println("[ACTIVITY FORM]");
        String name = scanRequiredField("Activity name");
        String description = scanRequiredField("Description");
        LocalDate startDate = scanLocalDateField("Start date");
        LocalDate deadLine = scanLocalDateField("DeadLine");
        Subject subject = switchSubject(grade);


        if (isAgroupActivity()){
            return new GroupActivity(name, description, startDate, deadLine, subject, activityParticipantsForm());
        }



        return new Activity(name, description, startDate, deadLine, subject);
    }

    /**
     * shows all subjects to the user and permits him chooses one
     * @param grade of subjects options
     * @return the chosen Subject
     */
    public static Subject switchSubject(Grade grade){
        boolean valueIsValid;
        Subject subject = null;

        Scanner input = new Scanner(System.in);
        System.out.println("\tSwitch a subject:");
        System.out.print(subjectsOptions(grade.getSubjects()));

        do{
            try {
                System.out.print("\tnumber: ");
                String index = input.nextLine();
                subject = grade.getSubjects().get(Integer.parseInt(index));
                valueIsValid = true;

            }catch (Exception exception){
                valueIsValid = false;
                System.out.println("\terror: invalid value");
            }
        }while (!valueIsValid);

        return subject;
    }

    /**
     * shows all activities to the user and permits him chooses one
     * @param kanban of activities options
     * @return the chosen Activity
     */
    public static Activity switchActivity(Kanban kanban){
        boolean valueIsValid;
        Activity activity = null;

        Scanner input = new Scanner(System.in);
        System.out.println("\tSwitch a activity:");
        System.out.print(activitiesOptions(kanban.getActivies()));

        do{
            try {
                System.out.print("\tnumber: ");
                String index = input.nextLine();
                activity = kanban.getActivies().get(Integer.parseInt(index));
                valueIsValid = true;

            }catch (Exception exception){
                valueIsValid = false;
                System.out.println("\terror: invalid value");
            }
        }while (!valueIsValid);

        return activity;
    }

    /**
     * scan a not empty String
     * @param fieldName title of field
     * @return a not empty String
     */
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

    /**
     * scan a date
     * @param fieldName title of field
     * @return a LocalDate
     */
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

    /**
     * Create a String by a Subject List
     * @param subjects to be listed
     * @return a String with all subjects
     */
    private static String subjectsOptions(List<Subject> subjects){
        String out = "";

        for (int cont = 0; cont < subjects.size(); cont++){
            out += "\t[" + cont + "] - " + subjects.get(cont).getName() + ":" + subjects.get(cont).getTeacherName() + "\n";
        }

        return out;
    }

    /**
     * Create a String by an Activity List
     * @param activities to be listed
     * @return a String with all activities
     */
    private static String activitiesOptions(List<Activity> activities){
        String out = "";

        for (int cont = 0; cont < activities.size(); cont++){
            Activity activity = activities.get(cont);

            out += String.format("\t[%d] - %s[%s] | subject: %s | Days Remaining: %d\n",
                                cont, activity.getName(), activity.getStage(), activity.getSubject().getName(), activity.daysUntilDeadLine() );
        }

        return out;
    }

    /**
     * asks if that is a GroupActivity
     * @return a boolean type from the answer
     */
    private static boolean isAgroupActivity(){
        System.out.print("is a group activity? [yes / enter anything for not]: ");
        String option = new Scanner(System.in).nextLine();

        return (option.equalsIgnoreCase("yes"));
    }

    /**
     * Creates a form to receive all the names of the participants
     * @return a new String List of names
     */
    private static List<String> activityParticipantsForm(){
        List<String> list = new ArrayList<String>();
        Scanner input = new Scanner(System.in);

        do {
            list.add(scanRequiredField("participant name: "));

            System.out.print("continue?[no / enter anything to continue]: ");
            String flag = input.nextLine();

            if (flag.equalsIgnoreCase("no")){
                break;
            }
        }while (true);
        return list;
    }
}
