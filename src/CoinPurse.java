import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

public class CoinPurse {

	public static void main(String[] args) {

		MyCoin first = new MyCoin(Coin.PENNY);
		MyCoin second = new MyCoin(Coin.PENNY);
		MyCoin third = new MyCoin(Coin.DIME);
		

		if (first == second) {
			System.out.println("Same");
		}

		if (first.equals(second)) {
			System.out.println("Same Again");
		}

		 List<MyCoin> list= new ArrayList<MyCoin>();
		 list.add(first);
		 list.add(second);
		 list.add(third);
		 HashSet<MyCoin> mycoins= new HashSet<>();
		 mycoins.addAll(list);
		 Set<Set<MyCoin>>setresult= Sets.powerSet(mycoins);
		 for(Set<MyCoin> setofmycoins:setresult) {
			 
			 for(MyCoin resmycoin:setofmycoins) {
				 System.out.print(resmycoin.getCoin().getValue()+" ");
			 }
			 System.out.println("");
		 }
		 

	}

}
// 1 , 1 ,1

// 1 , 2,3

enum Coin {
	PENNY(1), DIME(10), HALF_DOLLAR(50);
	int val;

	Coin() {

	}

	Coin(int key) {
		val = key;
	}

	int getValue() {
		return val;
	}

}

class MyCoin {
	Coin coin;
	public MyCoin(Coin thatcoin) {
		coin=thatcoin;
	}
	public Coin getCoin(){
		return coin;
	}
}
