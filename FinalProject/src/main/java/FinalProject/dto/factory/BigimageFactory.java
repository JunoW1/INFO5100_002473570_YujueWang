package FinalProject.dto.factory;

import FinalProject.dto.BigImage;

public class BigimageFactory {

    public static BigImage getInstance(String path){
        return new BigImage(path);
    }

}
