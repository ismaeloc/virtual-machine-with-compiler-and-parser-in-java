package elements;

public class Memory {
	private Integer[] memory;
	private int size;
	private final static int MAX_MEM = 200;
	private boolean empty;

	public Memory() {
		this.empty = true;
		this.memory = new Integer[Memory.MAX_MEM];
		this.size = Memory.MAX_MEM;
		for (int i = 0; i < this.size; i++)
			this.memory[i] = null;
	}

	public int getSize() {
		return this.size;
	}

	public boolean write(int pos, int value) {
		if (pos < 0) {
			return false;
		} else if (pos >= this.memory.length) {
			resize(pos);
		}
		this.memory[pos] = value;
		this.empty = false; // Ya no esta vacia
		return true;
	}

	public int read(int pos) {

		if (this.memory[pos] != null) {
			return this.memory[pos];
		} else {
			return 0;
		}
	}

	private void resize(int pos) {

		Integer[] newMemory = new Integer[pos * 2];

		for (int i = 0; i < this.size; i++)
			newMemory[i] = this.memory[i];
		this.size = pos * 2;
		this.memory = newMemory;
	}

	public String toString() {
		String s = "";
		if (this.empty)
			return "<vacia>";
		else {
			for (int i = 0; i < this.size; i++)
				if (this.memory[i] != null)
					s = s + " [" + i + "]:" + this.memory[i];
		}
		return s;
	}
}
