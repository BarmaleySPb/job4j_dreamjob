package dream.utils;

import java.util.Properties;


public class GetProperties {

    public static Properties config(String fileName) {
        Properties config = new Properties();
        try {
        config.load(GetProperties.class.getClassLoader().getResourceAsStream(fileName)
        );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
