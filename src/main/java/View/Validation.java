/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.Management;
import Model.Worker;
/**
 *
 * @author conch
 */
public class Validation {

  public static boolean isAgeValid(int age) {
        return age >= 18 && age <= 50;
    }
   public static boolean isSalaryValid(double salary) {
        return salary > 0;
    }
   public static class WorkerException extends Exception {
    public WorkerException(String message) {
        super(message);
    }
}


}
