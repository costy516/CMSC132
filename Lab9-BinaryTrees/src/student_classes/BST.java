package student_classes;

import java.util.Iterator;

/**
 * <P>This version of the classic Binary Search Tree is similar
 * to the commonly found textbook implementations. My purpose
 * in creating the lab is to have you practice implementing
 * many commonly-referenced "binary tree" and "binary search tree" algorithms.
 * Note the distinction: not every Binary Tree is a Binary Search Tree. 
 * Hence. some operations belong to <b>all</b> trees (i.e., are shared
 * by all directed di-graphs), such as counting the number of nodes contained
 * in the tree, obtaining a left or right subtree, determining if a tree is a
 * leaf, etc. Other operations, however, only make sense in the setting 
 * of a Binary Search Tree, such as insertion, deletion, and searching because
 * in the case of BSTs, some ordering relation has been specified and this guides
 * the structure of the tree itself.
 *</P>
 *<br>
 *<h1>Differences/Exceptional Requirements</h1>
 *<br>
 * You will first implement a generic <code>BinaryTree</code> class that is
 * parameterized on general types (objects). This class must provide a handful
 * of "structural" operations, such as retrieving left and right branches, retrieving
 * values from the root (topmost node of a tree), and a handful of predicates.
 * <br>
 * Your BST must <em>extend</em> the <code>BinaryTree</code> class, and
 * must, in addition, restrict the values that may reside within the BST to
 * homogeneous Comparable types. implementation must accept any homogeneous, 
 * <code>Comparable</code> objects as values. The
 * construction algorithm should treat place values
 * that are less than or equal to the root to the
 * left, and those greater to the right. Duplications
 * will be permitted.
 * <h2>Additional Static Method required</h2>
 * In addition to the "standard" dynamic methods (and those inherited from the
 * <code>BinaryTree</code> class), you must implement a <code>static</code> method
 * called <code>isBST(BinaryTree tree)</code> that returns <code>true</code> iff
 * <code>tree</code> satisfies all of the requirements for a Binary Search Tree (as
 * we've defined it):
 * <ul>
 * <li> It is empty;</li>
 * <li> It is a leaf node (contains no left or right children); or,</li>
 * <li> It is a binary tree whose left elements are less than or equal to its root,
 * and its right elements are greater than its root value.</li>
 * </ul>
 * 
 * <P>
 * Finally, your implementation should provide an
 * <code>Iterator</code> that allows users to iterate
 * through the nodes of a BST <em>in sort order</em>, i.e., 
 * the order in which nodes values' should be presented
 * by the Iterator must correspond to their <em>natural ordering</em>
 * as determined by the <code>compareTo</code> method.
 * @author UMD CS Department
 *
 * @param <T>
 */
