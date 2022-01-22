package br.com.poo.schoolarplanning.main;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import br.com.poo.schoolarplanning.domain.subjects.Subject;
import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.managers.Kanban;
import br.com.poo.schoolarplanning.domain.managers.exceptions.ManagerExceptions;
import br.com.poo.schoolarplanning.main.elements.Menus;


public class Main {
  public static void main(String[] args) {

    Locale.setDefault(new Locale("pt", "BR"));
    Scanner leitor = new Scanner(System.in);
    Grade grade = new Grade();
    Kanban kanban = new Kanban();
    
    while( true ){

      Menus.menuPrincipal();
      int Opcao = leitor.nextInt();

      try{
        if( Opcao == 3) {
          break;
        } else if( Opcao == 1 ){
          while ( true ) {
            String Opcao2 = leitor.nextLine();
            String ui[] = Opcao2.split("  ");
            Menus.menuMateria();

              switch (ui[0]) {
                case "add":
                  Subject materia = new Subject(ui[1], ui[2], ui[3]);
                  grade.add(materia);
                  break;
                case "show":
                  System.out.print(grade.describe());
                  Menus.menuMateria();
                  break;
                case "remove":
                  grade.removeByName(ui[1]);;
                case "update":
                  materia = new Subject(ui[1], ui[2], ui[3]);
                  grade.update( grade.getSubjects().get( grade.findItemIndexByName(ui[1])), materia );
                  break;
                case "exit":
                throw new ManagerExceptions("");

              }
            }
        } else if( Opcao == 2){

            while ( true ) {
              String Opcao2 = leitor.nextLine();
              String ui[] = Opcao2.split("  ");
              Menus.menuAtiv();
  
                switch (ui[0]) {
                  case "add":
                    Activity ativ = new Activity(ui[1], ui[2], LocalDate.now(), LocalDate.now(), grade.getSubjects().get(grade.findItemIndexByName(ui[3])));
                    kanban.add(ativ);
                    break;
                  case "show":
                    System.out.print(kanban);
                    Menus.menuAtiv();
                    break;
                  case "remove":
                    kanban.removeByName(ui[1]);;
                  case "update":
                    ativ = new Activity(ui[1], ui[2], LocalDate.now(), LocalDate.now(), grade.getSubjects().get(grade.findItemIndexByName(ui[3])));
                    kanban.update( kanban.getActivies().get(kanban.findItemIndexByName(ui[1])), ativ);
                    break;
                  case "kanban":
                    System.out.println(kanban.describe());
                    Menus.menuAtiv();
                    System.out.println("doing | done | exit");
                    kanban.controlKanban();
                    Menus.menuAtiv();                    
                    break;
                  case "exit":
                  throw new ManagerExceptions("");
  
                }
              }
          
        } else { throw new ManagerExceptions("Opcao Invalida"); }
    } catch ( Exception e ){ 
      System.out.println(e.getMessage()); } 
  } 
  leitor.close();
  }
}






