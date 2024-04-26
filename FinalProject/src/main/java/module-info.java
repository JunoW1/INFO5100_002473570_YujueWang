module FinalProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javaxt.core;
    requires metadata.extractor;

    opens FinalProject to javafx.fxml;
    exports FinalProject;
    exports FinalProject.dto;
    opens FinalProject.dto to javafx.fxml;
    exports FinalProject.controller;
    opens FinalProject.controller to javafx.fxml;
    exports FinalProject.dto.factory;
    opens FinalProject.dto.factory to javafx.fxml;
}