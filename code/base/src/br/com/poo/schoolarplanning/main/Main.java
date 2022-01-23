package br.com.poo.schoolarplanning.main;
import java.util.Locale;
import java.util.Scanner;
import br.com.poo.schoolarplanning.domain.subjects.Subject;
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
    
    while( true ){

      Menus.menuPrincipal();
      int Opcao = scanner.nextInt();

      try{
        if( Opcao == 3) {
          break;
        } else if( Opcao == 1 ){
          while ( true ) {
            String Opcao2 = scanner.nextLine();
            String ui[] = Opcao2.split("  ");
            Menus.menuSubject();

              switch (ui[0]) {
                case "add":
                  grade.add(Form.subjectForm());
                  Menus.menuSubject();
                  break;
                case "show":
                  System.out.print(grade.describe());
                  Menus.menuSubject();
                  break;
                case "remove":
                  grade.removeByName(ui[1]);
                  break;
                case "update":
                  Subject materia = new Subject(ui[1], ui[2], ui[3]);
                  grade.update( grade.getSubjects().get( grade.findItemIndexByName(ui[1])), materia );
                  break;
                case "exit":
                throw new ManagerExceptions("");

              }
            }
        } else if( Opcao == 2){

            while ( true ) {
              String Opcao2 = scanner.nextLine();
              String ui[] = Opcao2.split("  ");
              Menus.menuAtiv();
  
                switch (ui[0]) {
                  case "add":
                    kanban.add(Form.activityForm(grade));
                    break;
                  case "show":
                    System.out.print(kanban);
                    Menus.menuAtiv();
                    break;
                  case "remove":
                    kanban.removeByName(ui[1]);;
                  case "update":
                    kanban.add(Form.activityForm(grade));
                    break;
                  case "kanban":
                    System.out.println(kanban.describe());
                    Menus.menuAtiv();
                    kanban.controlKanban();
                    Menus.menuAtiv();                    
                    break;
                  case "exit":
                  throw new ManagerExceptions("");
  
                }
              }
          
        } else { throw new ManagerExceptions("Opcao Invalida"); }
    } catch ( Exception e ){ 
      //System.out.println(e.getMessage());
      e.printStackTrace(); } 
  } 
  scanner.close();
  }
}






