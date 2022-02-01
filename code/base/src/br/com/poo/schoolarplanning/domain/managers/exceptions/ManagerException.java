package br.com.poo.schoolarplanning.domain.managers.exceptions;

/**
 * This class models "Manager Exceptions", which is responsible for handling exceptions
 * @author Higor Santiago
 * @author Victor Martins 
 */

public class ManagerException extends Exception {
  public ManagerException(String message) {
      super(message);
  }
}