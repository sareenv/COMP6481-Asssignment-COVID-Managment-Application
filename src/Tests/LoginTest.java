package Tests;

//
// Assignment 1
// © Vinayak Sareen.
// Written by: Vinayak Sareen - SID: 40186182
//

import Main.Main;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.Assert.*;


public class LoginTest {

    @Test
    public void loginTest() throws FileNotFoundException {
        String path = "/Users/databunker/IdeaProjects/Assignment1/src/Tests/";
        String fileName = "wrongPasswords.txt";
        File file = new File(path + fileName);
        System.out.println(file);
        Scanner snc = new Scanner(file);
        Main driver = new Main();
        boolean result = driver.validateUserPassword(snc);
        snc.close();
        assertEquals(result, false);
    }

}
