package com.example.AliceAndHerBakery.module1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {
    private  final  CakeBaker cakeBaker;
    public Module1Application(CakeBaker cakeBaker, CakeBaker cakeBaker1){
        this.cakeBaker = cakeBaker;
    }


    public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception{
        cakeBaker.bakeCake();
    }
}
