package CtCI_Recursion_and_Dynamic_Programming;

public class paintFill_08_10 {

	enum Color {Black, White, Orange, Yellow, Green, Red}

	public static boolean paintFill(Color[][]screen, int r, int c, Color ncolor) {
		if (screen[r][c] == ncolor)
			return false;
		return fillInThePaint(screen, r, c, screen[r][c], ncolor);
	}

	private static boolean fillInThePaint(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
		if (r < 0 || r >= screen.length ||
				c < 0 || c >= screen[0].length)
			return false;

		if (screen[r][c] == ocolor){
			screen[r][c] = ncolor;
			fillInThePaint(screen, r + 1, c, ocolor, ncolor);
			fillInThePaint(screen, r, c + 1, ocolor, ncolor);
			fillInThePaint(screen, r - 1, c, ocolor, ncolor);
			fillInThePaint(screen, r, c - 1, ocolor, ncolor);
		}

		return true;
	}


	public static void main(String[] args) {

	}
}
