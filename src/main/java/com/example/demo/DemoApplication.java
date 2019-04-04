package com.example.demo;

import com.example.demo.bi.one2many.Address;
import com.example.demo.bi.one2many.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.bi.one2many")
public class DemoApplication implements CommandLineRunner {

    @Autowired
    UserRepo userRepo;
    @Autowired
    AddressRepo addressRepo;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       /*
       //many2many bi
       User user0 = userRepo.save(new User());
        User user1 = userRepo.save(new User());
        Address address0 = addressRepo.save(new Address());
        Address address1 = addressRepo.save(new Address());

        address0.addUser(user0);
        address0.addUser(user1);
        address1.addUser(user0);

        // address0.getUsers().clear();

        user0.addAddress(address0);
        user0.addAddress(address1);
        user1.addAddress(address0);

       *//* addressRepo.save(address0);
        addressRepo.save(address1);
        userRepo.save(user0);
        userRepo.save(user1);*//*

        System.out.println("\n\n");
        address0.getUsers().forEach(System.out::println);
        System.out.println("\n\n");
        user0.getAddresses().forEach(System.out::println);
        System.out.println("\n\n");*/

       /*
       //Many2One BI
       Address address0 = addressRepo.save(new Address());

        User user0 =  new User();

        address0.addUser(user0);

        userRepo.save(user0);*/




        Long startTime = System.nanoTime();

        Address address0 = new Address();
        Address address1 = new Address();
        User user0 = new User();

        user0.addAddress(address0);
        user0.addAddress(address1);

//        user0.getAddresses().clear();

        userRepo.save(user0);

//        addressRepo.save(address0);

//        userRepo.deleteById(178L);
         addressRepo.findById(1L);

        System.out.println("\n\n\n"+ (System.nanoTime()-startTime) + "\n\n\n");

      //  Address address0 = addressRepo.save(new Address());



//          userRepo.deleteById(25L);
//            addressRepo.deleteById(29L);


        //        userRepo.save(user0);
//        userRepo.save(user1);
/*
        addressRepo.save(address0);
        addressRepo.save(address1);*/
    }
}