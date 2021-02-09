//maymi001
//Benjamin Maymir
class Map<Key, Value> {
	private Key[] keys;
	private Value[] values;
	private int count;
	public Map(int length) {
		if(length<0)
			throw new IllegalArgumentException();
		count = 0;
		keys = (Key[]) new Object[length];
		values = (Value[]) new Object[length];
		
	}
	public Value get(Key key) {
		int temp = where(key);
		if(temp==-1) {
			throw new IllegalArgumentException();
		}
		return(values[temp]);
	}
	private boolean isEqual(Key leftKey, Key rightKey) {
		if(leftKey == null)
			return(leftKey == rightKey);
		return(leftKey.equals(rightKey));
	}
	public boolean isIn(Key key) {
		return((where(key)!=-1));
	}
	public void put(Key key, Value value) {
		int temp = where(key);
		if(temp!=-1) {
			values[temp]=value;
		} else {
			if(count==keys.length) {
				throw new IllegalStateException();
			}
			keys[count]=key;
			values[count]=value;
			count++;
		}
		
	}
	private int where(Key key) {
		int index = count;
		while(index-->0) {
			if(isEqual(key,keys[index])) {
				return(index);
			}
		}
		return(-1);
	}
}

