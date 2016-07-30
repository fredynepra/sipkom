/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Fredy Revolusioner
 */
public class Complexity extends VoidVisitorAdapter {

    private int CC = 0;
    private int totalOperator = 0;
    private int totalOperand = 0;
    private double V;
    private int N = 0, _n = 0;
    private String riskEv;

    private final ASTParser astParser;
    private final UniqueOperator uOprt;
    private final UniqueOperand uOprn;

    private String namaMethod;

    public Complexity(ASTParser astParser, UniqueOperator uOprt, UniqueOperand uOprn) {
        this.astParser = astParser;
        this.uOprt = uOprt;
        this.uOprn = uOprn;
    }

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        namaMethod = n.getName();
        System.out.println("Class " + astParser.getNamaClass());

        if (n.getBody() != null) {
            if (n.getParameters() != null) {
                System.out.println("Method " + n.getType() + " " + namaMethod + n.getParameters());
            } else {
                System.out.println("Method " + n.getType() + " " + namaMethod +"");
            }
            System.out.println(n.getBody());

            astParser.reset();
            astParser.visit(n, arg);

            totalOperand = 0;
            uOprn.resetTotalUnikOprn();

            totalOperator = 0;
            uOprt.resetTotalUnikOprt();

            System.out.println("\n- HITUNG HALSTEAD'S VOLUME -\n\nOperator:\n");
            uOprt.hitungUnikOprt(astParser.getUnikOprt());

            totalOperator = (astParser.getOperatorBinary() + astParser.getOperatorUnary() + astParser.getOperatorReturn() + astParser.getOperatorTypeData()
                    + astParser.getOperatorArray() + astParser.getOperatorAssign() + astParser.getOperatorFor() + astParser.getOperatorWhile() + astParser.getOperatorDoWhile()
                    + astParser.getOperatorIf() + astParser.getOperatorElse() + astParser.getOperatorSwitch() + astParser.getOperatorCase() + astParser.getOperatorTry()
                    + astParser.getOperatorCatch() + astParser.getOperatorFinally() + astParser.getOperatorBreak() + astParser.getOperatorMethodType() + astParser.getOperatorRefType());

            totalOperand = (astParser.getOperandNameExpr() + astParser.getOperandDec() + astParser.getOperandInteger() + astParser.getOperandDouble() + astParser.getOperandParameter()
                    + astParser.getOperandMethodName());
            N = totalOperator + totalOperand;

            System.out.println("\nTotal Operator (N1) : " + totalOperator);
            System.out.println("\n----------------------------");
            astParser.getUnikOprt().clear();

            System.out.println("\nOperand:\n");
            uOprn.hitungUnikOprn(astParser.getUnikOprn());
            System.out.println("\nTotal Operand (N2) : " + totalOperand);
            System.out.println("\n----------------------------");

            _n = uOprt.getTotalUnikOprt() + uOprn.getTotalUnikOprn();
            V = N * (Math.log10(_n) / Math.log10(2));

            System.out.println("\nV = " + N + " Log2(" + _n + ")");
            System.out.println("V = " + V + "\n");
            System.out.println("----------------------------------------------------------------");

            astParser.getUnikOprn().clear();

            CC = ((astParser.getConIf() + astParser.getConFor() + astParser.getConWhile() + astParser.getConDoWhile() + astParser.getOperatorSwitch()) + 1);

            System.out.println("\n- HITUNG CYCLOMATIC COMPLEXITY -\n\nPredicate Nodes:\n");
            System.out.print("if : " + astParser.getConIf() + " | for : " + astParser.getConFor() + " | While : " + astParser.getConWhile() + " | Do While : " + astParser.getConDoWhile()
                    + " | Switch : " + astParser.getOperatorSwitch());
            System.out.println("\n\nV(G) = P + 1");
            System.out.println("V(G) = " + (astParser.getConIf() + astParser.getConFor() + astParser.getConWhile() + astParser.getConDoWhile() + astParser.getOperatorSwitch()) + " + 1" + " = " + CC + "");
            System.out.println("\n----------------------------------------------------------------");
            riskEvaluation();
            saveLog();
        }
    }

    public void riskEvaluation() {
        if ((1 <= CC) && (CC <= 10)) {
            riskEv = "Bebas dari resiko.";
        } else if ((11 <= CC) && (CC <= 20)) {
            riskEv = "Memiliki resiko sedang.";
        } else if ((21 <= CC) && (CC <= 50)) {
            riskEv = "Memilik resiko tinggi.";
        } else {
            riskEv = "Sangat beresiko.";
        }
    }

    public void saveLog() {

        //Save log hasil CC
        String Class = "|===Class : " + astParser.getNamaClass() + "===|";
        String Method = "==Method : " + namaMethod + "";
        String data = "=Hasil Cyclomatic Complexity: " + CC + " | " + riskEv + "";
        String namaFile1 = "logCyclomatic";

        File logCC = new File("D:/UPDATE_SIDANG/SIPKOM/" + namaFile1 + ".txt");

        try (PrintWriter out = new PrintWriter(new FileWriter(logCC, true))) {
            out.append(Class).println();
            out.append(Method).println();
            out.append(data).println();
            out.append("---------------------------------------------------------------");
            out.append(System.lineSeparator());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan log CC.");
        }

        //Save log hasil HV    
        String Class2 = "|===Class : " + astParser.getNamaClass() + "===|";
        String Method2 = "==Method : " + namaMethod + "";
        String data2 = "=Hasil Halstead's Volume : " + V + "";
        String namaFile2 = "logHalstead";

        File logHV = new File("D:/UPDATE_SIDANG/SIPKOM/" + namaFile2 + ".txt");

        try (PrintWriter out = new PrintWriter(new FileWriter(logHV, true))) {
            out.append(Class2).println();
            out.append(Method2).println();
            out.append(data2).println();
            out.append("---------------------------------------------------------------");
            out.append(System.lineSeparator());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan log HV.");
        }
    }
}
