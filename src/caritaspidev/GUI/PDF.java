/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.entityPublicite.actualite;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class PDF {
    public void pdf(actualite p) throws SQLException, FileNotFoundException, DocumentException, BadElementException, IOException {
        try {
            // System.out.println("Haouet------------------------------------->"+nom);

            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);

            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\asus\\Documents\\NetBeansProjects\\CaritasPiDev\\" + randomNum + ".pdf"));
            document.open();
             Image img=Image.getInstance(p.getImage());
             img.setWidthPercentage(20);
           Paragraph adrr = new Paragraph(new Phrase("l titre  : "+p.getTitre(), FontFactory.getFont(FontFactory.HELVETICA, 12)));
           Paragraph adrr1 = new Paragraph(new Phrase("l contenu  : "+p.getContenu(), FontFactory.getFont(FontFactory.HELVETICA, 12)));
             Paragraph par=new Paragraph(" votre actualite  ", FontFactory.getFont(FontFactory.TIMES));
             par.setAlignment(Element.ALIGN_CENTER);
            document.add(par);
             

             document.add(img);

             document.add(adrr);
              document.add(adrr1);
            document.add(new Paragraph("date dajout de l'actualite  : "+p.getDateajout(), FontFactory.getFont(FontFactory.TIMES)));
            document.add(new Paragraph("date modification de l l'actualite : "+p.getDatemodif(), FontFactory.getFont(FontFactory.TIMES)));

          
            document.close();
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
