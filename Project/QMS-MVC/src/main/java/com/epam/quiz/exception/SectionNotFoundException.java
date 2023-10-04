package com.epam.quiz.exception;

public class SectionNotFoundException  extends RuntimeException{
	public SectionNotFoundException()
	{
		super("Section not found!");
	}
	
	public SectionNotFoundException(String str)
	{
		super(str);
	}

}
