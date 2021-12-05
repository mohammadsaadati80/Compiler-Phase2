package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.visitor.*;

public class ASTTreePrinter extends Visitor<Void> {
    public void messagePrinter(int line, String message){
        System.out.println("Line " + line + ": " + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.toString());
        for (StructDeclaration structDeclaration: program.getStructs())
            structDeclaration.accept(this);
        for (FunctionDeclaration functionDeclaration:program.getFunctions())
            functionDeclaration.accept(this);
        program.getMain().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDec) {
        messagePrinter(functionDec.getLine(), functionDec.toString());
        if (functionDec.getFunctionName() != null)
            functionDec.getFunctionName().accept(this);
        for (VariableDeclaration arg : functionDec.getArgs())
            arg.accept(this);
        if (functionDec.getBody() != null)
            functionDec.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDec) {
        messagePrinter(mainDec.getLine(), mainDec.toString());
        if (mainDec.getBody() != null)
            mainDec.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration variableDec) {
        messagePrinter(variableDec.getLine(), variableDec.toString());
        if (variableDec.getVarName() != null)
            variableDec.getVarName().accept(this);
        if (variableDec.getDefaultValue() != null)
            variableDec.getDefaultValue().accept(this);
        return null;
    }

    @Override
    public Void visit(StructDeclaration structDec) {
        messagePrinter(structDec.getLine(), structDec.toString());
        if (structDec.getStructName() != null)
            structDec.getStructName().accept(this);
        if (structDec.getBody() != null)
            structDec.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(SetGetVarDeclaration setGetVarDec) {
        messagePrinter(setGetVarDec.getLine(), setGetVarDec.toString());
        if (setGetVarDec.getVarName() != null)
            setGetVarDec.getVarName().accept(this);
        for (VariableDeclaration arg : setGetVarDec.getArgs())
            arg.accept(this);
        if (setGetVarDec.getSetterBody() != null)
            setGetVarDec.getSetterBody().accept(this);
        if (setGetVarDec.getGetterBody() != null)
            setGetVarDec.getGetterBody().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        messagePrinter(assignmentStmt.getLine(), assignmentStmt.toString());
        if (assignmentStmt.getLValue() != null)
            assignmentStmt.getLValue().accept(this);
        if (assignmentStmt.getRValue() != null)
            assignmentStmt.getRValue().accept(this);
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        messagePrinter(blockStmt.getLine(), blockStmt.toString());
        for (Statement _statement : blockStmt.getStatements())
            _statement.accept(this);
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        messagePrinter(conditionalStmt.getLine(), conditionalStmt.toString());
        if (conditionalStmt.getCondition() != null)
            conditionalStmt.getCondition().accept(this);
        if (conditionalStmt.getThenBody() != null)
            conditionalStmt.getThenBody().accept(this);
        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt functionCallStmt) {
        messagePrinter(functionCallStmt.getLine(), functionCallStmt.toString());
        if (functionCallStmt.getFunctionCall() != null)
            functionCallStmt.getFunctionCall().accept(this);
        return null;
    }

    @Override
    public Void visit(DisplayStmt displayStmt) {
        messagePrinter(displayStmt.getLine(), displayStmt.toString());
        if (displayStmt.getArg() != null)
            displayStmt.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        messagePrinter(returnStmt.getLine(), returnStmt.toString());
        if (returnStmt.getReturnedExpr() != null)
            returnStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(LoopStmt loopStmt) {
        messagePrinter(loopStmt.getLine(), loopStmt.toString());
        if (loopStmt.getCondition() != null)
            loopStmt.getCondition().accept(this);
        if (loopStmt.getBody() != null)
            loopStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        messagePrinter(varDecStmt.getLine(), varDecStmt.toString());
        for (VariableDeclaration var : varDecStmt.getVars())
            var.accept(this);
        return null;
    }

    @Override
    public Void visit(ListAppendStmt listAppendStmt) {
        messagePrinter(listAppendStmt.getLine(), listAppendStmt.toString());
        if (listAppendStmt.getListAppendExpr() != null)
            listAppendStmt.getListAppendExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ListSizeStmt listSizeStmt) {
        messagePrinter(listSizeStmt.getLine(), listSizeStmt.toString());
        if (listSizeStmt.getListSizeExpr() != null)
            listSizeStmt.getListSizeExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        messagePrinter(binaryExpression.getLine(), binaryExpression.toString());
        if (binaryExpression.getFirstOperand() != null)
            binaryExpression.getFirstOperand().accept(this);
        if (binaryExpression.getSecondOperand() != null)
            binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override // todo need check
    public Void visit(UnaryExpression unaryExpression) {
        messagePrinter(unaryExpression.getLine(), unaryExpression.toString());
        if (unaryExpression.getOperand() != null)
            unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCall funcCall) {
        messagePrinter(funcCall.getLine(), funcCall.toString());
        if (funcCall.getInstance() != null)
            funcCall.getInstance().accept(this);
        for (Expression arg : funcCall.getArgs())
            arg.accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        messagePrinter(identifier.getLine(), identifier.toString());
        return null;
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        messagePrinter(listAccessByIndex.getLine(), listAccessByIndex.toString());
        if (listAccessByIndex.getInstance() != null)
            listAccessByIndex.getInstance().accept(this);
        if (listAccessByIndex.getIndex() != null)
            listAccessByIndex.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(StructAccess structAccess) {
        messagePrinter(structAccess.getLine(), structAccess.toString());
        if (structAccess.getInstance() != null)
            structAccess.getInstance().accept(this);
        if (structAccess.getElement() != null)
            structAccess.getElement().accept(this);
        return null;
    }

    @Override
    public Void visit(ListSize listSize) {
        messagePrinter(listSize.getLine(), listSize.toString());
        if (listSize.getArg() != null)
            listSize.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ListAppend listAppend) {
        messagePrinter(listAppend.getLine(), listAppend.toString());
        if (listAppend.getListArg() != null)
            listAppend.getListArg().accept(this);
        if (listAppend.getElementArg() != null)
            listAppend.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ExprInPar exprInPar) {
        messagePrinter(exprInPar.getLine(), exprInPar.toString());
        for (Expression input : exprInPar.getInputs())
            input.accept(this);
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        messagePrinter(intValue.getLine(), intValue.toString());
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        messagePrinter(boolValue.getLine(), boolValue.toString());
        return null;
    }
}