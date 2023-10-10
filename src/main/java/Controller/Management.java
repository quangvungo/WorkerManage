package Controller;

import Model.SalaryStatus;
import Model.SalaryHistory;
import Model.Worker;
import View.Validation;
import View.Validation.WorkerException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Management {

    public static Scanner sc = new Scanner(System.in);
    private List<Worker> workers = new ArrayList<>();
public List<SalaryHistory> getInfomationSalary() {
        return salaryHistory;
    }
    private List<SalaryHistory> salaryHistory = new ArrayList<>();

    public Worker createWorker() {
        System.out.print("Enter Worker Code: ");
        String code = sc.nextLine();
        System.out.print("Enter Worker Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Worker Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Worker Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter Work Location: ");
        String workLocation = sc.nextLine();
        return new Worker(code, name, age, salary, workLocation);
    }

    public boolean addWorker(Worker worker) throws WorkerException {
        if (!isWorkerCodeValid(worker.getCode())) {
            throw new WorkerException("Worker code is invalid or already exists.");
        }

        if (!Validation.isAgeValid(worker.getAge())) {
            throw new WorkerException("Age must be in the range 18 to 50.");
        }

        if (!Validation.isSalaryValid(worker.getSalary())) {
            throw new WorkerException("Salary must be greater than 0.");
        }

        // If all validations pass, add the worker.
        workers.add(worker);
        System.out.println("Add Successfully");
        return true;
    }

    private Worker findWorkerByCode(String code) {
        return workers.stream().filter(w -> w.getCode().equals(code)).findFirst().orElse(null);
    }

    public List<Worker> getAllWorkers() {
        return workers.stream().sorted(Comparator.comparing(Worker::getCode)).collect(Collectors.toList());
    }

    public Iterable<Worker> getWorkers() {
        return workers;
    }

    public void adjustSalary(SalaryStatus status) throws WorkerException {
      
        System.out.print("Enter Worker Code: ");
        String code = sc.nextLine();
      
        System.out.print("Enter Amount to " + (status == SalaryStatus.UP ? "UP" : "DOWN") + " Salary: ");
        double amount = sc.nextDouble();
            sc.nextLine();

        boolean adjusted = changeSalary(status, code, amount);

        if (adjusted) {
            System.out.println("Salary adjusted successfully.");
        } else {
            System.out.println("Invalid input or Worker with the provided code does not exist.");
        }
    }

    public boolean changeSalary(SalaryStatus status, String code, double amount) throws WorkerException {
        Worker worker = findWorkerByCode(code);
        if (worker == null) {
            throw new WorkerException("Worker with the provided code does not exist.");
        }

        if (status == SalaryStatus.DOWN && amount > worker.getSalary()) {
            throw new WorkerException("Amount to decrease exceeds the current salary.");
        }

        if (status == SalaryStatus.UP && amount <= 0) {
            throw new WorkerException("Amount to increase must be greater than 0.");
        }

        if (status == SalaryStatus.DOWN) {
            worker.decreaseSalary(amount);
        } else if (status == SalaryStatus.UP) {
            worker.increaseSalary(amount);
        }

        salaryHistory.add(new SalaryHistory(worker.getCode(),code, worker.getSalary(),status));
        return true;
    }
        public  void showAdjustedSalaryWorkers() {
        List<SalaryHistory> salaryHistory = getInfomationSalary();
        if (salaryHistory.isEmpty()) {
            System.out.println("No salary adjustments have been made yet.");
        } else {
            System.out.println("Adjusted Salary Worker Information:");
            for (SalaryHistory history : salaryHistory) {
                System.out.println(history);
            }
        }
    }
         public   boolean isWorkerCodeValid(String code) {
    for (Worker worker : workers) {
        if (worker.getCode().equals(code)) {
            return false; // Worker code already exists
        }
    }
    return true; // Worker code is valid
}
}
