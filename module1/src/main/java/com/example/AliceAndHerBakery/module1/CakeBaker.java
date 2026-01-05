package com.example.AliceAndHerBakery.module1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    private final Frosting frosting;
    private final Syrup syrup;

    // Dependency Injection via constructor
    public CakeBaker(Frosting frosting,Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Baking Cake...");
        System.out.println("Adding frosting "+ frosting.getFrostingType());
        System.out.println("Adding syrup "+ syrup.getSyrupType());
        System.out.println("Cake baked");
    }
}
