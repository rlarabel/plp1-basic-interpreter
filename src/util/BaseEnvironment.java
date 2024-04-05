/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import util.ValueFactory.ValueType;

/**
 *
 * @author carr
 */
public class BaseEnvironment extends Environment {

    private static ValueFactory factory = new ValueFactory();
    /**
     *
     */
    private static final long serialVersionUID = -3135942080438916540L;

       
    static class Length extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args)
                throws PLp1Error {
            Value op = args.get(0);

            if (op instanceof ListValue) {
                return factory.makeValue(ValueType.INT).addValue(((ListValue) op).length());
            } else
                throw new PLp1Error("Applied length to non-list");
        }

        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class IsNumber extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args)
                throws PLp1Error {
            Value op = args.get(0);

            return factory.makeValue(ValueType.BOOL).addValue(op instanceof IntValue || op instanceof FloatValue);
        }

        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class First extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            Value L = args.get(0);
            
            if (L instanceof ListValue) {
                return ((ListValue) L).first();
            } else 
                throw new PLp1Error("Applied first to non-list");
        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class Rest extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            Value L = args.get(0);
            
            if (L instanceof ListValue) {
                return ((ListValue) L).rest();
            } else 
                throw new PLp1Error("Applied rest to non-list");
        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class InsertElement extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            Value e = args.get(0);
            Value L = args.get(1);
            
            if (L instanceof ListValue) {
                return ((ListValue) L).insert(e);
            } else
                throw new PLp1Error("Applied insert to non-list");
        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class CreateList extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            ListValue L = new ListValue();
            for(Value e: args) {
                L.append(e);
            }
            return L;
        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class IsEmpty extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            Value L = args.get(0);
            if (L instanceof ListValue) {
                BooleanValue result = new BooleanValue();
                result.addValue(((ListValue) L).length() == 0);
                return result;
            } else
                throw new PLp1Error("Applied emptyp to non-list");
        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class IsPair extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            Value L = args.get(0);
            if (L instanceof ListValue) {
                BooleanValue result = new BooleanValue();
                result.addValue(((ListValue) L).length() > 0);
                return result;
            } else
                throw new PLp1Error("Applied pairp to non-list");
        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class IsList extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            Value L = args.get(0);
            BooleanValue result = new BooleanValue();
            result.addValue(L instanceof ListValue);
            return result;

        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class EqualList extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            ListValue L1 = (ListValue) args.get(0);
            ListValue L2 = (ListValue) args.get(1);
            return (new BooleanValue()).addValue(L1.equal(L2)); 
        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    static class Exit extends BuiltinFunction {

        @Override
        public Value invoke(Environment env, List<Value> args) throws PLp1Error {
            System.exit(0);
            throw new PLp1Error("Could not exit interpreter");
            //return factory.makeValue(ValueType.VOID);
        }
        
        @Override
        public Value addValue(Object val) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }


    public BaseEnvironment() {

        super(new ArrayList<String>(), new ArrayList<Value>(), null);

        ArrayList<String> baseVars = new ArrayList<String>();
        ArrayList<Value> baseVals = new ArrayList<Value>();

        baseVars.add("length");
        baseVals.add(new Length());

        baseVars.add("numberp");
        baseVals.add(new IsNumber());

        baseVars.add("first");
        baseVals.add(new First());
        
        baseVars.add("rest");
        baseVals.add(new Rest());

        baseVars.add("insert");
        baseVals.add(new InsertElement());

        baseVars.add("list");
        baseVals.add(new CreateList());

        baseVars.add("emptyp");
        baseVals.add(new IsEmpty());

        baseVars.add("pairp");
        baseVals.add(new IsPair());

        baseVars.add("listp");
        baseVals.add(new IsList());

        baseVars.add("equalp");
        baseVals.add(new EqualList());

        baseVars.add("exit");
        baseVals.add(new Exit());
        
        baseVars.add("true");
        baseVals.add(factory.makeValue(ValueFactory.ValueType.BOOL).addValue(true));
        baseVars.add("false");
        baseVals.add(factory.makeValue(ValueFactory.ValueType.BOOL).addValue(false));
        baseVars.add("nil");
        baseVals.add(factory.makeValue(ValueFactory.ValueType.NULL));

        addToMap(baseVars, baseVals);

    }
}
