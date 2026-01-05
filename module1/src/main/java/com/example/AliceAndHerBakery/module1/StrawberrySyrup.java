package com.example.AliceAndHerBakery.module1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class StrawberrySyrup implements Syrup{
    @Override
    public String getSyrupType() {
        return "Strawberrry";
    }
}
