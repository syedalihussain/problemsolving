package O.Quantifi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MovingTotal {

	private HashSet<Integer> set;
	private Queue<Integer> queue;
	private int movingTotal;

	public MovingTotal() {
		set = new HashSet<>();
		queue = new LinkedList<>();
		movingTotal = 0;
	}

	public void append(int[] array) {
		for (int i = 0; i < array.length; i++) {
			movingTotal += array[i];
			queue.add(array[i]);
			if (queue.size() == 3) {
				set.add(movingTotal);
				movingTotal -= queue.remove();
			}
		}
	}

	public boolean contains(int num) {
		return set.contains(num);
	}
	public static void main(String[] args) {

		MovingTotal movingTotal = new MovingTotal();

		movingTotal.append(new int[]{1, 2, 3});

		System.out.println(movingTotal.contains(6));
		System.out.println(movingTotal.contains(9));

		movingTotal.append(new int[]{4});
		System.out.println(movingTotal.contains(9));

	}
}
