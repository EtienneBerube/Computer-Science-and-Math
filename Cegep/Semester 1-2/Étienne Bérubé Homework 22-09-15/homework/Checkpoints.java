package homework;

public class Checkpoints 
{

	public static void main(String[] args) 
	{
		
		
		System.out.println("4.1 \n \n ");
		System.out.println(Math.sqrt(4));
		System.out.println(Math.sin(2*Math.PI));
		System.out.println(Math.cos(2*Math.PI));
		System.out.println(Math.pow(2, 2));
		System.out.println(Math.log(Math.E));
		System.out.println(Math.exp(1));// e^x
		System.out.println(Math.max(2, Math.min(3, 4)));
		System.out.println(Math.rint(-2.5));
		System.out.println(Math.ceil(-2.5));
		System.out.println(Math.floor(-2.5));
		System.out.println("With f " + Math.round(-2.5f));
		System.out.println("without f " + Math.round(-2.5));
		System.out.println(Math.rint(2.5));
		System.out.println(Math.ceil(2.5));
		System.out.println(Math.floor(2.5));
		System.out.println("With f " + Math.round(2.5f));
		System.out.println("without f " + Math.round(2.5));
		System.out.println(Math.round(Math.abs(-2.5)));
		
		
		System.out.println("4.2 \n \n ");
		System.out.println("true");
		
		
		System.out.println("4.3 \n \n ");
		double a = Math.toRadians(47);
		System.out.println(a);
		
		
		System.out.println("4.4 \n \n ");
		double b = Math.toDegrees(Math.PI/7); 
		System.out.println(b);
		
		System.out.println("4.5 \n \n ");
		double c = (int)(Math.random()*21) + 34; 
		System.out.println(c);
		double d = (int)(Math.random()*999);
		System.out.println(d);
		double e = (int)(Math.random()*50)+5.5;
		System.out.println(e);
		
		System.out.println("4.6 \n \n ");
		System.out.println("It is a default class in Java, it is already embeded with it");
		
		System.out.println("4.7 \n \n ");
		double f = Math.log(Math.exp(5.5));
		System.out.println(f);
		double g = Math.exp(Math.log(5.5));
		System.out.println(g);
		double h = Math.asin(Math.sin(Math.PI/6));
		System.out.println(h);
		double i = Math.sin(Math.asin(Math.PI/6));
		System.out.println(i);
		
		
		System.out.println("4.8 \n \n ");
		int j = (int)'1';
		System.out.println(j);
		int k = (int)'A';
		System.out.println(k);
		int l = (int)'B';
		System.out.println(l);
		int m = (int)'a';
		System.out.println(m);
		int n = (int)'b';
		System.out.println(n);
		char o = 40;
		System.out.println(o);
		char p = 59;
		System.out.println(p);
		char q = 79;
		System.out.println(q);
		char r = 85;
		System.out.println(r);
		char s = 90;
		System.out.println(s);
		char t = (char)40;
		System.out.println(t);
		char u = (char)60;
		System.out.println(u);
		char v = (char)71;
		System.out.println(v);
		char w = (char)72;
		System.out.println(w);
		char x = (char)17;
		System.out.println(x);
		
		
		System.out.println("4.9 \n \n "); // not sure about that though
		
		System.out.println("1 and \u345dE and \u3fFa");
		
		System.out.println("4.10 \n \n ");
		
		System.out.println("\\ and \' ");
		
		System.out.println("4.11 \n \n ");
		
		int y = '1';
		System.out.println(y);	
		int z = '1' + '2' * ('4' - '3') + 'b' / 'a';
		System.out.println(z);
		System.out.println((int)('4'-'3')); //verifying stuff
		int aa = 'a';
		System.out.println(aa);
		char ab = 90;
		System.out.println(ab);
		
		System.out.println("4.12 \n \n ");
		
		char ac = 'A';
		int ad = (int)ac;
		System.out.println("yes it gives " + ad);
		
		float ae = 1000.34f;
		int af = (int)ae;
		System.out.println("yes it gives " + af);
		
		double ag = 1000.34;
		int ah = (int)ag;
		System.out.println("yes it gives " + ah);
		
		int ai = 97;
		char aj = (char)ai;
		System.out.println("yes it gives " + aj);
		
		
		System.out.println("4.13 \n \n ");
		
		char ak = 'a';
		char al = 'c';
		System.out.println(ak++);
		System.out.println(++al);
		System.out.println(ak-al);
		
		System.out.println("4.14 \n \n "); // wut
		
		System.out.println((char)(Math.random()*100));
		
		System.out.println("4.15 \n \n ");
				
		System.out.println('a' < 'b');
		System.out.println('a' <= 'b');
		System.out.println('a' > 'b');
		System.out.println('a' >= 'b');
		System.out.println('a' == 'b');
		System.out.println('a' != 'b');
		
		
		
		
		
				
	}

}
