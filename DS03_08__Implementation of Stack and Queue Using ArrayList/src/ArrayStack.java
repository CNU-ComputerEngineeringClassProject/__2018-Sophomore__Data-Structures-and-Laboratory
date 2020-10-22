import java.util.ArrayList;


public class ArrayStack implements Stack {

	ArrayList<Object> aStack = new ArrayList<Object>();
	//ũ�⸦ �ڵ����� ���ִϱ� full�� ������ �ʿ䰡 ����.

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(aStack.isEmpty()) {
			System.out.print("Stack�� ����ֽ��ϴ�. : ");
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
			System.out.print("Stack�� ����ֽ��ϴ�. : ");
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
