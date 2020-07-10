package helpers;

import java.io.FileInputStream;
import java.util.Properties;

import lombok.SneakyThrows;

public class PropertiesFileReader {


    @SneakyThrows
    public static String getSystemPropertyByName(String var) {

        FileInputStream fis;
        Properties property = new Properties();

        fis = new FileInputStream("config.properties");
        property.load(fis);

        return property.getProperty(var);

    }
}
