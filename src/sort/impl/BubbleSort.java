package sort.impl;

import java.util.List;

import sort.ListUtil;
import sort.Sorter;

public class BubbleSort implements Sorter {

	@Override
	public void sort(List<Integer> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			for (int j = 0; j < arrayList.size() - i - 1; j++) {
				if (arrayList.get(j) > arrayList.get(j + 1)) {
					ListUtil.swap(arrayList, j, j + 1);
				}
			}
		}
	}

}
