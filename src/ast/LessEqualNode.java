/**
 * 
 */
package ast;

import visitor.Visitor;
import util.PLp1Error;

/**
 * @author carr
 *
 */
public class LessEqualNode extends BinaryNode {

	public LessEqualNode() {
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(patterns.Visitor)
	 */
	@Override
	public Object accept(Visitor<Object> visitor) throws PLp1Error {
		return visitor.visit(this);
	}

}