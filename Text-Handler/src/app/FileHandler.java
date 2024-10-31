package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHandler {

    public String createFile(String path) {
        Path newFile = Paths.get(path);
        try {
            Files.createFile(newFile);
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        Path filePath = Paths.get(path);
        try {
            List<String> lines = Files.readAllLines(filePath);
            return String.join("\n", lines);
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }
}
