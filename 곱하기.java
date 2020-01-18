import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class °öÇÏ±â {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int ans = a*b;
		
		System.out.println(ans);
		
	}
}
