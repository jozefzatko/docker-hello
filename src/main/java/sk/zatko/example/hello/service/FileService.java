package sk.zatko.example.hello.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Value("${folder.path}")
    private String folderPath;

    public String createFile() {
        String fileName = UUID.randomUUID().toString() + ".txt";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }

        try (FileOutputStream out = new FileOutputStream(folderPath + "//" + fileName)) {
            out.write("something".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public List<String> getFiles() {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            return new ArrayList<>();
        }

        List<String> filenames = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
            paths.filter(Files::isRegularFile).forEach(file ->
                    filenames.add(file.getFileName().toString())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filenames;
    }
}
