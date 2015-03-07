
public class Q5 {
	public static void main(String[] args) {
		System.out.println(DateOfWeekday(11111, -14));
		
	}

	static int DateOfWeekday(int date, int weekday) {
		int curWeekday = date % 7;
		boolean forward = true;
		if(weekday < 0) {
			forward = false;
			weekday = - weekday;
		}
		if (weekday == 0) {
			return date;
		} else {
			int week = (weekday - 1) / 7;
			weekday %= 7;
			
			if(curWeekday == 0)
				curWeekday = 7;
			if(weekday == 0)
				weekday = 7;
			
			if(forward) {
				if(weekday > curWeekday) {
					date += weekday - curWeekday;
				} else {
					date += weekday + 7 - curWeekday;
				}
				date += 7 * week;
			} else {
				if(weekday < curWeekday) {
					date += weekday - curWeekday;
				} else {
					date += weekday - curWeekday - 7;
				}
				date -= 7 * week;
			}
		}
		return date;
	}
}
