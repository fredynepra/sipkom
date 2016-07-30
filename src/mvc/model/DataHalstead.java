/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import mvc.view.MainUI;

/**
 *
 * @author Fredy Revolusioner
 */
public class DataHalstead {

    private MainUI ui;
    private final String hasilHasltead = "D:/UPDATE_SIDANG/SIPKOM/logHalstead.txt";
    private final File fileHasilHalstead = new File("D:/UPDATE_SIDANG/SIPKOM/logHalstead.txt");
    private boolean cekFileHV;

    public void readLogHalstead(MainUI ui) {
        try {
            FileReader hasilHV = new FileReader(hasilHasltead);
            try (BufferedReader br = new BufferedReader(hasilHV)) {
                ui.logArea().read(br, null);
            }
            ui.logArea().requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deleteLogHalstead() {
        fileHasilHalstead.delete();
    }

    public boolean getFileExistHV() {
        if (fileHasilHalstead.exists()) {
            return cekFileHV = true;
        } else {
            return cekFileHV = false;
        }
    }
}
