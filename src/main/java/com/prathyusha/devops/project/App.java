package com.prathyusha.devops.project;

import org.testng.TestNG;
import org.testng.collections.Lists;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("/Users/prathyushatumuluri/Documents/testphpwebsite/testng.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}
