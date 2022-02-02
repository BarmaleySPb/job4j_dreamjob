package dream.utils;

import java.io.*;
import java.util.Properties;

public class GetProperties {

    public static Properties config(String fileName) {
        Properties config = new Properties();
        try {
        config.load(new FileReader("\\src\\main\\resources\\" + fileName));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
