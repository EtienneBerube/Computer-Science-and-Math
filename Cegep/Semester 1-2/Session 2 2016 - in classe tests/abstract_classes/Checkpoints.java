package abstract_classes;

public class Checkpoints {
	public static void main(String[] args) {
		Number x = new Integer(3);
		System.out.println(x.intValue());
		System.out.println(((Integer) x).compareTo(new Integer(4)));
		
		Integer n1 = new Integer(3);
		Object n2 = new Integer(4);
		System.out.println(n1.compareTo((Integer)n2));
		String y = "k";
		String z = "k";
		y.compareTo(z);
		
		
		}
}
/*
 * 13.1) e,f
 * 
 * 13.2) no need to cast while doing some generic programming and is cleaner. Also, the program could not 
 * compare the areas if it wouldnt have been an abstratc method
 * 
 * 13.3) false (Can be used as datatype with new keyword), true, true, false, true
 * 
 * 13.4) Because 0 is an Integer and cannot be casted in a double since it is not. And initially it was an integer
 * 
 * 13.5) GO SEE TEAHCER!!! i think it is beacause the actual type is INteger so it cannot be filled with doubles
 * 
 * 13.6) 3, 3.0
 * 
 * 13.7) it needs to be casted into an integer because now it is declared as a Number
 * 
 * 13.8) it is not x that is casted into an Integer, it is the whole expression
 * 
 * 13.13) no
 * 
 * 13.14) yes
 * 
 * 13.15) d (GO SEE TEACHER)
 * 
 * 13.16) Cannot reduce the visbility since an interface is always public abstract
 * 
 * 13.17) true
 * 
 * 13.18) First one (GO SEE TEACHER)
 * 
 * 13.19) n2 needs to be casted
 * 
 * 13.20) You can decide what does the method do
 * 
 * 13.21) it is not an instance of the Comparable interface
 * 
 * 20.1) In object-oriented thinking, a data structure, also known as a container or container object,
 * is an object that stores other objects, referred to as data or elements.
 * 
 * 20.2) Collection is the dad of every other class. It has some interfaces under his reign 
 * which are list, queu and stacks
 * 
 * 20.3) yes
 * 
 * 20.4) clone... (GO SEE TEACHER) addAll()
 * 
 * 20.5) when a method has no link with a subclass
 * 
 * 20.6) to traverse all the objects in the collection
 * 
 * 20.7)interator.next()
 * 
 * 20.8) yes (GO SEE TEACHER) or only Interators
 * 
 * 20.9) no
 * 
 * 20.10).add(), .nextIndex(), .previous(), next()
 * 
 * 20.11) a) red yellow green red yellow blue (GO SEE TEACHER)
 * 		  b) crash
 * 		  c) 
 * 		  d)
 * 		  e)
 * 		  f)
 * 
 * 20.12) linked list is dynamic and patchs the holes. Linked list
 * 
 * 20.13) no. addfirst() addlast(). and other methods to access the first or last elements
 * 
 * 20.14) LinkedList<Objects> list = new linkedList<>(arrayOfObject);
 * 
 * 20.15)Comparator can be used without implementing Comparable, java.util.
 * 
 * 20.16) class A implements Comparable
 *, yes
 *class B implements comparator<B>
 *
 *@override
 *public int compare(B x);
 * 
 * 20.17) yes
 * 
 * 20.18)
 * collection: suffle, frequency, disjoint
 * list: binarySearch, min, max, sort
 * 
 * 20.19)blue, green, red, yellow
 * white black green blue
 * true
 * false
 * 2		
 * 
 * 20.20) sort()
 * sort(). // GO SEE TEACHER
 * 
 * 20.21) binarySearch
 * binarySearch(,,,comparator<String>)
 * 
 * 20.22).max()
 * 
 * 20.23) OberservableList<Node>
 * 
 * 20.24)no idea
 * 
 * 20.25)no idea
 * 
 * 20.26)new Vector();
 * 	addElement()
 * capacity
 * 
 * 20.27) new Stack();
 * push();
 * pop all of the elements of the stack
 * 
 * 20.28) //Go see teacher (clone)
 * 
 * 20.29) Yes, yes
 * 
 * 20.30) PriorityQueue<Integer> = new PriorityQueue<>();
 * 		  natural order (compareto())	
 * 		  highest
 * 
 * 20.31) PriorityQueue<Integer> = new PriorityQueue<>(n, new ComparatorReverseNaturalOrder());
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */