package upeu.edu.pe.lp2g1s2.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

    private final String IMAGE_FOLDER_CONTAINER = "images//";
    private final String DEFAULT_IMAGE = "default.jpg";

    public String upload(MultipartFile multipartFile) {
        String filename = DEFAULT_IMAGE;

        if (multipartFile != null && !multipartFile.isEmpty()) {
            // Validación de datos: verifica que el archivo sea una imagen
            if (!multipartFile.getContentType().startsWith("image/")) {
                throw new IllegalArgumentException("El archivo debe ser una imagen");
            }

            try {
                byte[] imageBytes = multipartFile.getBytes();
                Path path = Paths.get(IMAGE_FOLDER_CONTAINER + multipartFile.getOriginalFilename());

                // Manejo de recursos: verifica si el directorio existe. Si no existe, lo crea.
                if (!Files.exists(path.getParent())) {
                    Files.createDirectories(path.getParent());
                }

                Files.write(path, imageBytes);
                filename = multipartFile.getOriginalFilename();
            } catch (IOException e) {
                // Manejo de excepciones: registra la excepción y lanza una nueva excepción
                System.err.println("Error al guardar la imagen: " + e.getMessage());
                throw new RuntimeException("No se pudo guardar la imagen", e);
            }
        }

        return filename;
    }

    public void delete(String filename) {
        File file = new File(IMAGE_FOLDER_CONTAINER + filename);

        // Seguridad: verifica que el archivo a eliminar esté dentro del directorio de imágenes
        if (!file.toPath().normalize().startsWith(Paths.get(IMAGE_FOLDER_CONTAINER).normalize())) {
            throw new SecurityException("No se puede eliminar archivos fuera del directorio de imágenes");
        }

        if (file.exists()) {
            file.delete();
        }
    }
}
