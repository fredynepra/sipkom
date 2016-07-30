/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.AnnotationExpr;
import japa.parser.ast.expr.ArrayAccessExpr;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.BinaryExpr;
import japa.parser.ast.expr.DoubleLiteralExpr;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.IntegerLiteralExpr;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.StringLiteralExpr;
import japa.parser.ast.expr.UnaryExpr;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.stmt.BreakStmt;
import japa.parser.ast.stmt.CatchClause;
import japa.parser.ast.stmt.DoStmt;
import japa.parser.ast.stmt.ForStmt;
import japa.parser.ast.stmt.ForeachStmt;
import japa.parser.ast.stmt.IfStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.stmt.SwitchEntryStmt;
import japa.parser.ast.stmt.SwitchStmt;
import japa.parser.ast.stmt.TryStmt;
import japa.parser.ast.stmt.WhileStmt;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.Type;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fredy Revolusioner
 */
public class ASTParser extends VoidVisitorAdapter {

    private int conFor, ifKon, conIf;
    private int ifElse, ifStmt, conWhile, conDoWhile;
    private int cOperatorFor, cOperatorWhile, cOperatorDoWhile, cOperatorIf,
    cOperatorElse, cOperatorAssign, cOperatorArray, cOperatorReturn,
    cOperatorBinary, cOperatorUnary, cOperatorTypeData, cOperatorSwitch,
    cOperatorCase, cOperatorBreak, cOperatorTry, cOperatorCatch,
    cOperatorFinally, cOperandNameExpr, cOperandDouble, cOperandInteger,
    cOperandParameter, cOperandDec, cOperatorMethodType, cOperandMethodName,
    cOperatorReferenceType;

    private List<String> unikOprt;
    private List<String> unikOprn;
    
    private static String namaClass;

    public ASTParser() {
        this.unikOprt = new ArrayList<>();
        this.unikOprn = new ArrayList<>();
    }

    private void setUnikOprn(String unik) {
        this.unikOprn.add(unik);
    }

    private void setUnikOprt(String unik) {
        this.unikOprt.add(unik);
    }

    public List<String> getUnikOprt() {
        return this.unikOprt;
    }

    public List<String> getUnikOprn() {
        return this.unikOprn;
    }

    public void reset() {
        this.conFor = 0;
        this.conIf = 0;
        this.conWhile = 0;
        this.conDoWhile = 0;
        this.cOperatorFor = 0;
        this.cOperatorWhile = 0;
        this.cOperatorDoWhile = 0;
        this.cOperatorIf = 0;
        this.cOperatorElse = 0;
        this.cOperatorAssign = 0;
        this.cOperatorArray = 0;
        this.cOperatorReturn = 0;
        this.cOperatorBinary = 0;
        this.cOperatorUnary = 0;
        this.cOperatorTypeData = 0;
        this.cOperatorSwitch = 0;
        this.cOperatorCase = 0;
        this.cOperatorBreak = 0;
        this.cOperatorTry = 0;
        this.cOperatorCatch = 0;
        this.cOperatorFinally = 0;
        this.cOperandNameExpr = 0;
        this.cOperandDouble = 0;
        this.cOperandInteger = 0;
        this.cOperandParameter = 0;
        this.cOperandDec = 0;
        this.cOperatorMethodType = 0;
        this.cOperandMethodName = 0;
        this.cOperatorReferenceType = 0;
    }

    private void setConIf(int conIf) {
        this.conIf = conIf;
    }

    private void setOperatorIf(int cOperatorIf) {
        this.cOperatorIf = cOperatorIf;
    }

    @Override
    public void visit(ReferenceType n, Object arg) {
        n.getType().accept(this, arg);
        if (n.getType().toString().contains("String")) {
            setUnikOprt(n.getType().toString());
            this.cOperatorReferenceType++;
        }
    }

    public int getOperatorRefType() {
        return this.cOperatorReferenceType;
    }

