package az.developia.bookshopping.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public String store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        String randomFileName = "";

        // Add check to ensure filename contains a file extension
        if (filename.lastIndexOf(".") == -1) {
            throw new StorageException("File has no extension: " + filename);
        }

        try {
            try (InputStream inputStream = file.getInputStream()) {
                String originalFileName = file.getOriginalFilename();
                UUID uuid = UUID.randomUUID();
                randomFileName = originalFileName
                        .replace(originalFileName.substring(0, originalFileName.lastIndexOf(".")),
                                uuid.toString());
                Files.copy(inputStream, this.rootLocation.resolve(randomFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Fayl yadda saxlana bilmədi: + filename", e);
        }
        return randomFileName;
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Fayl oxuna bilmədi:" + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Fayl oxuna bilmədi: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
    }

}

