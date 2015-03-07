public class CoinToss {
	public static void main(String[] args) {
		// int heightOfTree = heightOfTree("12**34***");
		int heightOfTree = heightOfTree("a * b * c * * *");
		System.out.println(heightOfTree);
	}

	public static int getValue(int betAmount, String coinTossResults) {
		final int base = 1;
		int cur = base;
		for (int i = 0; i < coinTossResults.length() && betAmount > 0; i++) {
			if (coinTossResults.charAt(i) == 'T') {
				betAmount -= cur;
				cur = base;
			} else {
				betAmount += cur;
				cur *= 2;
			}
		}
		return betAmount;
	}

	static int heightOfTree(String enc) {
		int[] sinfo = null;
		String[] split = enc.split(" ");
		try {
			sinfo = heightOfTree(enc.split(" "), 0);
		} catch (NullPointerException e) {
			return -1;
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
//		System.out.println(sinfo[1] + "\t" + split.length);
		if(sinfo[1] != split.length)
			return -1;
		return sinfo == null ? -1 : sinfo[0];
	}

	// height width
	static int[] heightOfTree(String[] enc, int index) {
		if (enc[index].equals("*")) {
			return new int[] { 0, 1 };
		}

		int offset = 1;
		int width = 0;
		int[] pleft = heightOfTree(enc, width + index + offset);
		width += pleft[1];
		int[] pright = heightOfTree(enc, width + index + offset);
		width += pright[1];
		return new int[] { Math.max(pleft[0], pright[0]) + 1, width + 1 };
	}
}
