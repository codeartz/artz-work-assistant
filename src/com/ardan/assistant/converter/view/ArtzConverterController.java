/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardan.assistant.converter.view;

import com.ardan.assistant.util.ArtzConverterUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;


/**
 * Controller class for Artz Converter
 * 
 * @author A. Riswanto
 */
public class ArtzConverterController {   
    @FXML
    private RadioButton radioFilterHex;
    
    @FXML
    private RadioButton radioAsciiToHex;
    
    @FXML
    private RadioButton radioParseByte;
    
    @FXML
    private RadioButton radioParseWord;
    
    @FXML
    private RadioButton radioHexToAscii;
    
    @FXML
    private RadioButton radioHexToBinary;
    
    @FXML
    private RadioButton radioHexToDecimal;
    
    @FXML
    private ToggleGroup conversionGroup;
    
    @FXML
    private TextArea areaInput;
    
    @FXML
    private TextArea areaOutput;
    
    @FXML
    private Button btnInput;
    
    @FXML
    private Button btnClear;
    
    @FXML
    private Button btnOutput;
    
    @FXML
    private Button btnProcess;
    
    @FXML
    private Button btnUp;
    
    
    // Instantiate class ArtzConverterUtil
    ArtzConverterUtil utilConvert = new ArtzConverterUtil();
    
    
    /**
     * Method that will be executed first time when this controller is called
     */
    @FXML
    private void initialize() {       
////        areaInput.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
////            updateTextIOButton(btnInput, areaInput, "Paste INPUT:   ");
////        });
////        areaOutput.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
////            updateTextIOButton(btnOutput, areaOutput, "Copy Output:   ");
////        });
    }
    
    
    /**
     * Called when user clicks on the clear button.
     */
    @FXML
    private void handleClearButton() {
        areaInput.clear();
        areaOutput.clear();
        updateTextIOButton();
    }
    
    
    /**
     * Called when user clicks on the paste input button
     */
    @FXML
    private void handlePasteInputButton() {
        areaInput.clear();
        areaInput.paste();
        updateTextIOButton();
    }
    
    
    /**
     * Called when user clicks on the copy output button
     */
    @FXML
    private void handleCopyOutputButton() {
        areaOutput.selectAll();
        areaOutput.copy();
    }   
    
    
    /**
     * Called when user clicks on the process button
     */
    @FXML
    private void handleProcessButton() {
        String input, output = "";
        RadioButton selectedRadioButton;
        
        
        // get information from UI
        selectedRadioButton = (RadioButton) conversionGroup.getSelectedToggle();
        input = areaInput.getText();
        
        // dispatcher process
        switch (selectedRadioButton.getId()) {
            case "radioFilterHex":
                output = utilConvert.filterHex(input);
                break;
            case "radioAsciiToHex":
                output = utilConvert.asciiToHex(input);
                break;
            case "radioHexToAscii":
                output = utilConvert.hexToAscii(input);
                break;
            case "radioParseByte":
                output = utilConvert.parseByte(input, 2, ' ');
                break;
            case "radioParseWord":
                output = utilConvert.parseByte(input, 4, ' ');
                break;
            case "radioHexToBinary":
                output = utilConvert.hexToBinary(input);
                break;
            case "radioHexToDecimal":
                output = utilConvert.hexToDecimal(input);
                break;
        }
        
        // set output to UI
        areaOutput.setText(output);
        updateTextIOButton();
    }
    
    
    /**
     * Called when user clicks on the up button.
     */
    @FXML
    private void handleUpButton() {
        if (areaOutput.getText().length() > 0) {
            areaOutput.selectAll();
            areaOutput.copy();
            areaOutput.clear();
            areaInput.clear();
            areaInput.paste();
        } else {
            areaOutput.clear();
            areaInput.clear();
        }
        
        updateTextIOButton();
    }
    
    
    /**
     * Method to update button text in Artz converter
     * 
     * @param btn 
     *      button that will be updated
     */
    private void updateTextIOButton() {
        int lenText;
        
        lenText = areaInput.getLength();
        btnInput.setText(String.format(("Paste INPUT:   %d [H%02X] char;   %d [H%02X] byte"), 
                lenText, lenText, (lenText / 2), (lenText / 2)));
        lenText = areaOutput.getLength();
        btnOutput.setText(String.format(("Copy INPUT:   %d [H%02X] char;   %d [H%02X] byte"), 
                lenText, lenText, (lenText / 2), (lenText / 2)));
    }
    
}