    @Override
    public void visit(IfStmt n, Object arg) {
        int i = 0;
        String kondisi, AND = "&&";
        int JUMLAH_KARAKTER = 256;
        int[] total_per_karakter = new int[JUMLAH_KARAKTER];
    
        cyclomaticIf(n);
        n.getCondition().accept(this, arg);
        n.getThenStmt().accept(this, arg);
        if (n.getElseStmt() == null) {
            //n.getElseStmt().accept(this, arg);
        } else {
            n.getElseStmt().accept(this, arg);
            setUnikOprt("else");
            setOperatorElse(getOperatorElse() + 1);
        }
        String cekKonBert = n.getThenStmt().toString();
        if (cekKonBert != null && cekKonBert.contains("if")) {
            int uk = 0;
            for (int j = 1; j <= "if".length(); j++) {
                uk++;
            }
            int jml_if = 0;
            for (int k = 0; k <= cekKonBert.length() - uk; k++) {
                if ("if".equals(cekKonBert.substring(k, k + uk))) {
                    jml_if++;
                    //setConIf(getConIf()+1);
                }
            }
            i = i + jml_if;
            //setConIf(io.getConIf()+1);
        }

        kondisi = n.getCondition().toString();
        boolean IfStmtAND = kondisi.contains(AND);

        //inisialisasikan setiap karakter berjumlah 0 buah
        for (int j = 0; j < JUMLAH_KARAKTER; j++) {
            total_per_karakter[j] = 0;
        }
        //hitung jumlah setiap karakter
        int kondisi_len = kondisi.length();
        for (int k = 0; k < kondisi_len; k++) {
            total_per_karakter[(int) kondisi.charAt(k)]++;
        }

        //hitung banyak kondisi if
        if (n.getCondition() != null && IfStmtAND) {
            //n.getCondition().accept(this, arg);

            for (int j = 0; j < JUMLAH_KARAKTER; j++) {
                if (total_per_karakter['&'] > 0) {
                    if (((char) j == '&')) {
                        if(ifElse != 0) {
                        setConIf((ifElse) + ((total_per_karakter['&'] / 2)));    
                        }
                        else {
                        setConIf(1 + ((total_per_karakter['&'] / 2)));    
                        }
                        ifKon++;
                        setUnikOprt("if");
                        setOperatorIf(getOperatorIf() + 1);
                    }
                }
            }

        } else {
            //n.getCondition().accept(this, arg);
            setConIf(getConIf() + 1);
            ifKon = 0;
            ifStmt++;
            setUnikOprt("if");
            setOperatorIf(getOperatorIf() + 1);
        }

    }

    private void cyclomaticIf(IfStmt n) {
            // one for the if-then
        //i++;
        Statement elseStmt = n.getElseStmt();
        if (elseStmt != null) {
            if (IfStmt.class.isAssignableFrom(elseStmt.getClass())) {
                cyclomaticIf((IfStmt) elseStmt);
                ifElse++;
            } else {
                //i++;    
            }
        }
    }

    public int getConIf() {
        return this.conIf;
    }

    public int getOperatorIf() {
        return this.cOperatorIf;
    }

    public void setOperatorElse(int cOperatorElse) {
        this.cOperatorElse = cOperatorElse;
    }

    public int getOperatorElse() {
        return this.cOperatorElse;
    }

    @Override
    public void visit(ForeachStmt n, Object arg) {
        n.getVariable().accept(this, arg);
        n.getIterable().accept(this, arg);
        n.getBody().accept(this, arg);
        conFor++;
        cOperatorFor++;
        setUnikOprt("for");
    }

    @Override
    public void visit(ForStmt n, Object arg) {
        for (Expression e : n.getInit()) {
            for (Expression e2 : n.getUpdate()) {
                e.accept(this, arg);
                e2.accept(this, arg);
                n.getCompare().accept(this, arg);
                conFor++;
                setUnikOprt("for");
                cOperatorFor++;
            }
        }
        n.getBody().accept(this, arg);
    }

    public int getConFor() {
        ifElse = 0;
        return this.conFor;
    }

    public int getOperatorFor() {
        return this.cOperatorFor;
    }

    private void setConDoWhile(int conDoWhile) {
        this.conDoWhile = conDoWhile;
    }

    @Override
    public void visit(DoStmt n, Object arg) {
        String kondisi, AND = "&&";
        int JUMLAH_KARAKTER = 256;
        int[] total_per_karakter = new int[JUMLAH_KARAKTER];
        
        n.getBody().accept(this, arg);

        kondisi = n.getCondition().toString();
        boolean DoWhileStmtAND = kondisi.contains(AND);

        //inisialisasikan setiap karakter berjumlah 0 buah
        for (int i = 0; i < JUMLAH_KARAKTER; i++) {
            total_per_karakter[i] = 0;
        }
        //hitung jumlah setiap karakter
        int kondisi_len = kondisi.length();
        for (int i = 0; i < kondisi_len; i++) {
            total_per_karakter[(int) kondisi.charAt(i)]++;
        }

        n.getCondition().accept(this, arg);

        //hitung banyak kondisi do while
        if (n.getCondition() != null && DoWhileStmtAND) {
            //n.getCondition().accept(this, arg);
            for (int i = 0; i < JUMLAH_KARAKTER; i++) {
                if (total_per_karakter['&'] > 0) {
                    if (((char) i == '&')) {
                        setConDoWhile(getConDoWhile() + ((total_per_karakter['&'] / 2) + 1));
                        setUnikOprt("do while");
                        cOperatorDoWhile++;
                    }
                }
            }
        } else {
            //n.getCondition().accept(this, arg);
            setConDoWhile(getConDoWhile() + 1);
            setUnikOprt("do while");
            cOperatorDoWhile++;
        }
    }

