package com.example.companyapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CompanyApplication.class, args);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        employeeRepository.save(new Employee(1L, "Jan", "Kowalski", 2000.0));
        employeeRepository.save(new Employee(2L, "Marta", "Dudek", 13000.0));
        employeeRepository.save(new Employee(3L, "Paweł", "Adamczyk", 12500.0));
        employeeRepository.save(new Employee(4L, "Kasia", "Kowalska", 4000.0));

        System.out.println(">>> Pracownicy po podwyżce:");
        employeeRepository.giveRiseToAll();
        employeeRepository.findAll().forEach(System.out::println);

        System.out.println(">>> Bogaci pracownicy:");
        employeeRepository.findRichEmployee().forEach(System.out::println);

        System.out.println(">>>Pracownicy z zarobkami pomiedzy min a max:");
        employeeRepository.findBySalaryInRange(3000, 12700).forEach(System.out::println);
        System.out.println(">>>Pracownicy po usunięciu");
        employeeRepository.deleteById(1L);

        System.out.println("czy jestem na git ???");
        System.out.println("jj");


    }

}
