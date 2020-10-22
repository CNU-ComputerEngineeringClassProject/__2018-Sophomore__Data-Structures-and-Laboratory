import java.util.ArrayList;


public class ArrayStack implements Stack {

	ArrayList<Object> aStack = new ArrayList<Object>();
	//크기를 자동으로 해주니까 full을 생각할 필요가 없다.

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(aStack.isEmpty()) {
			System.out.print("Stack이 비어있습니다. : ");
			return null;
		}
		else {
			return aStack.get(size()-1);
		}

	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
	
		if(aStack.isEmpty()) {
			System.out.print("Stack이 비어있습니다. : ");
			return null;
		}
		else {
			 
			return aStack.remove(size()-1);
		}
	}

	@Override
	public void push(Object object) {
		// TODO Auto-generated method stub
		aStack.add(size(),object);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return aStack.size();
	}

}
