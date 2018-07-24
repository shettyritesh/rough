package yelp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestSolution {

	@Test
	public void testSortBusinessesByRating() {
		Solution sol= new Solution();
		List<BusinessInfo> list = new ArrayList<BusinessInfo>();
		BusinessInfo bus= new BusinessInfo();
		bus= new BusinessInfo();
		bus.rating=4;
		bus.id=6;
		list.add(bus);
		bus= new BusinessInfo();
		bus.rating=1;
		bus.id=4;
		list.add(bus);
		bus= new BusinessInfo();
		bus.rating=3;
		bus.id=3;
		list.add(bus);
		bus= new BusinessInfo();
		bus.rating=5;
		bus.id=1;
		list.add(bus);
		bus= new BusinessInfo();
		bus.rating=4;
		bus.id=2;

		
		list.add(bus);
		for(BusinessInfo item:list) {
			System.out.println(item.id+"   " +item.rating);
		}
		System.out.println();
		System.out.println();
		List<BusinessInfo> oplist=Solution.sortBusinessesByRating(list);

		for(BusinessInfo item:oplist) {
			System.out.println(item.id+"   " +item.rating);
		}
		System.out.println();
		System.out.println();		
		for(BusinessInfo item:list) {
			System.out.println(item.id+"   " +item.rating);
		}	

	}

}
