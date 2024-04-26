package FinalProject.dto;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Thumbnail extends Image {
    //Class thumbnail extends from its parent class - image_info
    //Contain the description of image itself
    private String thumbnailPath;
    //Map<String,String> data stores Metadata from ImageMetadataReader
    //Image Size, Location... will be in the Map<String,String> data
    private Map<String,String> imageData;

    public Map<String, String> readData() {
        Map<String,String> data = new HashMap<>();
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(new File(thumbnailPath));
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    data.put(tag.getTagName(), tag.getDescription());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, String> getImageData(){
        return imageData;
    }

    public void logThumbnailStatus(){
        System.out.println("New Image");
        System.out.println(getPath());
        System.out.println(getFilenameExtension());
        System.out.println(getFilename());
        System.out.println(getCurrentFormat());
    }
    public Thumbnail(String Path) {
        super(Path);
        this.thumbnailPath = getPath();
        this.imageData = readData();
    }
}
