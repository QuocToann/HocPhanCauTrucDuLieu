package Baitap01;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

//encryptChar 
	public char encryptChar(char c) {
		int x = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == Character.toUpperCase(c)) {
				x = i;
				break;
			}
		}
		if (x == -1) {
			return c;
		} else {
			return ALPHABET[(x + n) % 26];
		}
	}

	// String encrypt
	public String encrypt(String input) {
		StringBuilder encryptedText = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isLetter(c)) {
				encryptedText.append(encryptChar(c));
			} else {
				encryptedText.append(c);
			}
		}
		return encryptedText.toString();
	}

	// decryptChar
	public char decryptChar(char c) {
		int x = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == Character.toUpperCase(c)) {
				x = i;
				break;
			}
		}
		if (x == -1) {
			return c;
		} else {
			return ALPHABET[(x - n + 26) % 26];
		}
	}

	public static void main(String[] args) {
		// encryptChar
		MyCaesar myCaesar = new MyCaesar(3);
		char encryptedChar = myCaesar.encryptChar('A');
		System.out.println("Ký tự được mã hóa: " + encryptedChar);
		// String encrypt
		MyCaesar myCaesar1 = new MyCaesar(3);
		String encryptedText = myCaesar1.encrypt("HELLO WORLD");
		System.out.println("Văn bản được mã hóa: " + encryptedText);
		// decryptChar
		MyCaesar myCaesar2 = new MyCaesar(3);
		char decryptedChar = myCaesar.decryptChar('D');
		System.out.println("Ký tự được giải mã: " + decryptedChar);
		//

	}

}
