package org.example;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс Injector отвечает за инъекцию зависимостей в объекты,
 * помеченные аннотацией {@link AutoInjectable}.
 */
public class Injector {
    private Properties properties;

    /**
     * Конструктор, который загружает свойства из файла конфигурации.
     */
    public Injector() {
        PropertyLoader propertyLoader = new PropertyLoader();
        this.properties = propertyLoader.loadProperties();
    }

    /**
     * Метод для инъекции зависимостей в указанный объект.
     *
     * @param object объект, в который будут инъектированы зависимости
     * @param <T> тип объекта
     * @return тот же объект с инъектированными зависимостями
     */
    public <T> T inject(T object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                Class<?> fieldType = field.getType();
                String implementationClassName = properties.getProperty(fieldType.getName());
                try {
                    Class<?> implementationClass = Class.forName(implementationClassName);
                    Object instance = implementationClass.getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(object, instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
