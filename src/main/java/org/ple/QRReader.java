package org.ple;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by MooMoo on 22/09/15.
 */
public class QRReader {


        public static void main(String[] args) throws WriterException, IOException,
                NotFoundException {
            String filePath = "/Users/MooMoo/Desktop/IndianRailways/src/main/resources/qrcode.jpeg";
            String charset = "ISO-8859-1"; // or "ISO-8859-1"
            Map hintMap = new HashMap();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

                        System.out.println("Data read from QR Code: "
                                + readQRCode(filePath, charset, hintMap));

        }


        public static String readQRCode(String filePath, String charset, Map hintMap)
                throws FileNotFoundException, IOException, NotFoundException {
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(
                            ImageIO.read(new FileInputStream(filePath)))));
            Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
                    hintMap);
            return qrCodeResult.getText();
        }
    }

