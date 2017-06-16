package foo.bar.client;

import foo.bar.util.IPChecker;

public class Main {
	public static void main(String[] args) {
		String ipAddress = "210.21.12.20"; // China
		//String ipAddress = "45.59.171.171"; // China
		//String ipAddress = "202.64.103.86"; // HK
		//String ipAddress = "116.48.214.26"; // HK
		//String ipAddress = "54.173.180.49"; // US
		
		IPChecker checker = new IPChecker();
		System.out.println(checker.isChina(ipAddress));
	}
}
