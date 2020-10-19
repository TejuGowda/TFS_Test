import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.annotation.Keyword

public class UtilHelper {
	public String generateUniqueString(String prefix){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		return prefix + dtf.format(now).toString();
	}
}
