class GeekQues{
	public static void main(String args[])
	{
		Trees t1,t2;
		t1 = new Trees();
		t2 = new Trees();
		t1.ins(5,4);
		t1.ins(3,2);
		t1.ins(4,3);
		t1.ins(6,8);
		t1.ins(1,9);
		t1.ins(1,19);
		t1.ins(1,7);
		
		t2.ins(5,4);
		t2.ins(3,2);
		t2.ins(3,3);
		t2.ins(6,8);
		t2.ins(1,9);
		IdenticalTrees i = new IdenticalTrees();
		System.out.println(i.check(t1.start,t2.start));
		System.out.println(t1.height());
		t2.inorder();
		t2.mirror();
		System.out.println();
		t2.inorder();
	}
}
class Trees
{
	class Node
	{
		int value,key;
		Node left,right;
	}
	public Node start=null;
	void ins(int value,int key)
	{
		start = insert(start,value,key);
	}
	Node insert(Node ptr,int value,int key)
	{
		
		if(ptr==null)
		{
			Node n = new Node();
			n.value = value;
			n.key = key;
			return n;
		}
		if(ptr.key>key) ptr.left = insert(ptr.left,value,key);
		else if(ptr.key <key) ptr.right = insert(ptr.right,value,key);
		else ptr.value = value;
		return ptr;
	}
	int height()
	{
		return hei(start);
	}
	int hei(Node ptr)
	{
		if(ptr==null)
			return 0;
		int max1 = 1+hei(ptr.left);
		int max2 = 1+ hei(ptr.right);
		return max1>max2?max1:max2;
	}
	void mirror()
	{
		start = mirror(start);
	}
	Node mirror(Node root)
	{
		if(root==null)
			return null ;
		root.left = mirror(root.left);
		root.right = mirror(root.right);
		
		Node ptr = root.left;
		root.left = root.right;
		root.right = ptr;
		return root;
	}
	void inorder()
	{
		inorder(start);
	}
	void inorder(Node ptr)
	{
		if(ptr == null) return ;
		inorder(ptr.left);
		System.out.println(ptr.key);
		inorder(ptr.right);
	}
}
class IdenticalTrees
{
	int check(Trees.Node t1,Trees.Node t2)
	{
		int m,n;
		
		if(t1==null&&t2==null)
			return 1;
		if(t1==null)
			return 0;
		if(t2==null)
			return 0;
		if(t1.value!=t2.value)
			return 0;
		m = check(t1.left,t2.left);
		n = check(t1.right,t2.right);
		if(m == 1 && n == 1)
			return 1;
		else
			return 0;
	}
}