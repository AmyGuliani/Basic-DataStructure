class Test
{	
	public static void main(String args[])
	{
		HashMap hash = new HashMap();
		hash.put(3,10000);
		hash.put(1003,10000);
		
		hash.put(83,120003);
		hash.put(53,60045);
		hash.put(12,870005);
		hash.put(43,100056);
		hash.put(54,1000045);
		hash.put(65,1000560);
		hash.put(67,100600);
		hash.print();
		System.out.println(hash.get(1003));
	}
}