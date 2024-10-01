package az.developia.exam20240925;

public class NicknameException extends RuntimeException {

	/**
	 * Unique serial number.
	 */
	private static final long serialVersionUID = -6382278656697213754L;

	public NicknameException() {
		super("Animal nickname has invalid characters. ");
	}

	public NicknameException(String message) {
		super("Animal nickname has invalid characters. \n\t" + message);
	}

	public NicknameException(String[] invalidCharacters) {
		super("Animal nickname has invalid characters. \n\t" 
				+ "Invalid characters are [comma separated]: " + String.join(", ", invalidCharacters));
	}

}
