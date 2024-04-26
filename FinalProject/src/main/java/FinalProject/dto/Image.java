package FinalProject.dto;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Image {
    //The data structure of image
    //Parent Class to store basic information of image
    private String path;
    private String filenameExtension;
    private String filename;
    private String currentFormat;
    private javaxt.io.Image image;
    private javafx.scene.image.Image imageView;

    public Integer getHeight(){
        return image.getHeight();
    }
    public Integer getWidth(){
        return image.getWidth();
    }
    public String getPath(){
        return path;
    }
    public String getFilenameExtension(){
        return filenameExtension;
    }
    public String getFilename(){
        return filename;
    }
    public String getCurrentFormat(){ return currentFormat; }
    public javaxt.io.Image getImage(){
        return image;
    }
    public javafx.scene.image.Image getImageView(){
        return imageView;
    }

    public Image(String filePath){
        try {
            File img = new File(filePath);
            InputStream isImage = new FileInputStream(img);
            this.imageView = new javafx.scene.image.Image(isImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(filePath);
        Path fileName = path.getFileName();
        this.path = path.toString();
        this.image = new javaxt.io.Image(filePath);
        this.filenameExtension = fileName.toString();
        int index = fileName.toString().lastIndexOf('.');
        if(index > 0) {
            String extension = fileName.toString().substring(index + 1);
            this.currentFormat = extension;
        }
        this.filename = generateFileName(fileName);
    }

    private String generateFileName(Path fileName) {
        return fileName.toString()
                .substring(0, fileName.toString().length() - this.currentFormat.length() - 1);
    }
}

