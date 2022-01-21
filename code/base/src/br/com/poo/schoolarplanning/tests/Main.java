package br.com.poo.schoolarplanning.tests;
import java.util.Locale;
import java.util.Scanner;
import br.com.poo.schoolarplanning.domain.subjects.Subject;
import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.managers.Kanban;


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

            while (!Opcao2.equals("exit")) {

              switch (ui[0]) {
                case "add":
                  Subject materia = new Subject(ui[1], ui[2], ui[3]);
                  grade.add(materia);
                  break;
                case "show":
                  System.out.print(grade.describeSubjects());
                  Menus.menuMateria();
                  break;
                case "remove":
                  grade.remove(grade.getSubjects().get(grade.FindItemIndexByName(ui[1])));
                case "update":
                  materia = new Subject(ui[1], ui[2], ui[3]);
                  grade.update(grade.getSubjects().get(grade.FindItemIndexByName(ui[1])), materia);
                  break;
              }

            }
          }
      }
    } catch ( Exception e ){
      System.out.println(e.getMessage());
    }

    
  } 
 }
}




