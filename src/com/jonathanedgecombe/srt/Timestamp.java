package com.jonathanedgecombe.srt;

public class Timestamp {
	private int hours, minutes, seconds, milliseconds;
	
	/* Create a new timestamp at the given time. */
	public Timestamp(int hours, int minutes, int seconds, int milliseconds) {
		this.setHours(hours);
		this.setMinutes(minutes);
		this.setSeconds(seconds);
		this.setMilliseconds(milliseconds);
	}
	
	/* Create a new timestamp from the given string.
	 * Uses the SRT timestamp format:
	 * hours:minutes:seconds,milliseconds
	 * eg. 00:00:28,400 */
	public Timestamp(String time) throws InvalidTimestampFormatException {
		String[] topParts = time.split(",");
		if (topParts.length != 2) throw new InvalidTimestampFormatException();
		String[] parts = topParts[0].split(":");
		if (parts.length != 3) throw new InvalidTimestampFormatException();
		
		this.setHours(Integer.parseInt(parts[0]));
		this.setMinutes(Integer.parseInt(parts[1]));
		this.setSeconds(Integer.parseInt(parts[2]));
		this.setMilliseconds(Integer.parseInt(topParts[1]));
	}
	
	/* Compiles the timestamp to an SRT timestamp. */
	public String compile() {
		return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds) + "," + String.format("%03d", milliseconds);
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}
}
