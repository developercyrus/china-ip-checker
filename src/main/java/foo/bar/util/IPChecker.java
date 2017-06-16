package foo.bar.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IPChecker {
	private List<Range> list = new ArrayList<Range>();
	
	public IPChecker() {
		try {
			String path = this.getClass().getResource("chinaip.txt").getFile();
	        BufferedReader br = new BufferedReader(new FileReader(path));
			String line, from, to = new String();
	        while ((line = br.readLine()) != null) {
	        	StringTokenizer tokens = new StringTokenizer(line);
	            from = tokens.nextToken();
	            to = tokens.nextToken();   
	            list.add(new Range(Long.parseLong(from), Long.parseLong(to)));
	        }
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}       
	}
	
	public long ip2Long(String ipAddress) {		
		try {
			InetAddress ip = InetAddress.getByName(ipAddress);
			byte[] octets = ip.getAddress();
	        long result = 0;
	        for (byte octet : octets) {
	            result <<= 8;
	            result |= octet & 0xff;
	        }	        
	        return result;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
        return -1;
    }
	
	public String long2Ip(long ip) {
		return ((ip >> 24) & 0xFF) + "."
				+ ((ip >> 16) & 0xFF) + "."
				+ ((ip >> 8) & 0xFF) + "."
				+ (ip & 0xFF);

	}
	
	public boolean isChina(String ipAddress) {				
		long ip = this.ip2Long(ipAddress);
		System.out.println("[" + ipAddress + "]-[" + ip + "]" );
		for (Range range : list) {
			if (range.getFrom() <= ip && ip <= range.getTo()) {					
				System.out.println("[" + this.long2Ip(range.getFrom()) + "][" + this.long2Ip(range.getTo()) + "]-[" + range.getFrom() + "][" + range.getTo() + "]");
				return true;
			}
		}
		
		return false;		
	}
	
	
}
