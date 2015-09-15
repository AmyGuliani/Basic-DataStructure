
public class HashMap{
	HashNode map[];
	int size;
	HashMap()
	{
		size = 100;
		map = new HashNode[100];
		for(int i=0;i<size;i++)
		{
			map[i]=null;
		}
	}
	HashMap(int size)
	{
		map = new HashNode[size];
		for(int i=0;i<size;i++) map[i]=null;

	}
	void put(int key,int value)
	{
		int k = key%100;
		if(map[k]==null)
		{
			map[k] = new HashNode(key,value);
			return;
		}
		HashNode ptr = map[k];
		while(ptr.next!=null)
		{
			ptr = ptr.next;
		}
		ptr.next = new HashNode(key,value);
	}
	int get(int key)
	{
		int k = key%100;
		if(map[k]==null)
		{
			return -1;
		}
		else
		{
			if(key == map[k].getKey())
				return map[k].getValue();
		}
		HashNode ptr = map[k];
		
		while(ptr!=null)
		{
			if(ptr.getKey()==key)
				return ptr.getValue();
			ptr = ptr.next;
		}
		return -1;
	}
	void print()
	{
		for(int i=0;i<size;i++)
		{
			if(map[i]!=null)
			{
				HashNode ptr = map[i];
				while(ptr!=null)
				{
					System.out.print("key = "+ptr.getKey()+" value = "+ptr.getValue()+" ");
					ptr = ptr.next;
				}
				System.out.println();
			}
		}
	}
	class HashNode
	{
		private int key,value;
		HashNode next= null;
		HashNode(){
		}
		HashNode(int key,int value)
		{
			this.key = key;
			this.value = value;
		}
		int getKey()
		{
			return this.key;
		}
		int getValue()
		{
			return this.value;
		}
	}
}