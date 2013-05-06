package com.jonathanedgecombe.srt;

import java.util.ArrayList;
import java.util.List;

public class Subtitle {
	private Timestamp startTime, endTime;
	private final List<String> lines;
	
	/* Create a new Subtitle with the given start and end times. */
	public Subtitle(Timestamp startTime, Timestamp endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		lines = new ArrayList<>();
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	public void clearLines() {
		lines.clear();
	}
	
	public void addLine(String line) {
		lines.add(line);
	}
	
	public void removeLine(String line) {
		lines.remove(line);
	}
	
	public void removeLine(int index) {
		lines.remove(index);
	}
	
	public String getLine(int index) {
		return lines.get(index);
	}

	public List<String> getLines() {
		return lines;
	}
	
	/* Compiles subtitle into a string with the given subtitle index. */
	public String compile(int index) {
		String subtitle = "";
		
		subtitle += Integer.toString(index) + "\n";
		subtitle += startTime.compile() + " --> " + endTime.compile() + "\n";
		
		for (String line : lines) {
			subtitle += line + "\n";
		}
		
		subtitle += "\n";
		return subtitle;
	}
	
	public static String formatLine(String line) {
		/* Replace CRLF with LF for neatness. */
		line = line.replace("\r\n", "\n");
		
		/* Empty line marks the end of a subtitle, replace it with a space.  */
		line = line.replace("\n\n", "\n \n");
		
		return line;
	}
}
