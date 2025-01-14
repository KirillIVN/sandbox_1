package kz.topmail.metrika;

import java.io.File;

public class HelloJava {
    public static void main(String[] args) {
        var configFile = new File("sandbox_new/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());

        System.out.println(new File("").getAbsolutePath());
    }
}
