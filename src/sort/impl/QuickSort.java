package sort.impl;

import java.util.List;

import sort.ListUtil;
import sort.Sorter;

public class QuickSort implements Sorter{

	@Override
	public void sort(List<Integer> arrayList) {
		sort(arrayList, 0, arrayList.size()-1);
	}
	
	private void sort(List<Integer> arrayList, int start, int end) {
		if(start >= end)
			return;
		int cleft = start, cright = end;
		boolean left = true;
		while(cleft < cright) {
			if(arrayList.get(cleft) > arrayList.get(cright)) {
				ListUtil.swap(arrayList, cleft, cright);
				left = !left;
			}
			if(left) 
				cright--;
			else
				cleft++;
		}
		int middle;
		if(left) 
			middle = cleft;
		else
			middle = cright;
		sort(arrayList, start, middle-1);
		sort(arrayList, middle+1, end);
	}
	
}
