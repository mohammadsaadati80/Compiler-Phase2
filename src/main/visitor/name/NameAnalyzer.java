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
import main.compileError.nameError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.StructSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;
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
        SymbolTable.root = symbolTable;
        SymbolTable.top = symbolTable;
        SymbolTable.push(symbolTable);
        for (StructDeclaration structDeclaration : program.getStructs())
            structDeclaration.accept(this);
        for (FunctionDeclaration functionDeclaration : program.getFunctions())
            functionDeclaration.accept(this);
        program.getMain().accept(this);
        SymbolTable.pop();
        return super.visit(program);
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        FunctionSymbolTableItem functionSymbolTableItem = new FunctionSymbolTableItem(functionDeclaration);
        functionSymbolTableItem.setReturnType(functionDeclaration.getReturnType());
        functionDeclaration.setArgs(functionDeclaration.getArgs());
        functionDeclaration.setFunctionName(functionDeclaration.getFunctionName());
        functionDeclaration.setBody(functionDeclaration.getBody());

        try {
            SymbolTable.root.put(functionSymbolTableItem);
        } catch (ItemAlreadyExistsException e) {
            this.errors.add(new DuplicateFunction
                    (functionDeclaration.getLine(), functionDeclaration.getFunctionName().getName()));
            functionSymbolTableItem.setName(functionSymbolTableItem.getName() + "^");
        }

        try {
            SymbolTable.root.getItem("Struct_" + functionDeclaration.getFunctionName().getName());
            this.errors.add(new FunctionStructConflict
                    (functionDeclaration.getLine(), functionDeclaration.getFunctionName().getName()));
            functionSymbolTableItem.setName(functionSymbolTableItem.getName() + "^");
        } catch (ItemNotFoundException ignored) {}

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.pre = SymbolTable.top;
        functionSymbolTableItem.setFunctionSymbolTable(symbolTable);
        SymbolTable.push(symbolTable);

        if (functionDeclaration.getFunctionName() != null)
            functionDeclaration.getFunctionName().accept(this);
        for (VariableDeclaration arg : functionDeclaration.getArgs())
            arg.accept(this);
        if (functionDeclaration.getBody() != null)
            functionDeclaration.getBody().accept(this);

        SymbolTable.pop();
        return super.visit(functionDeclaration);
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.pre = SymbolTable.top;
        SymbolTable.push(symbolTable);

        if (mainDeclaration.getBody() != null)
            mainDeclaration.getBody().accept(this);

        SymbolTable.pop();
        return super.visit(mainDeclaration);
    }

    @Override
    public Void visit(VariableDeclaration variableDeclaration) {
        VariableSymbolTableItem variableSymbolTableItem =
                new VariableSymbolTableItem(variableDeclaration.getVarName());
        variableSymbolTableItem.setType(variableDeclaration.getVarType());

        try { //todo mashkok
            SymbolTable.top.getItem(variableSymbolTableItem.getKey());
            this.errors.add(new DuplicateVar
                    (variableDeclaration.getLine(), variableDeclaration.getVarName().getName()));
            variableSymbolTableItem.setName(variableSymbolTableItem.getName() + "^");
        } catch (ItemNotFoundException ignored) {}

        try {
            SymbolTable.top.put(variableSymbolTableItem);
        } catch (ItemAlreadyExistsException e) {
            this.errors.add(new DuplicateVar
                    (variableDeclaration.getLine(), variableDeclaration.getVarName().getName()));
            variableSymbolTableItem.setName(variableSymbolTableItem.getName() + "^");
        }

        try {
            SymbolTable.root.getItem("Struct_" + variableDeclaration.getVarName().getName());
            this.errors.add(new VarStructConflict
                    (variableDeclaration.getLine(), variableDeclaration.getVarName().getName()));
            variableSymbolTableItem.setName(variableSymbolTableItem.getName() + "^");
        } catch (ItemNotFoundException ignored) {}

        try {
            SymbolTable.root.getItem("Function_" + variableDeclaration.getVarName().getName());
            this.errors.add(new VarFunctionConflict
                    (variableDeclaration.getLine(), variableDeclaration.getVarName().getName()));
            variableSymbolTableItem.setName(variableSymbolTableItem.getName() + "^");
        } catch (ItemNotFoundException ignored) {}

        if (variableDeclaration.getVarName() != null)
            variableDeclaration.getVarName().accept(this);
        if (variableDeclaration.getDefaultValue() != null)
            variableDeclaration.getDefaultValue().accept(this);

        return super.visit(variableDeclaration);
    }

    @Override
    public Void visit(StructDeclaration structDeclaration) {
        StructSymbolTableItem structSymbolTableItem = new StructSymbolTableItem(structDeclaration);
        try {
            SymbolTable.root.put(structSymbolTableItem);
        } catch (ItemAlreadyExistsException e) {
            this.errors.add(new DuplicateStruct
                    (structDeclaration.getLine(), structDeclaration.getStructName().getName()));
            structSymbolTableItem.setName(structSymbolTableItem.getName() + "^");
        }

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.pre = SymbolTable.root;
        structSymbolTableItem.setStructSymbolTable(symbolTable);
        SymbolTable.push(symbolTable);

        if (structDeclaration.getStructName() != null)
            structDeclaration.getStructName().accept(this);
        if (structDeclaration.getBody() != null)
            structDeclaration.getBody().accept(this);

        SymbolTable.pop();
        return super.visit(structDeclaration);
    }

    @Override
    public Void visit(SetGetVarDeclaration setGetVarDeclaration) {
        if (setGetVarDeclaration.getVarName() != null) {
            VariableDeclaration variableDeclaration =
                    new VariableDeclaration(setGetVarDeclaration.getVarName(),setGetVarDeclaration.getVarType());
            variableDeclaration.setLine(setGetVarDeclaration.getLine());
            variableDeclaration.accept(this);
        }

        for (VariableDeclaration arg : setGetVarDeclaration.getArgs())
            arg.accept(this);
        /*if (setGetVarDeclaration.getSetterBody() != null)
            setGetVarDeclaration.getSetterBody().accept(this);
        if (setGetVarDeclaration.getGetterBody() != null)
            setGetVarDeclaration.getGetterBody().accept(this);*/

        return super.visit(setGetVarDeclaration);
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        if (assignmentStmt.getLValue() != null)
            assignmentStmt.getLValue().accept(this);
        if (assignmentStmt.getRValue() != null)
            assignmentStmt.getRValue().accept(this);
        return super.visit(assignmentStmt);
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        for (Statement _statement : blockStmt.getStatements())
            _statement.accept(this);
        return super.visit(blockStmt);
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        if (conditionalStmt.getCondition() != null)
            conditionalStmt.getCondition().accept(this);

        if (conditionalStmt.getThenBody() != null) {
            SymbolTable symbolTable = new SymbolTable();
            symbolTable.pre = SymbolTable.top;
            SymbolTable.push(symbolTable);
            conditionalStmt.getThenBody().accept(this);
            SymbolTable.pop();
        }

        if (conditionalStmt.getElseBody() != null) {
            SymbolTable symbolTable = new SymbolTable();
            symbolTable.pre = SymbolTable.top;
            SymbolTable.push(symbolTable);
            conditionalStmt.getElseBody().accept(this);
            SymbolTable.pop();
        }

        return super.visit(conditionalStmt);
    }

    @Override
    public Void visit(FunctionCallStmt functionCallStmt) {
        if (functionCallStmt.getFunctionCall() != null)
            functionCallStmt.getFunctionCall().accept(this);
        return super.visit(functionCallStmt);
    }

    @Override
    public Void visit(DisplayStmt displayStmt) {
        if (displayStmt.getArg() != null)
            displayStmt.getArg().accept(this);
        return super.visit(displayStmt);
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        if (returnStmt.getReturnedExpr() != null)
            returnStmt.getReturnedExpr().accept(this);
        return super.visit(returnStmt);
    }

    @Override
    public Void visit(LoopStmt loopStmt) {
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.pre = SymbolTable.top;
        SymbolTable.push(symbolTable);

        if (loopStmt.getCondition() != null)
            loopStmt.getCondition().accept(this);
        if (loopStmt.getBody() != null)
            loopStmt.getBody().accept(this);

        SymbolTable.pop();
        return super.visit(loopStmt);
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        for (VariableDeclaration var : varDecStmt.getVars())
            var.accept(this);
        return super.visit(varDecStmt);
    }

    @Override
    public Void visit(ListAppendStmt listAppendStmt) {
        if (listAppendStmt.getListAppendExpr() != null)
            listAppendStmt.getListAppendExpr().accept(this);
        return super.visit(listAppendStmt);
    }

    @Override
    public Void visit(ListSizeStmt listSizeStmt) {
        if (listSizeStmt.getListSizeExpr() != null)
            listSizeStmt.getListSizeExpr().accept(this);
        return super.visit(listSizeStmt);
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        if (binaryExpression.getFirstOperand() != null)
            binaryExpression.getFirstOperand().accept(this);
        if (binaryExpression.getSecondOperand() != null)
            binaryExpression.getSecondOperand().accept(this);
        return super.visit(binaryExpression);
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        if (unaryExpression.getOperand() != null)
            unaryExpression.getOperand().accept(this);
        return super.visit(unaryExpression);
    }

    @Override
    public Void visit(Identifier identifier) {
        return super.visit(identifier);
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        if (listAccessByIndex.getInstance() != null)
            listAccessByIndex.getInstance().accept(this);
        if (listAccessByIndex.getIndex() != null)
            listAccessByIndex.getIndex().accept(this);
        return super.visit(listAccessByIndex);
    }

    @Override
    public Void visit(StructAccess structAccess) {
        if (structAccess.getInstance() != null)
            structAccess.getInstance().accept(this);
        if (structAccess.getElement() != null)
            structAccess.getElement().accept(this);
        return super.visit(structAccess);
    }

    @Override
    public Void visit(FunctionCall functionCall) {
        if (functionCall.getInstance() != null)
            functionCall.getInstance().accept(this);
        for (Expression arg : functionCall.getArgs())
            arg.accept(this);
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
        if (listSize.getArg() != null)
            listSize.getArg().accept(this);
        return super.visit(listSize);
    }

    @Override
    public Void visit(ListAppend listAppend) {
        if (listAppend.getListArg() != null)
            listAppend.getListArg().accept(this);
        if (listAppend.getElementArg() != null)
            listAppend.getElementArg().accept(this);
        return super.visit(listAppend);
    }

    @Override
    public Void visit(ExprInPar exprInPar) {
        for (Expression input : exprInPar.getInputs())
            input.accept(this);
        return super.visit(exprInPar);
    }
}
