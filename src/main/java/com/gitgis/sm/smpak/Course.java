package com.gitgis.sm.smpak;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.gitgis.sm.smdb.Item;


public class Course {

	private Map<Integer, Item> exercises = new LinkedHashMap<Integer, Item>();
	public String description;
	public String title;
	public String guid;
	
	public Course(Parser smPakParser, InputStream inputStream) throws IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler dh = new CourseHandler(this);
			saxParser.parse(inputStream, dh);
		} catch (ParserConfigurationException e) {
			Logger.getLogger(Course.class.getName()).severe(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			Logger.getLogger(Course.class.getName()).severe(e.getMessage());
			e.printStackTrace();
		}
	}

	public void addExercise(Item exercise) {
		exercises.put(exercise.id, exercise);
		
	}

	public Map<Integer, Item> getExercises() {
		return exercises;
	}

	public String toString() {
		return title+"["+exercises.size()+"]";
	}

	/**
	 * 
	 */
	public void printDetailed() {
		for (Entry<Integer, Item> entry: exercises.entrySet()) {
			Item exercise = entry.getValue();
			String lineStr = exercise.id+"\t"+exercise.name+"\t"+exercise.lastRepetition;
			lineStr+="";
			System.out.println(lineStr);
		}
	}


}
