/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import mvc.model.UniqueOperand;
import mvc.model.UniqueOperator;
import mvc.model.Complexity;
import mvc.model.DataCyclomatic;
import mvc.model.DataHalstead;
import mvc.model.DataParsingCode;
import mvc.model.ASTParser;
import mvc.view.MainUI;

/**
 *
 * @author Fredy Revolusioner
 */
public class SystemControl {

    private final String tipeFile = ".java";
    private String eksFile = "";
    private boolean isValid;
    private String fileSourceCode;

    public SystemControl() {
    }

    public boolean getFileValid() {
        if (eksFile.contains(tipeFile)) {
            return isValid = true;
        } else {
            return isValid = false;
        }
    }

    public void hitungKompleksitas(MainUI ui, ASTParser astParser, DataParsingCode dataPC, UniqueOperator uOprt, UniqueOperand uOprn) throws FileNotFoundException, IOException, ParseException {
        //buka file di folder DataTesting
        JFileChooser pilihFile = new JFileChooser("E:/Semester 8/DataTesting");
        pilihFile.setMultiSelectionEnabled(true);
        pilihFile.showOpenDialog(null);
        File[] files = pilihFile.getSelectedFiles();
        for (File file : files) {
            fileSourceCode = file.getAbsolutePath();
            FileInputStream in = new FileInputStream(fileSourceCode);
            int i = fileSourceCode.lastIndexOf(".");
            eksFile = fileSourceCode.substring(i);
            CompilationUnit cu = null;
            try {
                if (getFileValid()) {
                    //parse file
                    cu = JavaParser.parse(in);
                    //hitung kompleksitas
                    new ASTParser.ClassName().visit(cu, null);
                    new Complexity(astParser, uOprt, uOprn).visit(cu, null);
                    //baca isi file parsingCode.txt
                    ui.showParsingCode(dataPC);
                } else {
                    JOptionPane.showMessageDialog(null, "File tidak valid, silahkan pilih file bertipe java.", "Peringatan!",
                            JOptionPane.WARNING_MESSAGE);
                    hitungKompleksitas(ui, astParser, dataPC, uOprt, uOprn);
                }
            } finally {
                in.close();
            }
        }
    }

    public void lihatHasilHalstead(MainUI ui, DataHalstead dataHV) throws IOException, FileNotFoundException, ParseException {
        if (dataHV.getFileExistHV()) {
            ui.showLogHalstead(dataHV);
        } else {
            JOptionPane.showMessageDialog(null, "File log Halstead’s Volume tidak ditemukan.", "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void lihatHasilCyclomatic(MainUI ui, DataCyclomatic dataCC) throws IOException, FileNotFoundException, ParseException {
        if (dataCC.getFileExistCC()) {
            ui.showLogCyclomatic(dataCC);
        } else {
            JOptionPane.showMessageDialog(null, "File log Cyclomatic Complexity tidak ditemukan.", "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void deleteLog(MainUI ui, DataHalstead dataHV, DataCyclomatic dataCC) throws IOException, FileNotFoundException, ParseException {
        if (dataHV.getFileExistHV() && dataCC.getFileExistCC()) {
            int opsiPilihan = JOptionPane.showConfirmDialog(null, "Anda yakin untuk menghapus log?", "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);
            if (opsiPilihan == JOptionPane.YES_OPTION) {
                dataHV.deleteLogHalstead();
                dataCC.deleteLogCyclomatic();
                ui.logArea().setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "File log tidak ditemukan.", "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
