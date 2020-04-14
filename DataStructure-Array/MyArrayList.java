import java.util.Arrays;

public class MyArrayList{

	private Object[] myarraylist;
	private int totalElements;

	public MyArrayList(){
		totalElements = 0;
		myarraylist = new Object[10];
	}

	public boolean add(Object obj){
		if (checkIsFull()){
			increaseListSize();
		}
		myarraylist[totalElements] = obj;
		totalElements++;
		return true;
	}

	public boolean add(int index, Object obj){
		if (index > totalElements){
			System.out.println("index out of bound");
			return false;
		}
		if (checkIsFull()){
			increaseListSize();
		}
		if (index < totalElements){
			for (int i = totalElements; i >= index ; i--){
				
				if (i == index){
					myarraylist[i] = obj;
				}
				else{
					myarraylist[i] = myarraylist[i-1];
				}
				
			}
			totalElements++;
			return true;

		}
		return false;
		
	}

	public int size(){
		return totalElements;
	}

	public Object get(int index){
		if (index < 0 || index >= totalElements){
			System.out.println("index out of bound");
		}
		else{
			return myarraylist[index];
		}
		return null;

	}

	public void remove(int index){
		
		if (index >= totalElements){
			System.out.println("index out of bound");
		}
		else {
			for (int i = index; i < totalElements ; i++){
				if (i == totalElements-1 ){
					myarraylist[i] = null;
				}
				else {
					myarraylist[i] = myarraylist[i+1];
				}
			}

			totalElements--;
			System.out.println("index " + index + " removed");
		}
		
	}

	private void increaseListSize(){
        myarraylist = Arrays.copyOf(myarraylist, myarraylist.length*2);
        System.out.println("\nNew length: "+myarraylist.length);
    }

    private boolean checkIsFull(){
    	if (myarraylist.length-totalElements < 5){
    		return true;
    	}
    	return false;
    }




	public static void main(String[] args){
		MyArrayList myObj = new MyArrayList();
		
		System.out.println(myObj.size());

		myObj.add(7, 10); //not going to add to the arraylist
		myObj.add(20);
		myObj.add(30);
		myObj.add(0, 40);
		myObj.add(50);
		myObj.add(60);
		myObj.add(70);
		myObj.add(80);
		System.out.println(myObj.size());

		System.out.println(myObj.get(1));

		myObj.remove(3);
		
		for (int i=0; i<myObj.size(); i++){
			System.out.println(myObj.get(i));
		}
		
	}

}

