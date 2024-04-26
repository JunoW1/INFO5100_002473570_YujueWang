package FinalProject.controller;

import FinalProject.dto.factory.BigimageFactory;
import FinalProject.dto.BigImage;
import FinalProject.dto.Thumbnail;
import FinalProject.main;
import com.drew.lang.StringUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private TextArea info;
    @FXML private ImageView previewImage;
    @FXML private ImageView thumbnailImage;
    @FXML private AnchorPane filter;
    @FXML private AnchorPane app;

    private Thumbnail thumbnail;
    private BigImage bigImage;

    @FXML
    public void close(){
        Platform.exit();
    }

    @FXML
    public void Github_link(){
        // Check the resource on Github
        String urlString = "https://github.com/JunoW1/INFO5100_002473570_YujueWang";
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("MainController::Github button clicked.");
    }

    @FXML
    public void addPicture(ActionEvent actionEvent) {
        // Create a new window that users are allowed to choose images from local
        Stage stage = (Stage) app.getScene().getWindow();
        //File selector only allowed picture format
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpeg","*.png", "*.jpg", "*.gif")
        );

        File file = fileChooser.showOpenDialog(stage);
        //Check if the image is valid or not
        if(file != null){
            String path = file.getAbsolutePath();
            //Create two class to store image values
            //bigImage: the bigger preview image that shows on the left side
            //thumbnail (original image): the smaller preview image that shows in the right top corner.
            filter.setVisible(false);
            previewImage.setEffect(null);
            previewImage.setRotate(0);
            //Setting image structure
            bigImage = BigimageFactory.getInstance(path);
            thumbnail = new Thumbnail(path);
            //Displaying both images on the frontend at the same time
            thumbnailImage.setImage(thumbnail.getImageView());
            previewImage.setImage(bigImage.getImageView());
            //get the information of image sim (bimg may be added some filter)
            getImageInfo(thumbnail);
            thumbnail.logThumbnailStatus();
            bigImage.logBigImageStatus();
        }
    }


    @FXML
    public void convertFormat(ActionEvent actionEvent) {
        if (bigImage != null){
            //Loading conformation page
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(main.class.getResource("format.fxml"));
            AnchorPane page = null;
            try {
                page = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage convertStage = new Stage();
            convertStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            convertStage.setScene(scene);
            FormatController controller = loader.getController();
            //Passing UI and class bigimage
            controller.setConvertStage(convertStage, bigImage);
            convertStage.showAndWait();
        }
        else{
            System.out.println("MainController::cannot convert image.");
        }
    }

    @FXML
    public void LeftRotate(ActionEvent actionEvent) {
        //Filter Function
        //Rotate left by 30 degree
        System.out.println("MainController::Left Rotate by 30.");
        bigImage.setRotate(-30);
        System.out.println(bigImage.getRotate());
        //real-time changing the preview at the frond-end
        previewImage.setRotate(previewImage.getRotate() - 30);
    }

    @FXML
    public void RightRotate(ActionEvent actionEvent) {
        //Filter Function
        //Rotate right by 30 degree
        System.out.println("MainController::Right Rotate by 30.");
        bigImage.setRotate(30);
        System.out.println(bigImage.getRotate());
        //real-time changing the preview at the frond-end
        previewImage.setRotate(previewImage.getRotate() + 30);
    }

    @FXML
    public void imageFilter(ActionEvent actionEvent){
        //Displaying the UI of Filter.
        if (bigImage != null) {
            filter.setVisible(!filter.isVisible());
        }
        else{
            System.out.println("MainController::cannot launch image filter.");
        }
    }


    public void getImageInfo(Thumbnail thumbnail){
        //To get the information of image that user select from image structure.

        StringBuilder imgInfo = new StringBuilder("");
        Map<String, String> imageData = thumbnail.getImageData();

        for (Map.Entry<String, String> info : imageData.entrySet()) {
            if (!imgInfo.toString().equals("")) {
                imgInfo.append("\n");
            }
            imgInfo.append(info.getKey());
            imgInfo.append(": ");
            imgInfo.append(info.getValue());
        }
        info.setText(imgInfo.toString());
        info.setWrapText(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filter.setVisible(false);
    }

    public void handleDesaturate(ActionEvent actionEvent) {
        System.out.println("MainController::handleDesaturate clicked");

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setSaturation(-1);

        previewImage.setEffect(colorAdjust);
        previewImage.setCache(true);
        previewImage.setCacheHint(CacheHint.SPEED);
        bigImage.setdesaturate(true);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Don't like it?");
        alert.setHeaderText(null);
        alert.setContentText("No worry! You can restore it!");
        alert.showAndWait();
    }

    public void handleRestore(ActionEvent actionEvent) {
        System.out.println("MainController::handleRestore clicked");

        if(bigImage.getDesaturate() || bigImage.getRotate() != 0){
            bigImage.setdesaturate(false);
            bigImage.resetRotate();

            previewImage.setEffect(null);
            previewImage.setRotate(0);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Restore done.");
            alert.setHeaderText(null);
            alert.setContentText("You have restored the photo.");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not a chance!");
            alert.setHeaderText(null);
            alert.setContentText("You have not make any changes on this photo yet!");
            alert.showAndWait();
        }
    }
}
