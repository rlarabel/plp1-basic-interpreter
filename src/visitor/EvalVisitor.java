package visitor;

import java.util.ArrayList;
import java.util.List;

import ast.ASTNode;
import ast.AddNode;
import ast.AndNode;
import ast.ArgumentListNode;
import ast.AssignNode;
import ast.BodyNode;
import ast.BooleanNode;
import ast.CallNode;
import ast.DivideNode;
import ast.EqualNode;
import ast.FloatNode;
import ast.FunctionDefinitionNode;
import ast.GreaterEqualNode;
import ast.GreaterNode;
import ast.IfNode;
import ast.IntegerNode;
import ast.LambdaNode;
import ast.LessEqualNode;
import ast.LessNode;
import ast.LetDeclListNode;
import ast.LetDeclNode;
import ast.LetNode;
import ast.ListNode;
import ast.MultiplyNode;
import ast.NotEqualNode;
import ast.NotNode;
import ast.NullNode;
import ast.OrNode;
import ast.ParameterListNode;
import ast.ParenNode;
import ast.ProgramNode;
import ast.StringNode;
import ast.SubNode;
import ast.SwitchCaseListNode;
import ast.SwitchCaseNode;
import ast.SwitchNode;
import ast.VarDefNode;
import ast.VarRefNode;
import util.PLp1Error;
import util.BaseEnvironment;
import util.Environment;
import util.StringValue;
import util.Value;
import util.BooleanValue;
import util.BuiltinFunction;
import util.IntValue;
import util.FloatValue;
import util.ListValue;
import util.NullValue;

public class EvalVisitor implements Visitor<Object> {

    public Environment baseEnv = new BaseEnvironment();

    @Override
    public List<Value> visit(ArgumentListNode n) throws PLp1Error {
        List<Value> source = new ArrayList<Value>();
        for (ASTNode node : n.getArguments()) {
            source.add((Value) node.accept(this));
        }
        return source;
    }

    @Override
    public Value visit(AssignNode n) throws PLp1Error {
        Value exp = (Value) n.getRhs().accept(this);
        if(exp instanceof FloatValue)
            return baseEnv.put(n.getLhs(), new FloatValue().addValue(((FloatValue) exp).getFloat()));  
        else if (exp instanceof IntValue) 
            return baseEnv.put(n.getLhs(), new IntValue().addValue(((IntValue) exp).getInt()));  
        else if (exp instanceof BooleanValue) 
            return baseEnv.put(n.getLhs(), new BooleanValue().addValue(((BooleanValue) exp).getBoolean()));  
        else if (exp instanceof ListValue) 
            return baseEnv.put(n.getLhs(), new ListValue().addValue(((ListValue) exp).toString())); 
        else if (exp instanceof StringValue) 
            return baseEnv.put(n.getLhs(), new StringValue().addValue(((StringValue) exp).toString())); 
        else 
            throw new PLp1Error("Could not assign the type to a id");
    }

    @Override
    public Value visit(BodyNode n) throws PLp1Error {
        if(n.getBody().size() == 1)
            return((Value) n.getBody().get(0).accept(this));
        else  if(n.getBody().size() > 1){
            ListValue source = new ListValue();
            for (ASTNode node : n.getBody()) {
                source.addValue((Value) node.accept(this));
            }
            return source;
        } else
            throw new PLp1Error("No expressions given");
    }

    @Override
    public Value visit(BooleanNode n) throws PLp1Error {
        BooleanValue boolVal = new BooleanValue();
        boolean bool = n.getVal();
        boolVal.addValue(bool);
        return boolVal; 
    }

    @Override
    public Value visit(CallNode n) throws PLp1Error {
        @SuppressWarnings("unchecked")
        List<Value> argList = (List<Value>) n.getArgs().accept(this);
        Value fVal = (Value) n.getFunc().accept(this);
        if(fVal instanceof BuiltinFunction)
            return (Value) ((BuiltinFunction) fVal).invoke(baseEnv, argList);
        else   
            throw new PLp1Error("Called a non-function");
    }

    @Override
    public Value visit(SwitchCaseNode n) throws PLp1Error {
        if(((BooleanValue) n.getTestExpr().accept(this)).getBoolean()) 
            return (Value) n.getResultExpr().accept(this);
        else
            return null;
    }

    @Override
    public Value visit(SwitchNode n) throws PLp1Error {
        Value result = (Value) n.getCases().accept(this);
        if (result != null)
            return result;
        return (Value) n.getDefaultCase().accept(this);
    }

