public class base{
	public static void main(String args[])
	{
		stack s = new stack();
		s.push(10);
		s.push(20);
		s.seek();
		System.out.println(s.pop());
		s.seek();
		StackLinked s1 = new StackLinked();
		s1.push(3,4);
		s1.push(5,6);
		s1.push(7,6);
		s1.push(8,6);
		s1.print();
		
		Tree t1 = new Tree();
		t1.insert(10,4);
		t1.insert(6,5);
		t1.insert(15,4);
		t1.insert(8,8);
		t1.insert(3,7);
		t1.insert(1,13);
		t1.insert(5,13);
		t1.insert(15,13);
		t1.insert(12,13);
		
		System.out.println("InOrder for tree");
		
		t1.InOrder();
		System.out.println("Height for tree is"+t1.Height());
		t1.Del(7);
		System.out.println("After deletion of 7 PreOrder for tree");
		t1.InOrder();
		System.out.println("floor of number "+t1.floor(4));
		System.out.println("floor of number "+t1.floor(9));
		System.out.println("Level Order");
		t1.LevelOrder();
		LinkedList l = new LinkedList();
		l.add(6);
		l.add(3);
		l.add(2);
		l.add(8);
		l.add(7);
		l.add(1);
		l.print();
		l.Rev();
		l.print();
	}
}