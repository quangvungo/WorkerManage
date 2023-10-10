/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class SalaryHistory  {
    private String name;
    private String workerCode;
    private SalaryStatus status; 
    private double salaryPresent;
    private Date changeDay;
    public SalaryHistory(String name,String workerCode, double salaryPresent,SalaryStatus status ) {
        long millis=System.currentTimeMillis();
        this.name = name;
        this.workerCode = workerCode;
        this.salaryPresent = salaryPresent;
        this.changeDay= new java.sql.Date(millis); 
        this.status = status;
    }
    
    public String getWorkerCode() {
        return workerCode;
    }

    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode;
    }

  
    

    @Override
    public String toString() {
        return "Worker Code: " + workerCode +", Name :" +name + ",Salary: " + salaryPresent + ",Statuc : "+status + ",Chage day: " + changeDay;
    }
}
