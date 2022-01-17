package sample;


public class Amount implements Runnable {

	private long sum;

	private int[] arr;

	private int start;

	private int end;

	public Amount (int[] arr, int start, int end) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	public long getSum() {
		return sum;
	}

	public int[] getMas() {
		return arr;
	}

	public void setMas(int[] mas) {
		this.arr = mas;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	private long sum(int[] arr) {
		
		for (int i = start; i <= end; i++) {
			sum += arr[i];
			
		}
		return sum;
		

	}

	@Override
	public void run() {
        Thread th = Thread.currentThread();

		System.out.println("Сумма потока "+ th.getName() + " = " + sum(arr));

	}
}