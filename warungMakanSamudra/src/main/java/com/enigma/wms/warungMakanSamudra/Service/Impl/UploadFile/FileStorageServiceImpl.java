package com.enigma.wms.warungMakanSamudra.Service.Impl.UploadFile;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageServiceImpl {

    private final Path fileStorageLocation = Paths.get("/home/user/BATCH14/LiveCodeWMS/warungMakanSamudra/src/main/java/com/enigma/wms/warungMakanSamudra/File");

    public FileStorageServiceImpl(){
        try {
            Files.createDirectories(this.fileStorageLocation);
        }catch(Exception e){
            throw new RuntimeException("could not create the  directory where the upload file to storage");

        }
    }

    public String storageFile(MultipartFile file){
        try {
            Path targertLocation = this.fileStorageLocation.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(),targertLocation , StandardCopyOption.REPLACE_EXISTING);

            return file.getOriginalFilename();
        }catch (IOException e){
            throw new RuntimeException("Could not Store " + file.getOriginalFilename() + " please check again" + e);
        }
    }


}
