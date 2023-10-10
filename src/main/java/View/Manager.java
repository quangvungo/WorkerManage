/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Management;
import static Model.SalaryStatus.DOWN;
import static Model.SalaryStatus.UP;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author conch
 */
public class Manager extends Menu<String> {

    public static Scanner sc = new Scanner(System.in);
    static String[] mc = {"Add Worker", "Increase salary", "Decrease salary", "Show all worker have been adjusted salary by worker code", "Exit"};
    protected Management managers;

    public Manager() {
        super("MENU", mc);
        managers = new Management();
    }

    @Override
    public void execute(String n) {
        switch (n) {
            case "1" -> {                    
            try {
                managers.addWorker(managers.createWorker());
            } catch (Validation.WorkerException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }}
            case "2" -> {
            try {
                managers.adjustSalary( UP);
            } catch (Validation.WorkerException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case "3" ->{
            try {
                managers.adjustSalary( DOWN);
            } catch (Validation.WorkerException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case "4" -> 
                managers.showAdjustedSalaryWorkers();
            case "5" ->
                System.exit(0);
             default -> System.out.println("Invalid choice. Please select a valid option.");
        }
    }

}
