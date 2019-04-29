package com.meek.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(String.class.getClassLoader().getClass().getSimpleName());
        System.out.println(String.class.getClassLoader().getClass());
    }
    
    public static void main(String[] args){  
        if(1 == 1){
            System.out.println("1");
        }else if(1 == 1){
            System.out.println("1");
        }else {
            System.out.println("1");
        }
        new ArrayList<>().add(null);
        new HashSet<>().add(null);
    }

}
