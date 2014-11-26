package sort;

import java.util.List;

public class ListUtil {
	public static <T> void swap(List<T> arrayList, int i, int j) {
		T temp = arrayList.get(i);
		arrayList.set(i, arrayList.get(j));
		arrayList.set(j, temp);
	}
}
