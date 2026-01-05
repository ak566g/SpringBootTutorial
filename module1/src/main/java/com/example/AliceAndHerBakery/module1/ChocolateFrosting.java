package com.example.AliceAndHerBakery.module1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class ChocolateFrosting implements Frosting{
    @Override
    public String getFrostingType() {
        return "Chocolate";
    }
}
