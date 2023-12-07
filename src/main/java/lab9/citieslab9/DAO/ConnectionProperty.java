package lab9.citieslab9.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ConnectionProperty {

    public static final String CONFIG_NAME = "config.properties";
    public static final Properties PROPERTY_COFIG = new Properties();
    public ConnectionProperty() throws FileNotFoundException,
            IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        PROPERTY_COFIG.load(classLoader.getResourceAsStream(CONFIG_NAME));
    }
    // Получить значение параметра из конфигурации по имени свойства
    public static String getProperty(String property) {
        return PROPERTY_COFIG.getProperty(property);
    }
}