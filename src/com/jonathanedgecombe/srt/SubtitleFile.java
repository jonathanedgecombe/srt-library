package com.jonathanedgecombe.srt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class SubtitleFile {
	private final List<Subtitle> subtitles;
	
	/* Create a new SubtitleFile. */
	public SubtitleFile() {
		subtitles = new ArrayList<>();
	}
	
	public void addSubtitle(Subtitle subtitle) {
		subtitles.add(subtitle);
	}
	
	public void clearSubtitles() {
		subtitles.clear();
	}
	
	public void removeSubtitle(Subtitle subtitle) {
		subtitles.remove(subtitle);
	}
	
	public void removeSubtitle(int index) {
		subtitles.remove(index);
	}
	
	public String compile() {
		String string = "";
		
		/* Subtitle indexes start at 1 */
		int index = 1;
		
		for (Subtitle subtitle : subtitles) {
			string += subtitle.compile(index);
			index++;
		}
		
		return string;
	}
	
	public void save(File file) throws IOException {
		FileOutputStream out = new FileOutputStream(file);
		out.write(compile().getBytes(Charset.forName("UTF-8")));
		out.close();
	}
}
