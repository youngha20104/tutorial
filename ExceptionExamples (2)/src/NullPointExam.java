
public class NullPointExam {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String str = null;
		try {
		System.out.println("글자수: " + str.length());
		}catch(Exception e) {
		e.getMessage();
		}
	}

}
