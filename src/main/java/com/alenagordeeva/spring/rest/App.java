package com.alenagordeeva.spring.rest;

import com.alenagordeeva.spring.rest.configuration.MyConfig;
import com.alenagordeeva.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication"
                , Communication.class);

//        // получение списка всех работников
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        // получение одного работника по id
//        Employee empById = communication.getEmployee(1);
//        System.out.println(empById);

//        // сохранение нового работника
//        Employee emp = new Employee("Sveta", "Sokolova"
//                , "HR", 900);
//        communication.saveEmployee(emp);

//        // обновление существующего работника
//        Employee emp = new Employee("Sveta", "Sokolova"
//                , "IT", 1200);
//        emp.setId(6);
//        communication.saveEmployee(emp);

        //удаление работника по id
        communication.deleteEmployee(6);
    }
}
