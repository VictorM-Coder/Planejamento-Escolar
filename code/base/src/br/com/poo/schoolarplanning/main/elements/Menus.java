package br.com.poo.schoolarplanning.main.elements;

public class  Menus {

    public static void menuPrincipal(){
      System.out.println("--------------------------------------------");
      System.out.println("| 1 - Materias | 2 - Atividades | 3 - Exit | ");
      System.out.println("--------------------------------------------");
    }
    public static void menuMateria(){
      System.out.println("---------------------------------------");
      System.out.println("| add | remove | update | exit | show |");
      System.out.println("---------------------------------------");
    }

    public static void menuAtiv(){
      System.out.println("----------------------------------------------------");
      System.out.println("| add | remove | update | exit | kanban | pomodoro |");
      System.out.println("----------------------------------------------------");
    }
}
