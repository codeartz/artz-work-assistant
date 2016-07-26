/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardan.assistant;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * My personal work assistant
 * 
 * @author A. Riswanto
 * @version 0.0.1, 21 July 2016
 */
public class ArtzAssistant extends Application {
    private Stage primaryStage;
    private BorderPane artzRootLayout;
    private AnchorPane artzConverter;
    
    
    @Override
    public void start(Stage primaryStage) {       
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Artz Work Assistant");
        
        initArtzRootLayout();
        showArtzConverter();
    }
    
    
    /**
     * Initialize application root layout
     */
    public void initArtzRootLayout() {
        try {
            // load Artz root layout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ArtzAssistant.class.getResource("converter/view/ArtzRootLayout.fxml"));
            artzRootLayout = (BorderPane) loader.load();
            
            // set scene Artz root layout in primary stage
            Scene scene = new Scene(artzRootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            Logger.getLogger(ArtzAssistant.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    /**
     * Show and display Artz converter inside Artz root layout
     */
    public void showArtzConverter() {
        try {
            // load Artz converter window
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ArtzAssistant.class.getResource("converter/view/ArtzConverter.fxml"));
            artzConverter = (AnchorPane) loader.load();
            
            // set Artz converter to center of Artz root layout
            artzRootLayout.setCenter(artzConverter);
        } catch (IOException e) {
            Logger.getLogger(ArtzAssistant.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