    public int getConDoWhile() {
        return this.conDoWhile;
    }

    public int getOperatorDoWhile() {
        return this.cOperatorDoWhile;
    }

    private void setConWhile(int conWhile) {
        this.conWhile = conWhile;
    }

    @Override
    public void visit(WhileStmt n, Object arg) {
        String kondisi, AND = "&&";
        int JUMLAH_KARAKTER = 256;
        int[] total_per_karakter = new int[JUMLAH_KARAKTER];
        
        n.getBody().accept(this, arg);

        kondisi = n.getCondition().toString();
        boolean WhileStmtAND = kondisi.contains(AND);

        //inisialisasikan setiap karakter berjumlah 0 buah
        for (int i = 0; i < JUMLAH_KARAKTER; i++) {
            total_per_karakter[i] = 0;
        }
        //hitung jumlah setiap karakter
        int kondisi_len = kondisi.length();
        for (int i = 0; i < kondisi_len; i++) {
            total_per_karakter[(int) kondisi.charAt(i)]++;
        }
        n.getCondition().accept(this, arg);

        //hitung banyak kondisi do while
        if (n.getCondition() != null && WhileStmtAND) {
            //n.getCondition().accept(this, arg);
            for (int i = 0; i < JUMLAH_KARAKTER; i++) {
                if (total_per_karakter['&'] > 0) {
                    if (((char) i == '&')) {
                        setConWhile(getConWhile() + ((total_per_karakter['&'] / 2) + 1));
                        setUnikOprt("while");
                        cOperatorWhile++;
                    }
                }
            }
        } else {
            //n.getCondition().accept(this, arg);
            setConWhile(getConWhile() + 1);
            setUnikOprt("while");
            cOperatorWhile++;
        }
    }

    public int getConWhile() {
        return this.conWhile;
    }

    public int getOperatorWhile() {
        return this.cOperatorWhile;
    }

    @Override
    public void visit(AssignExpr n, Object arg) {
        n.getTarget().accept(this, arg);
        n.getValue().accept(this, arg);
        setUnikOprt("Assignment:" + n.getOperator().toString());
        cOperatorAssign++;
    }

    @Override
    public void visit(VariableDeclarator n, Object arg) {
        n.getId().accept(this, arg);
        if (n.getInit() != null) {
            n.getInit().accept(this, arg);
            setUnikOprt("Assignment:assign");
            cOperatorAssign++;
        }
    }

    public int getOperatorAssign() {
        return this.cOperatorAssign;
    }

    @Override
    public void visit(ArrayAccessExpr n, Object arg) {
        n.getName().accept(this, arg);
        n.getIndex().accept(this, arg);
        setUnikOprt("Array[]");
        cOperatorArray++;
    }

    public int getOperatorArray() {
        return this.cOperatorArray;
    }

    @Override
    public void visit(ReturnStmt n, Object arg) {
        if (n.getExpr() != null) {
            n.getExpr().accept(this, arg);
            setUnikOprt("return");
            cOperatorReturn++;
            if (n.getExpr().toString().contains("true") || n.getExpr().toString().contains("false")
                    || n.getExpr().toString().contains("null")) {
                //kosong
            } else {

            }
        }

    }

    public int getOperatorReturn() {
        return this.cOperatorReturn;
    }

    @Override
    public void visit(UnaryExpr n, Object arg) {
        n.getExpr().accept(this, arg);
        setUnikOprt(n.getOperator().toString());
        cOperatorUnary++;
    }

    public int getOperatorUnary() {
        return this.cOperatorUnary;
    }

    @Override
    public void visit(BinaryExpr n, Object arg) {
        n.getLeft().accept(this, arg);
        n.getRight().accept(this, arg);
        if (n.getOperator() != null) {
            setUnikOprt(n.getOperator().toString());
            cOperatorBinary++;
        }
    }

    public int getOperatorBinary() {
        return this.cOperatorBinary;
    }

    @Override
    public void visit(PrimitiveType n, Object arg) {
        setUnikOprt(n.getType().toString());
        cOperatorTypeData++;
    }

    public int getOperatorTypeData() {
        return this.cOperatorTypeData;
    }

