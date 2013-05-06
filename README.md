# SRT (SubRip Titles) Java Library

Full implementation of the SRT format, including multi-line subtitles.
Please see the license for legal information and appropriate usage.
Targeted at Java 1.7+

## Example Use

### Creating a new SubtitleFile
	SubtitleFile exampleSubtitleFile = new SubtitleFile();
	
	Subtitle exampleSubtitle = new Subtitle(new Timestamp(0, 0, 2, 832), new Timestamp("00:00:09,127"));
	exampleSubtitle.addLine("Line 1");
	exampleSubtitle.addLine("Line 2");
	exampleSubtitle.addLine("Line 3");
	
	exampleSubtitleFile.addSubtitle(exampleSubtitle);
	
	Subtitle exampleSubtitle2 = new Subtitle(new Timestamp("00:00:12,000"), new Timestamp(0, 0, 17, 000));
	exampleSubtitle2.addLine("Line 1");
	exampleSubtitle2.addLine("Line 2");
	exampleSubtitle2.addLine("Line 3");
	
	exampleSubtitleFile.addSubtitle(exampleSubtitle2);
	
	exampleSubtitleFile.save(new File("example.srt"));

### Opening an existing SubtitleFile
	SubtitleFile exampleFile = new SubtitleFile(new File("test.srt"));