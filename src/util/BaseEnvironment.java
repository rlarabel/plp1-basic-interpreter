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
            } else {
                throw new PLp1Error("Applied length to non-list");
            }
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



    public BaseEnvironment() {

        super(new ArrayList<String>(), new ArrayList<Value>(), null);

        ArrayList<String> baseVars = new ArrayList<String>();
        ArrayList<Value> baseVals = new ArrayList<Value>();

        baseVars.add("length");
        baseVals.add(new Length());

        baseVars.add("numberp");
        baseVals.add(new IsNumber());

        
        baseVars.add("true");
        baseVals.add(factory.makeValue(ValueFactory.ValueType.BOOL).addValue(true));
        baseVars.add("false");
        baseVals.add(factory.makeValue(ValueFactory.ValueType.BOOL).addValue(false));
        baseVars.add("nil");
        baseVals.add(factory.makeValue(ValueFactory.ValueType.NULL));
        baseVars.add("int");
        baseVals.add(factory.makeValue(ValueFactory.ValueType.INT));


        addToMap(baseVars, baseVals);

    }
}
