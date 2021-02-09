
class RunnyStack <Base> {
	private Run top;
	private int depth;
	private int runs;
	private boolean isEqual(Base field1, Base field2) {
		if(field1 == null)
			return(field1 == field2);
		return(field1.equals(field2));
	}
	public RunnyStack() {
		top = null;
		depth=0;
		runs=0;
	}
	public int depth() {
		return(depth);
	}
	public boolean isEmpty() {
		return(depth==0);
	}
	public Base peek() {
		if(isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return(top.base);
	}
	public void pop() {
		if(isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		depth--;
		if(top.length>1) {
			top.length --;
		} else {
			top=top.next;
			runs--;
		}
		
	}
	public void push(Base base) {
		depth++;
		if(top==null||!isEqual(base,top.base)) {
			top = new Run(base,1,top);
			runs++;
		} else {
			top.length++;
		}
		
	}
	public int runs() {
		return(runs);
	}
	private class Run{
		private Base base;
		private int length;
		private Run next;
		private Run(Base base, int length, Run next) {
			this.base = base;
			this.length = length;
			this.next = next;
		}
	}
}