    @Override
    public Value visit(FunctionDefinitionNode n) throws PLp1Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public Value visit(FloatNode n) throws PLp1Error {
        FloatValue floatVal = new FloatValue();
        float val = n.getVal();
        floatVal.addValue(val);
        return floatVal;
    }

    @Override
    public Value visit(LambdaNode n) throws PLp1Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public Value visit(IfNode n) throws PLp1Error {
        BooleanValue testExp = (BooleanValue) n.getTestExpr().accept(this);
        if (testExp.getBoolean())
            return (Value) n.getThenExpr().accept(this);
        else
            return (Value) n.getElseExpr().accept(this);
    }

    @Override
    public Value visit(IntegerNode n) throws PLp1Error {
        IntValue intVal = new IntValue();
        int val = n.getVal();
        intVal.addValue(val);
        return intVal;
    }

    @Override
    public Value visit(ListNode n) throws PLp1Error {
        ListValue listVal = new ListValue();
        for (ASTNode node : n.getList()) {
            listVal.append((Value) node.accept(this));
        }
        return listVal;
    }

    @Override
    public Value visit(StringNode n) throws PLp1Error {
        StringValue strVal = new StringValue();
        String val = n.getString();
        strVal.addValue(val);
        return strVal;
    }

    @Override
    public Value visit(VarRefNode n) throws PLp1Error {
        return baseEnv.get(n.getId());
    }

