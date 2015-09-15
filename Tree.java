class Tree
{
	class Node
	{
		int value,key,count;
		Node left,right;
		Node()
		{
			value = 0;
			key = 0;
			left = null;
			right = null;
		}
		Node(int key,int value)
		{
			count=1;
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
		void print()
		{
			System.out.println("key = "+ key+" value = "+value);
		}
	}
	private Node start = null;
	Node getNode(int key)
	{
		getNode(start,key);
	}
	Node getNode(Node root,int key)
	{
		if(root == null)
			return null;
		if(key<root.key)
			return getNode(root.left)
		else if(key>root.key) return getNode(root.right);
		else return root;
	}
	
	int getHd(Node n)
	{
		Node ptr = start;
		return HorizontalDistance(ptr,n);
	}
	HorizontalDistance(Node ptr)
	{
		if(ptr==null) return 0;
		if(ptr.key<n.key) return HorizontalDistance(ptr.left)-1;
		else if(ptr.key>n.key) return HorizontalDistance(ptr.right)+1;
		else return 0;
			
	}
	
	void insert(int key,int value)
	{
		start = ins(start,key,value);
		/*Node ptr = start;
		if(ptr==null)
		{
			Node n = new Node(key,value);
			start = n;
		}
		else
		{
			while(true)
			{
				if(ptr.key>key)
				{
					if(ptr.right!=null)
						ptr = ptr.right;
					else
					{
						Node n = new Node(key,value);
						ptr.right =n;
						break;
					}
					
				}
				else if(ptr.key<key)
				{
					if(ptr.left!=null)
						ptr = ptr.left;
					else
					{
						Node n = new Node(key,value);
						ptr.left =n;
						break;
					}
				}
				else
				{
					ptr.value = value;
					break;
				}
				
			}
		}*/
	}
	private Node ins(Node ptr ,int key,int value)
	{
		if(ptr==null)
		{
			Node n = new Node(key,value);
			return n;
		}
		if(key<ptr.key) ptr.left = ins(ptr.left,key,value);
		else if(key>ptr.key) ptr.right = ins(ptr.right,key,value);
		else ptr.value = value;
		ptr.count = 1 + size(ptr.left)+ size(ptr.right);
		return ptr;
	}
	void PreOrder()
	{
		pre(start);
	}
	private void pre(Node ptr)
	{
		if(ptr==null)
			return;
		System.out.println("key  = "+ptr.key+" value = "+ptr.value+" count  = "+ptr.count);
		pre(ptr.left);
		pre(ptr.right);
	}
	void PostOrder()
	{
		post(start);
	}
	private void post(Node ptr)
	{
		if(ptr==null)
			return;
		post(ptr.left);
		post(ptr.right);
		System.out.println("key  = "+ptr.key+" value = "+ptr.value+" count  = "+ptr.count);
		
	}
	void InOrder()
	{
		In(start);
	}
	private void In(Node ptr)
	{
		if(ptr==null)
			return;
		In(ptr.left);
		System.out.println("key  = "+ptr.key+" value = "+ptr.value+" count  = "+ptr.count);
		In(ptr.right);
	}
	private int size(Node n)
	{
		if(n==null)
			return 0;
		return 1+size(n.left)+size(n.right);
	}
	int Height()
	{
		return Hei(start);
	}
	private int Hei(Node ptr)
	{
		if(ptr==null)
			return -1;
		return 1+max(Hei(ptr.left),Hei(ptr.right));
	}
	private int max(int a,int b)
	{
		return a>b?a:b;
	}
	private Node min(Node n)
	{
		if(n==null)
			return null;
		if(n.left==null)
			return n;
		return min(n.left);
	}
	private Node DelMin(Node n)
	{
		if(n.left==null) return n.right;
		n.left = DelMin(n.left);
		return n;
	}
	void Del(int key)
	{
		start = delete(start,key);
	}
	private Node delete(Node x,int key)
	{
		if(x==null) return null;
		if(key<x.key) x.left = delete(x.left,key);
		else if(key>x.key) x.right = delete(x.right,key);
		else
		{
			if(x.left == null) return x.right;
			if(x.right == null) return x.left;
			Node t = x;
			x = min(x.right);
			x.right=DelMin(t.right);
			x.left = t.left;
			return x;
		}
		x.count = 1+size(x.left)+size(x.right);
		return x;
	}
	int floor(int key)
	{
		return Floor(start,key);
	}
	private int Floor(Node ptr,int key)
	{
		int num;
		if(ptr==null) return -1;
		if(ptr.key==key)
			return ptr.value;	
		else if(key<ptr.key)
			num = Floor(ptr.left,key);
		else 
			num = Floor(ptr.right,key);
		if(num==-1)
		{
			if(key<ptr.key)
				return -1;
			return ptr.value;
		}
		else
			return num;
	}
	
	
	//level order
	
	void LevelOrder()
	{
		Node ptr = start;
		Queue q = new Queue();
		q.append(start);
		while(!(q.isEmpty()))
		{
			ptr = q.remove();
			if(ptr.left!=null)
				q.append(ptr.left);
			if(ptr.right!=null)
				q.append(ptr.right);
			System.out.println("key  = "+ptr.key+" value = "+ptr.value+" count  = "+ptr.count);
		
		}
	}
	class Queue
	{
		Node n;
		Queue next,end,start;
		void append(Node n)
	{
		Queue q = new Queue();
		q.n = n;
		if(end!=null)
		{
			end.next = q;
			end = end.next;
		}
		else
		{
			end = q;
			start = end;
		}
	}
	Node remove()
	{
		if(start==null)
			return null;
		else if(start==end)
		{
			Queue ptr = start;
			start = null;
			end = null;
			return ptr.n;
		}
		else
		{
			Queue ptr = start;
			start = start.next;
			return ptr.n;
		}
	}
	boolean isEmpty()
	{
		if(end==null)
			return true;
		return false;
	}
	}
	
	
	
}
