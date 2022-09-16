import ch.qos.logback.classic.util.StatusViaSLF4JLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;

public class Runner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int userId = 10;
        if (userId == 10){
            log.info("Пользователь успешно найден по id={}", userId);
        } else {
            log.warn("Пользователя не существует по id={}", userId);
        }

    }

    public static void readObject() throws IOException, ClassNotFoundException {
        Path path = Path.of("resources", "person.out");
//        writeObject(path);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Object object = inputStream.readObject();
        }

    }

    public static void writeObject(Path path) throws IOException {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            main.java.Person sergey = new main.java.Person("Sergey", 21);
            outputStream.writeObject(sergey);
        }

    }


}
