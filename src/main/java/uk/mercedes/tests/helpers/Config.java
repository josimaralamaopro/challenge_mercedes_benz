package uk.mercedes.tests.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Manage the config file "config.properties";
 */
public class Config {

    public Properties properties;

    public Config(){
        try (InputStream input = getConfigFile()) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static InputStream getConfigFile() {
        return Config.class.getClassLoader().getResourceAsStream("config.properties");
    }
}
