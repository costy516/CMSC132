package student_classes;
/**
 * Common "base class" for any and all directed di-graphs (or, what we will
 * be creating in this class). This class is extended by the Binary Search Tree
 * class (qv), and therefore relies upon some of its properties (indirectly) and
 * methods. Note that all of the methods belonging to this class address
 * the <emph>structure</emph> of the tree a di-graph, i.e., independently of what
 * values might be stored at these locations. In other words: the operations defined
 * by this class are common to all directed di-graphs, which means that they are
 * appropriate to the BST (binary search tree) that you will be required to define
 * using this as a base class. 
 * <br>
 * <P>Observe that the signatures for many of the methods on this class return
 * <emph>subtree</emph>s and <b>never</b> <code>BTNode</code>s. This ensures that
 * clients never know anything about the underlying representation of these objects
 * or any of their descendants. </P>
 * @author UMD CS Dept.
 *
 * @param <T>
 */
public class BinaryTree<T> {
	
	class BTNode {
		T	value;
		BTNode left, right;
		
		BTNode( T val, BTNode l, BTNode r ) {
			this.value = val;
			this.left = l;
			this.right = r;
		}
		
		BTNode( T val ) {
			this( val, null, null );
		}
		
	} // closes class BTNode
	/*
	 * You may choose to rename this private and use the public accessors, 
	 * or you may leave this protected and use a mixture of public accessors
	 * and/or direct field references.
	 */
	protected BTNode root=null;
	
	
}

