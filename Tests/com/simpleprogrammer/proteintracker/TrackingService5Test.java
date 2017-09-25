package com.simpleprogrammer.proteintracker;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TrackingService5Test {

    TrackingService service;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before Each");
        service = new TrackingService();
    }

    @Test
    public void getTotalTest(){

        assertEquals(0, service.getTotal(), "The default value oh the service has to be zero");

    }

    @Test
    public void addProteinTest(){

        int protein = 15;

        service.addProtein(protein);

        assertEquals( protein, service.getTotal(), "Protein total amount has increase by 15");

    }

    @Test
    public void removeProteinTest(){

        int protein = 15;

        service.removeProtein(protein);

        assertEquals(0, service.getTotal(), "Protein total amount ha decrease by 15");

    }

    @Test
    public void setGoalIsSetLessThanZeroTest() {

        int goal = -5;
        assertThrows (InvalidGoalException.class, () -> {
            service.setGoal(goal);
        });
        //service.setGoal(goal);

    }

    @Ignore
    public void disabedTest(){
        System.out.println("This test is disabled until @ignore annotation exists");
    }

    @Test
    public void addProteinPerformanceTest(){
        assertTimeout(Duration.ofMillis(200),() ->{
            for(int protein = 1; protein < 1000000; protein++)
                service.addProtein(protein);
            System.out.println(service.getTotal());
        });

    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After Each");
    }

}