package com.example.AliceAndHerBakery.module1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class StrawberryFrosting implements Frosting{

    @Override
    public String getFrostingType() {
        return "Strawberry";
    }
}
