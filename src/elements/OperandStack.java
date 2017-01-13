package elements;

import exceptions.StackException;

public class OperandStack {
	
	public static final int MAX_STACK = 100;
	 private int[] stack;
	 private int numElems;
	 
	public OperandStack(){
		this.numElems=0;
		this.stack = new int[OperandStack.MAX_STACK];
	}
	
	public int getNumElems(){
		return this.numElems;
	}
	public boolean isEmpty(){
		if (this.numElems == 0) return true;
		else return false;
	}
	
	public int pop() throws StackException{  //out
		int a;
		if(isEmpty()){
			throw new StackException("Pila vacia.");
		} 
		else {
			a = this.stack[this.numElems-1];
			this.numElems--;
			return a;
		}
	}
	
	public boolean push(int value) throws StackException{
		if(this.numElems == this.stack.length){
			throw new StackException("Pila vacia.");
		}
		else {
			this.stack[this.numElems] = value;
			this.numElems++;
			return true;
		}
	}
	
	public String toString(){
		if (isEmpty()) return "<vacia>";
		 else {
		 String s="";
		 for (int i=0; i < this.numElems; i++) s = s + this.stack[i] + " ";
		 return s;
		 }
	}
}
