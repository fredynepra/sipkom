/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import mvc.view.MainUI;

/**
 *
 * @author Fredy Revolusioner
 */
public class DataParsingCode {

    private MainUI view;
    private final String fileParsingCode = "D:/UPDATE_SIDANG/SIPKOM/parsingCode.txt";

    public void readParsingCode(MainUI view) {
        try {
            FileReader hasilPC = new FileReader(fileParsingCode);
            try (BufferedReader br = new BufferedReader(hasilPC)) {
                view.logArea().read(br, null);
            }
            view.logArea().requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal membaca log parsing code.");
        }
    }
}
