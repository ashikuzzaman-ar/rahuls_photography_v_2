package com.studevs.utils;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author ashik
 */
public class EncodedByteToString {
    
    private byte[] byteImage ;
    private String stringImage ;

    public String getStringImage(byte[] byteImage) {
        
        this.stringImage = null;
        this.byteImage = null;
        this.byteImage = byteImage;
        
        try {
            
            if(byteImage.length>0){
                
                this.stringImage = new String(Base64.encodeBase64(this.byteImage), "UTF-8");
            }
        } catch (Exception e) {
            
            throw new ExceptionInInitializerError(e);
        }
        
        return this.stringImage;
    }
}
