package main.visitor.name;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.VariableDeclaration;
import main.ast.nodes.declaration.struct.StructDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.statement.*;
import main.compileError.CompileError;
import main.compileError.nameError.DuplicateStruct;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.StructSymbolTableItem;
import main.symbolTable.utils.Stack;
import main.visitor.Visitor;

import java.util.HashSet;
import java.util.Set;

public class NameAnalyzer extends Visitor<Void> {

    private final Set<CompileError> errors;

    public NameAnalyzer() {
        this.errors = new HashSet<>();
    }

    public Set<CompileError> getErrors() {
        return errors;
    }

    @Override
    public Void visit(Program program) {
        SymbolTable symbolTable = new SymbolTable();
        SymbolTable.push(symbolTable);
        for (StructDeclaration structDeclaration : program.getStructs())
            structDeclaration.accept(this);
        for (FunctionDeclaration functionDeclaration : program.getFunctions())
            functionDeclaration.accept(this);
        return super.visit(program);
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        return super.visit(functionDeclaration);
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        return super.visit(mainDeclaration);
    }

    @Override
    public Void visit(VariableDeclaration variableDeclaration) {
        return super.visit(variableDeclaration);
    }

    @Override
    public Void visit(StructDeclaration structDeclaration) {
        StructSymbolTableItem structSymbolTableItem = new StructSymbolTableItem(structDeclaration);
        do {
            try {
                SymbolTable.top.put(structSymbolTableItem);
                break;
            }catch (ItemAlreadyExistsException e){
                if (structSymbolTableItem.getName().indexOf('^') == -1)
                    this.errors.add(new DuplicateStruct
                            (structDeclaration.getLine(),structDeclaration.getStructName().getName()));
                structSymbolTableItem.setName(structSymbolTableItem.getName()+"^");
            }
        } while (true);

        SymbolTable symbolTable = new SymbolTable();
        structSymbolTableItem.setStructSymbolTable(symbolTable);
        symbolTable.pre = SymbolTable.top;
        SymbolTable.push(symbolTable);
        SymbolTable.top = symbolTable;

        if (structDeclaration.getStructName() != null)
            structDeclaration.getStructName().accept(this);
        if (structDeclaration.getBody() != null)
            structDeclaration.getBody().accept(this);

        return super.visit(structDeclaration);
    }

    @Override
    public Void visit(SetGetVarDeclaration setGetVarDeclaration) {
        return super.visit(setGetVarDeclaration);
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        return super.visit(assignmentStmt);
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        return super.visit(blockStmt);
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        return super.visit(conditionalStmt);
    }

    @Override
    public Void visit(FunctionCallStmt functionCallStmt) {
        return super.visit(functionCallStmt);
    }

    @Override
    public Void visit(DisplayStmt displayStmt) {
        return super.visit(displayStmt);
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        return super.visit(returnStmt);
    }

    @Override
    public Void visit(LoopStmt loopStmt) {
        return super.visit(loopStmt);
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        return super.visit(varDecStmt);
    }

    @Override
    public Void visit(ListAppendStmt listAppendStmt) {
        return super.visit(listAppendStmt);
    }

    @Override
    public Void visit(ListSizeStmt listSizeStmt) {
        return super.visit(listSizeStmt);
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        return super.visit(binaryExpression);
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        return super.visit(unaryExpression);
    }

    @Override
    public Void visit(Identifier identifier) {
        return super.visit(identifier);
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        return super.visit(listAccessByIndex);
    }

    @Override
    public Void visit(StructAccess structAccess) {
        return super.visit(structAccess);
    }

    @Override
    public Void visit(FunctionCall functionCall) {
        return super.visit(functionCall);
    }

    @Override
    public Void visit(IntValue intValue) {
        return super.visit(intValue);
    }

    @Override
    public Void visit(BoolValue boolValue) {
        return super.visit(boolValue);
    }

    @Override
    public Void visit(ListSize listSize) {
        return super.visit(listSize);
    }

    @Override
    public Void visit(ListAppend listAppend) {
        return super.visit(listAppend);
    }

    @Override
    public Void visit(ExprInPar exprInPar) {
        return super.visit(exprInPar);
    }
}
