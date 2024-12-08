package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс PropertyLoader отвечает за загрузку свойств из файла конфигурации.
 */
public class PropertyLoader {
    private static final String PROPERTIES_FILE = "config.properties";

    /**
     * Загружает свойства из файла конфигурации.
     *
     * @return загруженные свойства
     */
    public Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE);
                return properties;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
