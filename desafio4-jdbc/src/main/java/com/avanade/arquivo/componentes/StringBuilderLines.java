package com.avanade.arquivo.componentes;

public class StringBuilderLines {
	
	private StringBuilder content;
	
	public void appendLine(int i) {
		appendLine(String.valueOf(i));
	}
	
	public void appendLine(String str) {
		if (str == null) {
			return;
		}
		
		getContent().append(str);
		getContent().append("\n");
	}
	
	public StringBuilder getContent() {
		if (content == null) {
			content = new StringBuilder();
		}
		return content;
	}
}
