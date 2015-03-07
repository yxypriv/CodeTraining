package sort;

import java.util.List;

public class ListUtil {
	public static <T> void swap(List<T> arrayList, int i, int j) {
		T temp = arrayList.get(i);
		arrayList.set(i, arrayList.get(j));
		arrayList.set(j, temp);
	}

	public static <T> void display(List<T> arrayList) {
		for (int i = 0; i < arrayList.size(); i++)
			System.out.print(arrayList.get(i));
		System.out.println();
	}
}
