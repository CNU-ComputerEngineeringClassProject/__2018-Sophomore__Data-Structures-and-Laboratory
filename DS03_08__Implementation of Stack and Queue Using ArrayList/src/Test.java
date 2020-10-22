
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new ArrayStack();
		System.out.println("[Test Stack]");
		stack.push("Monday");
		stack.push("Tuesday");
		stack.push("Wednesday");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push("Thursday");
		stack.push("Friday");
		System.out.println(stack.pop());
		stack.push("Saturday");
		stack.push("Sunday");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(" ");
		
		Queue queue = new ArrayQueue();
		System.out.println("[Test Queue]");
		queue.add("Monday");
		queue.add("Tuesday");
		queue.add("Wednesday");
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add("Thursday");
		queue.add("Friday");
		System.out.println(queue.remove());
		queue.add("Saturday");
		queue.add("Sunday");
		System.out.println(queue.remove());
		System.out.println(queue.remove());

	}

}
