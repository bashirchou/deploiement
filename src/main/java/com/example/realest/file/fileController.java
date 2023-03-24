package com.example.realest.file;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fileController {

    @Autowired
    private final fileRepository fileRepository;
    @Autowired
    private final fileService fileService;

    public fileController(fileRepository file,fileService service) {
        this.fileRepository = file;
        this.fileService = service;
    }

    @PostMapping("/all")
    public fileModel labib() throws ChangeSetPersister.NotFoundException {
        return this.fileService.createFile();
    }
}
