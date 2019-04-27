package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {
    Task myTask1 = new Task("hello world");
    Task myTask2 = new Task("hello day", "done");

    @Before
    public void init() {
        myTask1.setState("done");
    }

    @Test
    public void getContent() {
        assertEquals("hello world", myTask1.getContent());
    }

    @Test
    public void getState() {
        assertEquals("done", myTask1.getState());
    }

    @Test
    public void setState() {
        myTask2.setState("not done");
        assertEquals("not done", myTask2.getState());
    }

}