package com.eugene.tests;

import com.eugene.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected ApplicationManager app;

    @BeforeClass
    public void init(){
        app = new ApplicationManager();
    }

    @AfterClass
    public void stop() {
        app.stop();
    }
}
