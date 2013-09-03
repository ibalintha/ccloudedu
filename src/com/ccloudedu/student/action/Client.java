package com.ccloudedu.student.action;
/************      dxz00ww     **********/
import java.util.*;
abstract class Iterator
{
	public abstract Object First();
	public abstract Object Next();
	public abstract boolean IsDone();
	public abstract Object CurrentItem();
	
} 
abstract class Aggregate
{
	//public abstract Iterator CreatIterator();
}
class ConcreteIterator1 extends Iterator
{
	private ConcreteAggregate aggregate;
	private int current=0;
	public ConcreteIterator1(ConcreteAggregate aggregate)
	{
		this.aggregate=aggregate;
	}
	public Object First()
	{
		return aggregate.get(0);
	}
	public Object Next()
	{
		Object ret=null;
		current++;
		if(current<aggregate.Count())
		{
			ret=aggregate.get(current);
		}
		return ret;
	}
	public boolean IsDone()
	{
		return current>=aggregate.Count()?true:false;
	}
	public Object CurrentItem()
	{
		return aggregate.get(current);
	}
}
class ConcreteIterator2 extends Iterator
{
	private ConcreteAggregate aggregate;
	private int current=0;
	public ConcreteIterator2(ConcreteAggregate aggregate)
	{
		this.aggregate=aggregate;
		current=aggregate.Count()-1;
	}
	public Object First()
	{
		return aggregate.get(aggregate.Count()-1);
	}
	public Object Next()
	{
		Object ret=null;
		current--;
		if(current>=0)
		{
			ret=aggregate.get(current);
		}
		return ret;
	}
	public boolean IsDone()
	{
		return current<0?true:false;
	}
	public Object CurrentItem()
	{
		return aggregate.get(current);
	}
}
class ConcreteAggregate extends Aggregate
{
	private List<Object> items = new LinkedList<Object>();
	//public Iterator CreateIterator()
	//{
		//return new ConcreteIterator1(this);
	//}
	public int Count()
	{
		return items.size();
	}
	public Object get(int m)
	{
		return items.get(m);
	}
	public void set(int m,Object o){
		items.add(m, o);
	}
}
public class Client
{
	public static void main(String args[]){
		ConcreteAggregate a=new ConcreteAggregate();
//		for(int i=0;i<=20;i++){
//			a.set(i, i);
//		}
		a.set(0, 5);
		a.set(1, 3);
		a.set(2, 6);
		a.set(3, 8);
		
		Iterator i=new ConcreteIterator1(a);
		while(!i.IsDone())
		{
			System.out.println(i.CurrentItem());
			i.Next();
		}
		Iterator q=new ConcreteIterator2(a);
		while(!q.IsDone())
		{
			System.out.println(q.CurrentItem());
			q.Next();
		}
	}
}
