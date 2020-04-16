import java.util.ArrayList;

class MyHashTable{

	private Object[] myHT;
	


	public MyHashTable(){

		myHT = new Object(50);
	}

	private hash(key) {
	    int hash = 0;
	    for (int i =0; i < key.length; i++){
	        hash = (hash + key.charCodeAt(i) * i) % 50
	    }
	    return hash;
	}

	public set(key, value){
		int address = hash(key);
		if(myHT[address] == null) {}
	}


	// set(key, value) {
 //    let address = this._hash(key);
 //    if (!this.data[address]) {
 //      this.data[address] = [];
 //    }
 //    this.data[address].push([key, value]);
 //    return this.data;
 //  } //O(1)





	public statis void main(String[] args){

		MyHashTable myHashTable = new MyHashTable();
		myHashTable.set('grapes', 10000);
		myHashTable.set('grapes', 10000);
		myHashTable.get('grapes');
		myHashTable.set('apples', 9);
		myHashTable.get('apples');
		myHashTable.keys();

	}
}