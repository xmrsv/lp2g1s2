package upeu.edu.pe.lp2g1s2.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

    // Ruta donde se guardarán las imágenes
    private final String FOLDER = "images//";

    // Nombre de la imagen por defecto si no se proporciona una
    private final String IMG_DEFAULT = "default.jpg";

    /**
     * Carga un archivo (imagen) al sistema de archivos.
     *
     * @param multipartFile Archivo (imagen) a cargar.
     * @return El nombre del archivo cargado.
     * @throws IOException Si ocurre un error durante la carga del archivo.
     */
    public String upload(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            byte[] imageBytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, imageBytes);
            return multipartFile.getOriginalFilename();
        }
        return IMG_DEFAULT; // Si el archivo está vacío, se devuelve la imagen por defecto.
    }

    /**
     * Elimina un archivo (imagen) del sistema de archivos.
     *
     * @param filename Nombre del archivo (imagen) a eliminar.
     */
    public void delete(String filename) {
        File file = new File(FOLDER + filename);
        file.delete();
    }
}
