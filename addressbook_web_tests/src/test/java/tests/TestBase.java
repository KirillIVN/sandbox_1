package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "chrome"));
    }

    public static String randomFile(String dir) {
        var fileName = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileName.length);
        return Paths.get(dir, fileName[index]).toString();
    }
}
