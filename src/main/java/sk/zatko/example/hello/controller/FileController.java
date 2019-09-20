package sk.zatko.example.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.zatko.example.hello.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

    public FileController(@Autowired FileService fileService) {
        this.fileService = fileService;
    }

    private FileService fileService;

    @GetMapping("/get")
    public List<String> getFiles() {
        return fileService.getFiles();
    }

    @GetMapping("/add")
    public String createFile() {
        return fileService.createFile();
    }
}
