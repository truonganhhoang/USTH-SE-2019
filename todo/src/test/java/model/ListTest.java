package model;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ListTest {
    private List testedList = new List();

    @Before
    public void init() {
        testedList.add(new Task("hello world", "not done"));
        testedList.add(new Task("follow me", "not done"));
        testedList.add(new Task("buy fruits", "not done"));
    }

    @Test
    public void Size() {
        assertEquals("Checking size of list", 3, testedList.size());
    }

    @Test
    public void showList() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testedList.showList();
        String expectedOutput = "List Info:\nhello world/not done\nfollow me/not done\nbuy fruits/not done\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void Add() {
        testedList.add(new Task("keep calm"));
        assertEquals("Adding 1 more task to list", 4, testedList.size());
    }

    @Test
    public void Remove() {
        testedList.remove(2);
        assertEquals("Remove 1 task from list", 2, testedList.size());
    }

    @Test
    public void Clear() {
        testedList.clear();
        assertEquals("Remove all tasks from list", 0, testedList.size());
    }
}