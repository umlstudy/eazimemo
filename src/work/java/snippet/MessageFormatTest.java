package snippet;

import java.text.MessageFormat;

public class MessageFormatTest {

	public static void main(String...args) {
		System.out.println(MessageFormat.format("'{' {0} '}'", "TEST"));
	}
}
