import java.util.*;

public class Lottery {
	int maxNumber;
	int manyTickets = 0;
	Set<Integer> winningNumbers;
	boolean wasDrawn;

	public Lottery(int maxNumber) {
		if (maxNumber < 6)
			throw new IllegalArgumentException();
		this.maxNumber = maxNumber;
		this.winningNumbers = new HashSet<Integer>();
	}

	public Ticket buyTicket(int[] numbers) {
		// TODO
		if(wasDrawn) throw new IllegalStateException();
		if (numbers.length != 6)
			throw new IllegalArgumentException();
		Set<Integer> c = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 1 || numbers[i] > maxNumber)
				throw new IllegalArgumentException();
			if (c.contains(numbers[i]))
				throw new IllegalArgumentException();
			c.add(numbers[i]);
		}
		Ticket t = new Ticket(++manyTickets, this);
		for (int i = 0; i < numbers.length; i++) {
			t.numbers.add(numbers[i]);
		}
		return t;
	}

	public int soldTickets() {
		return manyTickets;
	}

	public void draw() {
		if(wasDrawn) throw new IllegalStateException();
		wasDrawn = true;
		while(winningNumbers.size() < 6){
			int next = (int)(Math.random()*maxNumber);
			next++;
			while(winningNumbers.contains(next)){
				next = (int)( Math.random() *maxNumber)+1;
			}
			winningNumbers.add(next);
		}
	}

	public Set<Integer> getWinning() {
		if(!wasDrawn) throw new IllegalStateException();
		return winningNumbers;
	}
}
