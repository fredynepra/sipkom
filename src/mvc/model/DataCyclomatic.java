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
public class DataCyclomatic {

    private MainUI ui;
    private final String hasilCyclomatic = "D:/UPDATE_SIDANG/SIPKOM/logCyclomatic.txt";
    private final File fileLogCyclomatic = new File("D:/UPDATE_SIDANG/SIPKOM/logCyclomatic.txt");
    private boolean cekFileCC;

    public void readLogCyclomatic(MainUI ui) {
        try {
            FileReader hasilCC = new FileReader(hasilCyclomatic);
            try (BufferedReader br = new BufferedReader(hasilCC)) {
                ui.logArea().read(br, null);
            }
            ui.logArea().requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal membaca log parsing code.");
        }
    }

    public void deleteLogCyclomatic() {
        fileLogCyclomatic.delete();
    }

    public boolean getFileExistCC() {
        return cekFileCC = this.fileLogCyclomatic.exists();
    }

}
