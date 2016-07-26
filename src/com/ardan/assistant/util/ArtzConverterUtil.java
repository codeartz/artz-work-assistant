/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardan.assistant.util;

/**
 * Class that has Util methods for Artz converter assistant
 * 
 * @author A. Riswanto
 */
public class ArtzConverterUtil {
    
    /**
     * Method to remove non-hexadecimal character
     *
     * @param input string that will be filtered
     * @return filter result
     */
    public String filterHex(String input) {
        return input.replaceAll("[^a-fA-F0-9]", "").toUpperCase();
    }
    
    
    /**
     * Method to convert ASCII character into hexadecimal representation
     *
     * @param input string in ASCII format that will be converted
     * @return conversion result
     */
    public String asciiToHex(String input) {
        char[] chars;
        StringBuilder hexString = new StringBuilder();
        
        chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hexString.append(Integer.toHexString((int) chars[i]));
        }
        
        return hexString.toString().toUpperCase();
    }
    
    
    /**
     * Method to convert hexadecimal sequence into ASCII character
     *
     * @param input string with format hexadecimal sequences
     * @return string that consists of ASCII characters
     */
    public String hexToAscii(String input) {
        String str;
        StringBuilder asciiString = new StringBuilder("");
        
        input = filterHex(input);
        for (int i = 0; i < input.length(); i += 2) {
            str = input.substring(i, (i + 2));
            asciiString.append((char) Integer.parseInt(str, 16));
        }
        
        return asciiString.toString();
    }
    
    
    /**
     * Method to parse String hexadecimal every given number of byte with
     * specific separator
     *
     * @param input String that will be parsed
     * @param nByte number of byte every parse
     * @param separator separator that used to parse byte
     * @return parsed String
     */
    public String parseByte(String input, int nByte, char separator) {
        int nSpace = 0;             // number of added space 
        StringBuilder outString;    // String to store output
        
        input = filterHex(input);
        outString = new StringBuilder(input);

        // insert space in String
        for (int idx = nByte; idx < input.length(); idx += (nByte / 2)) {
            outString.insert((idx + nSpace++), separator);
        }
        
        return outString.toString();
    }
    
    
    /**
     * Method to convert hexadecimal sequence into Binary representation
     *
     * @param input string with format hexadecimal sequences
     * @return input string in Binary format
     */
    public String hexToBinary(String input) {
        String str;
        StringBuilder binString = new StringBuilder("");
        
        input = filterHex(input);
        for (int i = 0; i < input.length(); i++) {
            str = input.substring(i, (i+1));    // get substring in 'i' position
            str = String.format("%4s", Integer.toBinaryString(Integer.parseInt(str, 16))).replace(" ", "0");
            binString.append(str);
        }
        return binString.toString();
    }
    
    
    /**
     * Method to convert hexadecimal sequence into Decimal representation
     * 
     * @param input string that consist of hexadecimal sequences
     * @return input string in decimal sequences
     */
    public String hexToDecimal(String input) {
        char processChar;
        long decValue = 0;
        String digit = "0123456789ABCDEF";
        
        input = filterHex(input);
        for (int i = 0; i < input.length(); i++) {
            processChar = input.charAt(i);
            decValue = 16 * decValue + digit.indexOf(processChar);
        }
        return String.valueOf(decValue);
    }
    
}   // end of class
