package foo.bar.util;

public class Range {
	private long from;
	private long to;
	private String fromIp;
	private String toIp;
	
	
	public Range(long from, long to, String fromIp, String toIp) {
		this.from = from;
		this.to = to;
		this.fromIp = fromIp;
		this.toIp = toIp;
	}
	
	public Range(long from, long to) {
		this.from = from;
		this.to = to;
	}
	
	public long getFrom() {
		return from;
	}
	
	public void setFrom(long from) {
		this.from = from;
	}
	
	public long getTo() {
		return to;
	}
	
	public void setTo(long to) {
		this.to = to;
	}
	
	public String getFromIp() {
		return fromIp;
	}

	public void setFromIp(String fromIp) {
		this.fromIp = fromIp;
	}

	public String getToIp() {
		return toIp;
	}

	public void setToIp(String toIp) {
		this.toIp = toIp;
	}
	
	
}
