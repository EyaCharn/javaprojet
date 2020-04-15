/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.entity.emploi.emploi;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.commons.io.output.ByteArrayOutputStream;



public class QRCodeGenerator {


    public static void qrcode (emploi e) throws FileNotFoundException, IOException
    {
        String details ="https://www.tanitjobs.com/jobs/?searchID=1561785459.8994&action=search&page=1";
        java.io.ByteArrayOutputStream out = QRCode.from(details).to(ImageType.PNG).stream();
        
        File f =new File ("C:\\Users\\EYA\\Pictures\\A_text,_your_name,_a_number_or_anything..._;)_as_QRcode.png");
        FileOutputStream fos = new FileOutputStream(f);
        
        fos.write(out.toByteArray());
        fos.flush();
    }
}
        
    
