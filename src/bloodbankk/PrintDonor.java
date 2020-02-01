/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import java.awt.print.Printable;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import javax.swing.*;

/**
 *
 * @author ayush
 */
public class PrintDonor implements Printable {
     public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        g.drawString("Hello world!", 100, 100);
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
}
