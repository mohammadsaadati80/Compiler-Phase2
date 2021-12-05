package main;

import main.visitor.name.ASTTreePrinter;
import main.visitor.name.NameAnalyzer;
import parsers.*;
import main.ast.nodes.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class CmmCompiler {
    public void compile(CharStream textStream) {
        CmmLexer cmmLexer = new CmmLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(cmmLexer);
        CmmParser cmmParser = new CmmParser(tokenStream);

        Program program = cmmParser.cmm().cmmProgram;
        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);

        if (nameAnalyzer.getErrorCount() == 0){
            ASTTreePrinter astTreePrinter = new ASTTreePrinter();
            program.accept(astTreePrinter);
        }
    }
}