    @Override
    public Value visit(LetNode n) throws PLp1Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public Value visit(AddNode n) throws PLp1Error {
        Value leftOp = (Value) n.getLeftOperand().accept(this); 
        Value rightOp = (Value) n.getRightOperand().accept(this);

        if(leftOp instanceof FloatValue && rightOp instanceof FloatValue)
            return (new FloatValue()).addValue(((FloatValue) leftOp).getFloat() + ((FloatValue) rightOp).getFloat()); 
        else if (leftOp instanceof IntValue && rightOp instanceof IntValue) 
            return (new IntValue()).addValue(((IntValue) leftOp).getInt() + ((IntValue) rightOp).getInt());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            return (new FloatValue()).addValue(((float) ((IntValue) leftOp).getInt()) + ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            return (new FloatValue()).addValue(((FloatValue) leftOp).getFloat() + ((float) ((IntValue) rightOp).getInt()));
        else 
            throw new PLp1Error("Could not add operands: incompatible types");
    }

    @Override
    public Value visit(SubNode n) throws PLp1Error {
        Value leftOp = (Value) n.getLeftOperand().accept(this); 
        Value rightOp = (Value) n.getRightOperand().accept(this);

        if(leftOp instanceof FloatValue && rightOp instanceof FloatValue)
            return (new FloatValue()).addValue(((FloatValue) leftOp).getFloat() - ((FloatValue) rightOp).getFloat()); 
        else if (leftOp instanceof IntValue && rightOp instanceof IntValue) 
            return (new IntValue()).addValue(((IntValue) leftOp).getInt() - ((IntValue) rightOp).getInt());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            return (new FloatValue()).addValue(((float) ((IntValue) leftOp).getInt()) - ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            return (new FloatValue()).addValue(((FloatValue) leftOp).getFloat() - ((float) ((IntValue) rightOp).getInt()));
        else 
            throw new PLp1Error("Could not subtract operands: incompatible types");
    }

    @Override
    public Value visit(MultiplyNode n) throws PLp1Error {
        Value leftOp = (Value) n.getLeftOperand().accept(this); 
        Value rightOp = (Value) n.getRightOperand().accept(this);

        if(leftOp instanceof FloatValue && rightOp instanceof FloatValue)
            return (new FloatValue()).addValue(((FloatValue) leftOp).getFloat() * ((FloatValue) rightOp).getFloat()); 
        else if (leftOp instanceof IntValue && rightOp instanceof IntValue) 
            return (new IntValue()).addValue(((IntValue) leftOp).getInt() * ((IntValue) rightOp).getInt());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            return (new FloatValue()).addValue(((float) ((IntValue) leftOp).getInt()) * ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            return (new FloatValue()).addValue(((FloatValue) leftOp).getFloat() * ((float) ((IntValue) rightOp).getInt())); 
        else 
            throw new PLp1Error("Could not multiply operands: incompatible types");
    }

    @Override
    public Value visit(DivideNode n) throws PLp1Error {
        Value leftOp = (Value) n.getLeftOperand().accept(this); 
        Value rightOp = (Value) n.getRightOperand().accept(this);
        try{
            if(leftOp instanceof FloatValue && rightOp instanceof FloatValue)
                return (new FloatValue()).addValue(((FloatValue) leftOp).getFloat() / ((FloatValue) rightOp).getFloat()); 
            else if (leftOp instanceof IntValue && rightOp instanceof IntValue) 
                return (new IntValue()).addValue(((IntValue) leftOp).getInt() / ((IntValue) rightOp).getInt()); 
            else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
                return (new FloatValue()).addValue(((float) ((IntValue) leftOp).getInt()) / ((FloatValue) rightOp).getFloat());
            else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
                return (new FloatValue()).addValue(((FloatValue) leftOp).getFloat() / ((float) ((IntValue) rightOp).getInt()));
            else 
                throw new PLp1Error("Could not divide operands: incompatible types");
        } catch(ArithmeticException e) {
            throw new PLp1Error(e);
        }
    }

    @Override
    public Value visit(NotNode n) throws PLp1Error {
        Value operandVal = (Value) n.getOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(operandVal instanceof BooleanValue){
            result.addValue(! ((BooleanValue) operandVal).getBoolean());
            return result;
        } else {
            throw new PLp1Error("! operand must be a BooleanValue type");
        }
    }

    @Override
    public Value visit(OrNode n) throws PLp1Error {
        Value rightOp = (Value) n.getRightOperand().accept(this);
        Value leftOp = (Value) n.getLeftOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(rightOp instanceof BooleanValue && leftOp instanceof BooleanValue){
            result.addValue(((BooleanValue) leftOp).getBoolean() || ((BooleanValue) rightOp).getBoolean());
            return result;
        } else {
            throw new PLp1Error("|| operands must be a BooleanValue types");
        }
    }

    @Override
    public Value visit(AndNode n) throws PLp1Error {
        Value rightOp = (Value) n.getRightOperand().accept(this);
        Value leftOp = (Value) n.getLeftOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(rightOp instanceof BooleanValue && leftOp instanceof BooleanValue){
            result.addValue(((BooleanValue) leftOp).getBoolean() && ((BooleanValue) rightOp).getBoolean());
            return result;
        } else {
            throw new PLp1Error("&& operands must be a BooleanValue types");
        }
    }

    @Override
    public Value visit(EqualNode n) throws PLp1Error {
        Value rightOp = (Value) n.getRightOperand().accept(this);
        Value leftOp = (Value) n.getLeftOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(rightOp instanceof BooleanValue && leftOp instanceof BooleanValue)
            result.addValue(((BooleanValue) leftOp).getBoolean() == ((BooleanValue) rightOp).getBoolean());
        else if(rightOp instanceof IntValue && leftOp instanceof IntValue)
            result.addValue(((IntValue) leftOp).getInt() == ((IntValue) rightOp).getInt());
        else if(rightOp instanceof FloatValue && leftOp instanceof FloatValue) 
            result.addValue(((FloatValue) leftOp).getFloat() == ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            result.addValue(((float) ((IntValue) leftOp).getInt()) == ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            result.addValue(((FloatValue) leftOp).getFloat() == ((float) ((IntValue) rightOp).getInt()));
        else 
            throw new PLp1Error("Could not perform == on operands: incompatible types");
        return result;
    }

    @Override
    public Value visit(NotEqualNode n) throws PLp1Error {
        Value rightOp = (Value) n.getRightOperand().accept(this);
        Value leftOp = (Value) n.getLeftOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(rightOp instanceof BooleanValue && leftOp instanceof BooleanValue)
            result.addValue(((BooleanValue) leftOp).getBoolean() != ((BooleanValue) rightOp).getBoolean());
        else if(rightOp instanceof IntValue && leftOp instanceof IntValue)
            result.addValue(((IntValue) leftOp).getInt() != ((IntValue) rightOp).getInt());
        else if(rightOp instanceof FloatValue && leftOp instanceof FloatValue) 
            result.addValue(((FloatValue) leftOp).getFloat() != ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            result.addValue(((float) ((IntValue) leftOp).getInt()) != ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            result.addValue(((FloatValue) leftOp).getFloat() != ((float) ((IntValue) rightOp).getInt()));
        else 
            throw new PLp1Error("Could not perform != on operands: incompatible types");
        return result;
    }

    @Override
    public Value visit(LessNode n) throws PLp1Error {
        Value rightOp = (Value) n.getRightOperand().accept(this);
        Value leftOp = (Value) n.getLeftOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(rightOp instanceof IntValue && leftOp instanceof IntValue)
            result.addValue(((IntValue) leftOp).getInt() < ((IntValue) rightOp).getInt());
        else if(rightOp instanceof FloatValue && leftOp instanceof FloatValue) 
            result.addValue(((FloatValue) leftOp).getFloat() < ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            result.addValue(((float) ((IntValue) leftOp).getInt()) < ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            result.addValue(((FloatValue) leftOp).getFloat() < ((float) ((IntValue) rightOp).getInt()));
        else 
            throw new PLp1Error("Could not perform < on operands: incompatible types");
        return result;
    }

    @Override
    public Value visit(LessEqualNode n) throws PLp1Error {
        Value rightOp = (Value) n.getRightOperand().accept(this);
        Value leftOp = (Value) n.getLeftOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(rightOp instanceof IntValue && leftOp instanceof IntValue)
            result.addValue(((IntValue) leftOp).getInt() <= ((IntValue) rightOp).getInt());
        else if(rightOp instanceof FloatValue && leftOp instanceof FloatValue) 
            result.addValue(((FloatValue) leftOp).getFloat() <= ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            result.addValue(((float) ((IntValue) leftOp).getInt()) <= ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            result.addValue(((FloatValue) leftOp).getFloat() <= ((float) ((IntValue) rightOp).getInt()));
        else 
            throw new PLp1Error("Could not perform <= on operands: incompatible types");
        return result;
    }

    @Override
    public Value visit(GreaterNode n) throws PLp1Error {
        Value rightOp = (Value) n.getRightOperand().accept(this);
        Value leftOp = (Value) n.getLeftOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(rightOp instanceof IntValue && leftOp instanceof IntValue)
            result.addValue(((IntValue) leftOp).getInt() > ((IntValue) rightOp).getInt());
        else if(rightOp instanceof FloatValue && leftOp instanceof FloatValue) 
            result.addValue(((FloatValue) leftOp).getFloat() > ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            result.addValue(((float) ((IntValue) leftOp).getInt()) > ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            result.addValue(((FloatValue) leftOp).getFloat() > ((float) ((IntValue) rightOp).getInt()));
        else 
            throw new PLp1Error("Could not perform > on operands: incompatible types");
        return result;
    }

    @Override
    public Value visit(GreaterEqualNode n) throws PLp1Error {
        Value rightOp = (Value) n.getRightOperand().accept(this);
        Value leftOp = (Value) n.getLeftOperand().accept(this);
        BooleanValue result = new BooleanValue();
        if(rightOp instanceof IntValue && leftOp instanceof IntValue)
            result.addValue(((IntValue) leftOp).getInt() >= ((IntValue) rightOp).getInt());
        else if(rightOp instanceof FloatValue && leftOp instanceof FloatValue) 
            result.addValue(((FloatValue) leftOp).getFloat() >= ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof IntValue && rightOp instanceof FloatValue) 
            result.addValue(((float) ((IntValue) leftOp).getInt()) >= ((FloatValue) rightOp).getFloat());
        else if (leftOp instanceof FloatValue && rightOp instanceof IntValue) 
            result.addValue(((FloatValue) leftOp).getFloat() >= ((float) ((IntValue) rightOp).getInt()));
        else 
            throw new PLp1Error("Could not perform >= on operands: incompatible types");
        return result;
    }

    @Override
    public Value visit(ParenNode n) throws PLp1Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public Value visit(ParameterListNode n) throws PLp1Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public Value visit(LetDeclNode n) throws PLp1Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public Value visit(LetDeclListNode n) throws PLp1Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public Value visit(SwitchCaseListNode n) throws PLp1Error {
        Value source = null;
        for (ASTNode scn : n.getSwitchCases()) {
            source = (Value) scn.accept(this);
            if(source != null)
                return source;
        }
        return null;
    }

    @Override
    public Value visit(NullNode n) throws PLp1Error {
        NullValue nullVal = new NullValue();
        nullVal.addValue(null);
        return nullVal;
    }

    @Override
    public Value visit(ProgramNode n) throws PLp1Error {
        //ListValue source = new ListValue();
        //for (ASTNode an : n.getProgram()) {
        //   source.append((Value)an.accept(this));
        //}
        //return source;
        return (Value) n.getProgram().get(0).accept(this);
    }

    @Override
    public Value visit(VarDefNode n) throws PLp1Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

}
