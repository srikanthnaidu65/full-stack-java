package com.srikanth.fullstackjava;

import org.apache.commons.lang3.StringUtils;

public class App 
{
	public static void main( String[] args ) {
		deleteWhitespace("Hai Srikanth welcome to maven assignments");
	}

	public static void deleteWhitespace(String s) {
		if (StringUtils.isNotEmpty(s)) {
			System.out.println(StringUtils.deleteWhitespace(s));
		}
	}
}
