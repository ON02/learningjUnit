package com.simpleprogrammer.proteintracker;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.Assert.*;

public class TrackingServiceTest {

    TrackingService service;

    @BeforeClass
    public static void before() {
        System.out.println("before class");
    }

    @Before
    public void setUp(){
        System.out.println("Before");
        service = new TrackingService();
    }

    @Test
    @Category(ApprovedTestsCategory.class)
    public void testGetTotal(){

        assertEquals("Tracking service was not zero",0,service.getTotal());
    }

    @Test
    @Category(ApprovedTestsCategory.class)
    public  void testAddProtein(){
        service.addProtein(10);
        //assertEquals("the value must be 10", 10, service.getTotal());
        //assertThat(service.getTotal(), is(10));
        assertThat(service.getTotal(), allOf(is(15), instanceOf(Integer.class)));
    }

    @Test
    @Category({ApprovedTestsCategory.class, InProcessTestsCategory.class})
    public void testRemoveProtein() {
        service.removeProtein(10);
        assertEquals("the value must be zero;", 0, service.getTotal());
    }

    @Ignore
    public void ignoredTest() {
        System.out.println("This test never runs");
    }

    @Ignore
    @Test(expected = InvalidGoalException.class)
    public void testSetGoal() throws InvalidGoalException {
        service.setGoal(-5);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testSetGoal2() throws InvalidGoalException {

        thrown.expect(InvalidGoalException.class);
        thrown.expectMessage("Goal was less than zero!");
        //thrown.expectMessage(containsString("goal"));
        service.setGoal(-5);
    }

    @Test(timeout = 2000)
    public void testPerformance(){
        for(int i = 0; i < 1000000; i++)
            service.addProtein(1);
    }

    @After
    public void tearDown(){
        System.out.println("After");
    }

    @AfterClass
    public static void  after(){
        System.out.println("after class");
    }
}