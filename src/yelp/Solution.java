package yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class BusinessInfo {
	int rating;
	int id;
}

class Solution {

	/**
	 * List of businesses info where each element is a dictionary containing id and
	 * rating. Sort the businesses by their rating in decreasing order. Preserve the
	 * original ordering if two businesses have same rating.
	 *
	 * @param businesses
	 *            List of BusinessInfo objects where BusinessInfo is a class
	 *            containing id and rating.
	 *
	 * @return List of BusinessInfo sorted by rating in decreasing order
	 *
	 *         Example input: [ {'id': 101, rating: 5}, {'id': 102, rating: 2},
	 *         {'id': 103, rating: 3}, {'id': 104, rating: 5}, {'id': 105, rating:
	 *         5}, ] Expected output: [ {'id': 101, rating: 5}, {'id': 104, rating:
	 *         5}, {'id': 105, rating: 5}, {'id': 103, rating: 3}, {'id': 102,
	 *         rating: 2}, ]
	 */
	public static List<BusinessInfo> sortBusinessesByRating(final List<BusinessInfo> businesses) {
		ArrayList<BusinessInfo> list = new ArrayList<BusinessInfo>(businesses);
		Collections.sort(list, new Comparator<BusinessInfo>() {
			public int compare(BusinessInfo one, BusinessInfo two) {
				Integer first = new Integer(one.rating);
				Integer second = new Integer(two.rating);
				return second.compareTo(first);
			}
		});
		return list;
	}

}