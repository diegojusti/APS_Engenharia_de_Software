/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Diego Justi
 */
public class InputVerifier {
    
    ValidaCpfCnpj vcc = new ValidaCpfCnpj();
    
    /*
    public static final int TEXT = 0;
    public static final int INTEGER_POSITIVE = 1;
    public static final int FLOATING_POSITIVE = 2;
    */
    
    public boolean isPhoneNumberValid(String text){
        if(isIntegerPositiveValid(text)){
            for(int i = 0; i < text.length(); i++){
                if(!Character.isDigit(text.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }
    
    public boolean isCpfCnpjValid(String text){
        return vcc.isValidDocConverter(text);
    }
    
    public boolean isTextValid(String text){
        return (text.length() > 0 && text.length() < 150);
    }
    
    public boolean isIntegerPositiveValid(String text){
        try{
            int n = Integer.parseInt(removeMask(text));
            return n >= 0;
        }
        catch(NumberFormatException e){
            return false;
        }               
    }
    
    public boolean isFloatingPositiveValid(String text){
        try{
            float n = Float.parseFloat(removeMask(text));
            return n >= 0;
        }
        catch(NumberFormatException e){
            return false;
        }  
    }
    
    public String removeMask(String text){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i< text.length(); i++){
            if(Character.isDigit(text.charAt(i)))
                sb.append(text.charAt(i));
        }
        return sb.toString();
    }
    
}
