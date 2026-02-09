//
import java.util.*;
public class Main
{
	static Scanner reader = new Scanner(System.in);
/*public static void printEven(BinNode<Integer> t) {
    if (t==null)
    return;
    
if(t.getValue()%2==0&&(!t.hasLeft()||t.getLeft().getValue()%2==0)&&(!t.hasRight()||t.getRight().getValue()%2==0)) {
    System.out.println(t.getValue());
}
printEven(t.getLeft(t));
printEven();
}*/
public static int countInRange(BinNode<Double> root) { //O(n) //12
    if (root == null) {
        return 0;
    }

    int result = 0;

    if (root.getValue() >= 10 && root.getValue() < 100) {
        result = 1;
    }

    result += countInRange(root.getLeft());
    result += countInRange(root.getRight());

    return result;
}


///////////////////////////////////////////////////////////////
public static int countLeafs(BinNode<Double> tree) { //O(n) //14
    if (tree==null)
    return 0;
      if (tree.getLeft() == null && tree.getRight() == null)
        return 1;

    return countLeafs(tree.getLeft()) + countLeafs(tree.getRight());
    
}
/////////////////////////////////////////////////////////////
public static double twoSons(BinNode<Double> tree) { // O(n) //16
    if (tree == null)
        return 0;

    double sum = 0;

    if (tree.getLeft() != null && tree.getRight() != null) {
        sum = tree.getValue();
    }

    sum += twoSons(tree.getLeft());
    sum += twoSons(tree.getRight());

    return sum;
}
/////////////////////////////////////////////////////
public static double twoSonsNotLeaf(BinNode<Double> tree) { // O(n) //17
    if (tree == null)
        return 0;

    double sum = 0;

    if (tree.getLeft() != null && tree.getRight() != null) {
        sum = tree.getValue();
    }

    sum += twoSons(tree.getLeft());
    sum += twoSons(tree.getRight());

    return sum;
}
////////////////////////////////////////////////
public static boolean isT2inT1(BinNode<Integer> t1, BinNode<Integer> t2) { //18 O(n^2)
    if (t2 == null)
        return true;

    if (!search(t1, t2.getValue()))
        return false;

    return isT2inT1(t1, t2.getLeft()) && isT2inT1(t1, t2.getRight());
}

public static boolean search(BinNode<Integer> t, int value) {
    if (t == null)
        return false;

    if (t.getValue() == value)
        return true;

    return search(t.getLeft(), value) || search(t.getRight(), value);
}
///////////////////////////////////
public static boolean ex20(BinNode t1, int n) { //ex20 O(n)
    if (n<1)
    return true;
   if (!search(t1, n))
        return false;
   return ex20(t1, n-1); 
}
///////////////////////////////////////////////
public static int count(BinNode<Integer> t, int n) { //count
if (t==null) {
    return 0; 
}
if (t.getValue()==n) {
    return 1+count(t.getLeft(),n)+count(t.getRight(),n);
}
return count(t.getLeft(),n)+count(t.getRight(),n);
}
/////////////////////////////////////////////////a 23
public static Double ex23Max(BinNode<Double> t) {
    if (t == null) {
        return 0.0;  
    }
    return Math.max(t.getValue(), Math.max(ex23(t.getLeft()), ex23(t.getRight())));
}
//////////////////////////////////////////////////b 23
public static Double ex23Mini(BinNode<Double> t) {
    if (t == null) {
        return 1000000000.0;  
    }
    return Math.min(t.getValue(), Math.min(ex23(t.getLeft()), ex23(t.getRight())));
}
//////////////////////////////////////////////c ex23
public static Double ex23(BinNode<Double> t) {
    return ex23Max(t)-ex23Mini(t); 
} 
///////////////////////////////////////////////ex 27 
public static <T> int treeHeight(BinNode<T> root) {
    if (root == null) {
        return 0;  // 
    }

    int leftHeight = treeHeight(root.getLeft());
    int rightHeight = treeHeight(root.getRight());

    return 1 + Math.max(leftHeight, rightHeight);
}
////////////////////////////////////////////////
public static <T> boolean wholeTree(BinNode<T> root) { //26
        int n = treeHeight(root);
        if ((countLeafs((BinNode<Double>) root)) == Math.pow(2, n)) {
            return true;
        }
        return false;
    }
    ///////////////////////////////////////////
public static <T> boolean ex22(BinNode<T> t) { //22
if (t.getValue()==null) {
    return true;
}
        if (((t.getLeft()!=null )&&(t.getRight()!=null))||(t.getLeft()==null&&t.getRight()==null)) {
            return ex22(t.getRight())&&ex22(t.getLeft());
        }
        return false;
    }
////////////////////////////////////////////////
public static boolean ex21(BinNode<Integer> t) {
    if (t==null)
    return true;

if (Math.abs(treeHeight(t.getLeft())-treeHight(t.getRight()))<1)
return true;
return ex21(t.getLeft())&&ex21(t.getRight());
}
///////////////////////////////////////////////
	public static void main(String[] args) { 
	      BinNode<Double> root = new BinNode<>(50.0);
        root.setLeft(new BinNode<>(5.0));
        root.setRight(new BinNode<>(120.0));

        root.getLeft().setLeft(new BinNode<>(10.0));
        root.getLeft().setRight(new BinNode<>(99.0));
        root.getRight().setLeft(new BinNode<>(15.0));

        
        int result1 = countInRange(root);
        System.out.println("Nodes with values between 10 and 100: " + result1);  // Should print: 4

        int result2 = countLeafs(root);
        System.out.println("Number of leaf nodes: " + result2);  // Should print: 3

        double result3 = twoSons(root);
        System.out.println("Sum of nodes with two children: " + result3);  // Should print: sum of relevant nodes

        double result4 = twoSonsNotLeaf(root);
        System.out.println("Sum of non-leaf nodes with two children: " + result4);  // Should print: sum of non-leaf nodes

        BinNode<Integer> t1 = new BinNode<>(1);
        t1.setLeft(new BinNode<>(2));
        t1.setRight(new BinNode<>(3));
        t1.getLeft().setLeft(new BinNode<>(4));

        BinNode<Integer> t2 = new BinNode<>(2);
        t2.setLeft(new BinNode<>(4));

        boolean result5 = isT2inT1(t1, t2);
        System.out.println("Is t2 a subtree of t1? " + result5);  // Should print: true

        boolean result6 = ex20(t1, 3);
        System.out.println("Does t1 contain all values from 3 down to 1? " + result6);  // Should print: true

        int result7 = count(t1, 2);
        System.out.println("Occurrences of value 2 in t1: " + result7);  // Should print: 1

        
    
     
}
}
	    