    @Override
    public void visit(SwitchStmt n, Object arg) {
        n.getSelector().accept(this, arg);
        setUnikOprt("switch");
        cOperatorSwitch++;
        if (n.getEntries() != null) {
            for (SwitchEntryStmt e : n.getEntries()) {
                e.accept(this, arg);
                setUnikOprt("case");
                cOperatorCase++;
            }
        }
    }

    public int getOperatorSwitch() {
        return this.cOperatorSwitch;
    }

    public int getOperatorCase() {
        return this.cOperatorCase;
    }

    @Override
    public void visit(BreakStmt n, Object arg) {
        setUnikOprt("break");
        cOperatorBreak++;
    }

    public int getOperatorBreak() {
        return this.cOperatorBreak;
    }

    @Override
    public void visit(TryStmt n, Object arg) {
        n.getTryBlock().accept(this, arg);
        setUnikOprt("try");
        cOperatorTry++;
        if (n.getCatchs() != null) {
            for (CatchClause c : n.getCatchs()) {
                c.accept(this, arg);
                setUnikOprt("catch");
                cOperatorCatch++;
            }
        }
        if (n.getFinallyBlock() != null) {
            n.getFinallyBlock().accept(this, arg);
            setUnikOprt("finally");
            cOperatorFinally++;
        }
    }

    public int getOperatorTry() {
        return this.cOperatorTry;
    }

    public int getOperatorCatch() {
        return this.cOperatorCatch;
    }

    public int getOperatorFinally() {
        return this.cOperatorFinally;
    }

    public static class ClassName extends VoidVisitorAdapter {

        @Override
        public void visit(ClassOrInterfaceDeclaration n, Object arg) {
            namaClass = n.getName();
        }
    }

    public String getNamaClass() {
        return this.namaClass;
    }

    public static class TeePrintStream extends PrintStream {

        private final PrintStream second;

        public TeePrintStream(OutputStream main, PrintStream second) {
            super(main);
            this.second = second;
        }

        /**
         * Closes the main stream. The second stream is just flushed but
         * <b>not</b> closed.
         *
         * @see java.io.PrintStream#close()
         */
        @Override
        public void close() {
            // just for documentation
            super.close();
        }

        @Override
        public void flush() {
            super.flush();
            second.flush();
        }

        @Override
        public void write(byte[] buf, int off, int len) {
            super.write(buf, off, len);
            second.write(buf, off, len);
        }

        @Override
        public void write(int b) {
            super.write(b);
            second.write(b);
        }

        @Override
        public void write(byte[] b) throws IOException {
            super.write(b);
            second.write(b);
        }
    }

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        n.getBody().accept(this, arg);
        n.getType().accept(this, arg);
        if (n.getParameters() != null) {
            for (Parameter p : n.getParameters()) {
                p.accept(this, arg);
            }
        }
        setUnikOprn(n.getName());
        cOperandMethodName++;
        if (n.getType().toString().contains("void")) {
            setUnikOprt(n.getType().toString());
            cOperatorMethodType++;
        }
    }

    public int getOperatorMethodType() {
        return this.cOperatorMethodType;
    }

    public int getOperandMethodName() {
        return this.cOperandMethodName;
    }

    @Override
    public void visit(NameExpr n, Object arg) {
        if (n.getName().contains("Override")) {
            //kosong
        } else {
            setUnikOprn(n.getName());
            cOperandNameExpr++;
        }
    }

    public int getOperandNameExpr() {
        return this.cOperandNameExpr;
    }

    @Override
    public void visit(DoubleLiteralExpr n, Object arg) {
        setUnikOprn(n.getValue());
        cOperandDouble++;
    }

    public int getOperandDouble() {
        return this.cOperandDouble;
    }

    @Override
    public void visit(IntegerLiteralExpr n, Object arg) {
        setUnikOprn(n.getValue());
        cOperandInteger++;
    }

    public int getOperandInteger() {
        return this.cOperandInteger;
    }

    @Override
    public void visit(Parameter n, Object arg) {
        if (n.getAnnotations() != null) {
            for (AnnotationExpr a : n.getAnnotations()) {
                a.accept(this, arg);
            }
        }
        n.getType().accept(this, arg);
        n.getId().accept(this, arg);

        setUnikOprn(n.getId().toString());
        cOperandParameter++;
    }

    public int getOperandParameter() {
        return this.cOperandParameter;
    }

    @Override
    public void visit(VariableDeclarationExpr n, Object arg) {
        n.getType().accept(this, arg);
        List<VariableDeclarator> myVars = n.getVars();
        for (VariableDeclarator vars : myVars) {
            vars.accept(this, arg);
            setUnikOprn(vars.getId().getName());
            cOperandDec++;
        }
    }

    public int getOperandDec() {
        return this.cOperandDec;
    }

}
