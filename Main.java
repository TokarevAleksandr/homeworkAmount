package sample;

public class Main {

	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		int array[] = new int[100000000];
		
		int sum = 0;
	
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 13);
		}
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println(sum);
		System.out.println("Время работы в однопоточном режиме - " + ((double)System.currentTimeMillis() - time1) + " миллисекунд");

		long time2 = System.currentTimeMillis();
		int arr[] = new int[100000000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 13);
		}

		Amount thOne = new Amount(arr, 0, 25000000);

		Amount thTwo = new Amount(arr, 25000000, 50000000);

		Amount thThree = new Amount(arr, 50000000, 75000000);

		Amount thFour = new Amount(arr, 75000000, 99999999);

		Thread One = new Thread(thOne);

		Thread Two = new Thread(thTwo);

		Thread Three = new Thread(thThree);

		Thread Four = new Thread(thFour);

		One.start();

		Two.start();

		Three.start();

		Four.start();

		try {
			One.join();

			Two.join();

			Three.join();

			Four.join();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		long t = thOne.getSum() + thTwo.getSum() + thThree.getSum() + thFour.getSum();

		System.out.println("Общая сумма = "+ t);
		System.out.println("Время работы в многопоточном режиме - " + ((double)System.currentTimeMillis() - time2) + " миллисекунд");
		
	}
}