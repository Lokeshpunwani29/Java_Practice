class A
{
	public void Aprint()
	{
		System.out.println("Hello this is A Class");
	}
	static class B
	{
		static{
		    System.out.println("I will Automatically Executes for static context"); // Like a constructor for static context.
		}                                                                           // Called Static Block
		
		static public void Bprint()
		{
			System.out.println("Hello this is B Class");
		}
	}
}


class Hello
{
	public void printHello()
	{
		System.out.println("Hello from Class Hello");
	}

	class AgainHello
	{
		public void againPrintHello()
		{
			System.out.println("Again Hello from Class Again Hello");
		}
	}
}

public class StaticExplain
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Hello o = new Hello();
		Hello.AgainHello obj = o.new AgainHello(); // Without Using Inner Static Class we required instance of outer class.
		obj.againPrintHello();
		A.B.Bprint();
	}
}
