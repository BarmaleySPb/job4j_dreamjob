package dream.utils;

import dream.store.DbStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class GetProperties {
    private static final Logger LOG = LoggerFactory.getLogger(DbStore.class.getName());

    public static Properties config(String fileName) {
        Properties config = new Properties();
        try {
        config.load(GetProperties.class.getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            LOG.error("Properties not loaded.", e);
        }
        return config;
    }
}
