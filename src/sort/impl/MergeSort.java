package sort.impl;

import java.util.ArrayList;
import java.util.List;

import sort.Sorter;

public class MergeSort implements Sorter {

	@Override
	public void sort(List<Integer> arrayList) {
		List<Integer> sort = sort(arrayList, 0, arrayList.size()-1);
		arrayList.clear();
		arrayList.addAll(sort);
	}
	
	List<Integer> sort(List<Integer> arrayList, int start, int end) {
		List<Integer> result = new ArrayList<Integer>();
		if(end == start) {
			result.add(arrayList.get(start));
		} else if(end - start == 1) {
			if(arrayList.get(start) < arrayList.get(end)) {
				result.add(arrayList.get(start));
				result.add(arrayList.get(end));
			} else {
				result.add(arrayList.get(end));
				result.add(arrayList.get(start));
			}
		} else {
			int middle = (end + start) / 2;
			List<Integer> left = sort(arrayList, start,  middle);
			List<Integer> right = sort(arrayList, middle+1, end);
			int li = 0, ri = 0; 
			while(li < left.size() || ri < right.size()) {
				Integer leftHead = null;
				Integer rightHead = null;
				if(li < left.size()) {
					leftHead = left.get(li);
				}
				if(ri < right.size()) {
					rightHead = right.get(ri);
				}
				
				if(leftHead == null) {
					result.add(rightHead);
					ri++;
				} else if (rightHead == null) {
					result.add(leftHead);
					li++;
				} else {
					if(leftHead < rightHead) {
						result.add(leftHead);
						li++;
					} else {
						result.add(rightHead);
						ri++;
					}
				}
			}
		}
		return result;
	}

}
