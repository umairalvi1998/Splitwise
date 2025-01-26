package com.lld.splitwise;

import com.lld.splitwise.Command.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication {


    public static void main(String[] args) {

        SpringApplication.run(SplitwiseApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            try {
                CommandExecutor.execute(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

}
