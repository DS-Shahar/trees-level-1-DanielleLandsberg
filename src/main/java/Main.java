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


////////////////////////////////////////////////
	public static void main(String[] args) { 
	    BinNode<Double> root = new BinNode<>(50.0);
        root.setLeft(new BinNode<>(5.0));
        root.setRight(new BinNode<>(120.0));

        root.getLeft().setLeft(new BinNode<>(10.0));
        root.getLeft().setRight(new BinNode<>(99.0));
        root.getRight().setLeft(new BinNode<>(15.0));

        int result = countInRange(root);
        System.out.println(result);  // אמור להדפיס: 4
        System.out.println(countLeafs(root));
}
}
	    
