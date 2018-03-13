import java.io.IOException;
import java.io.InputStream;

public class Echo2Exam {

	public static void main(String[] args) {
		InputStream is = System.in;
		while(true) {
			int i = 0;
			try {
				i = is.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == -1) break;
			System.out.println((char)i);
		}
	}
}
