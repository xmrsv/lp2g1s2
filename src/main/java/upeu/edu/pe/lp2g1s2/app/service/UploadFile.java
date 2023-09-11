package upeu.edu.pe.lp2g1s2.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

    private final String FOLDER = "images//";
    private final String IMG_DEFAULT = "default.jpg";

    public String upload(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            byte[] imageBytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, imageBytes);
            return multipartFile.getOriginalFilename();
        }

        return IMG_DEFAULT;
    }

    public void delete(String filename) {
        File file = new File(FOLDER + filename);
        file.delete();

    }
}
