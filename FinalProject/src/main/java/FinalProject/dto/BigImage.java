package FinalProject.dto;

public class BigImage extends Image {
    //Class bigimage extends from its parent class - image_info
    //Contain the modifications of bigger image from the "Filter" functions

    private boolean desaturate = false;
    private int rotate = 0;

    public void setRotate(int n){
        rotate = rotate + n;
    }
    public void resetRotate(){
        rotate = 0;
    }
    public int getRotate(){
        return rotate;
    }
    public void setdesaturate(boolean x){
        this.desaturate = x;
    }
    public boolean getDesaturate(){
        return desaturate;
    }

    public void logBigImageStatus(){
        System.out.println("Rotate:"+ getRotate());
        System.out.println("Desaturate:"+ getDesaturate());
        System.out.println("_______________________________");
    }

    public BigImage(String Path) {
        super(Path);
    }
}