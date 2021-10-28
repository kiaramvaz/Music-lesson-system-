/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lessonFormHandler;

/**
 *
 * @author KiaraVaz
 */
public class checkMethods
{
    //method to check if the entry has valid characters only and if its under 20 characters
 
    
    public int checkEntry(String entry){
        int status=0;
        int entryLength = entry.length();
        if(entryLength==0 || entryLength>20){
            status=1;
        }
        else{
            for(int i=0; i<entryLength; i++){
                if(!isLetterOrDigit(entry.charAt(i))){
                    status = 2;
                    break;
                
            }
            }
        }
        return status;
    }
    
    
    //Makes sure the characters are only letters or digits.
    public boolean isLetterOrDigit (char c){
        return (c >= 'a' && c<= 'z') ||
               (c >= 'A' && c<= 'Z') ||
               (c >= '0' && c<= '9');
    }
    
}
