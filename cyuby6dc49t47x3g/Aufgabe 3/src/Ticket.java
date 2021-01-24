import java.util.*;

public class Ticket {
	Set<Integer> numbers;
	int ticket;
	Lottery lottery;
	Set<Integer> correct;

	public Ticket(int amountTickets, Lottery lottery){
		this.ticket = amountTickets;
		this.numbers = new HashSet<Integer>();
		this.lottery = lottery;
		this.correct = new HashSet<Integer>();
	}

	public int getNumber() {
		return ticket;
	}

	public Set<Integer> getNumbers() {
		
		return numbers;
	}

	public Set<Integer> getCorrectNumbers() {
		if(!lottery.wasDrawn) throw new IllegalStateException();
		Set<Integer> bi = new HashSet<Integer>();
		for(int i: numbers){
			for(int j: lottery.winningNumbers){
				if(j==i) bi.add(i);
			}
		}
		this.correct = bi;
		return bi;
	}

	public int getPrize() {
		if(!lottery.wasDrawn) throw new IllegalStateException();
		if(correct.size()==0) return 0;
		if(correct.size()==1) return 5;
		if(correct.size()==2) return 5*20;
		if(correct.size()==3) return 5*20*20;
		if(correct.size()==4) return 5*20*20*20;
		if(correct.size()==5) return 5*20*20*20*20;
		if(correct.size()==6) return 5*20*20*20*20*20;
		return 0;
	} 
}
