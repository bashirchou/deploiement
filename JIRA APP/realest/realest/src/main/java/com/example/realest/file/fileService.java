package com.example.realest.file;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class fileService {
    private final fileRepository fileRepository;

    public ResponseEntity getFileById(Long file_id) throws ChangeSetPersister.NotFoundException {

        if (fileRepository.existsById(file_id)) {
            var file = fileRepository.findById(file_id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            return new ResponseEntity(file, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    public fileModel createFile() throws ChangeSetPersister.NotFoundException {
        fileModel fileModel = new fileModel();
        fileModel.setCreationDate("HAHAHAHAHA");
        fileRepository.saveAndFlush(fileModel);
        return fileModel;
    }
}
