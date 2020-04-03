package UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestUtils{
  
  public static String httpRequest(final URL url) {
		String result = "";
		try {
			final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result = String.valueOf(result) + line;
			}
			rd.close();
		}
		catch (Exception ex) {}
		return result;
	}
}
