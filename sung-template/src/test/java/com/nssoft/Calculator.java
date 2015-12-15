package com.nssoft;

public class Calculator {

	public static void main(String[] args) {
		String numString = "4+2*2-2+3";
		char numchar[] = numString.toCharArray();
		ArrayStack stringStack = new ArrayStack();
		ArrayStack operator = new ArrayStack();
		for(int i = 0;i < numchar.length;i++) {
			char temp = numchar[i];
			if ('0' <= temp && temp <= '9') {
				stringStack.push(temp - 48);
			} else {
				switch (temp) {
				case '*':
					stringStack.push((int) stringStack.pop() * (numchar[++i] - 48));
					break;
				case '/':
					stringStack.push((int) stringStack.pop() / (numchar[++i] - 48));
					break;
				case '+':
					operator.push(temp);
					break;
				case '-':
					operator.push(temp);
					break;
				}
			}
		}
		stringStack.reverse();
		operator.reverse();
		
		while(!operator.isEmpty()){
			switch ((char) operator.pop()) {
			case '+':
				stringStack.push((int) stringStack.pop() + (int) stringStack.pop());
				break;
			case '-':
				stringStack.push((int) stringStack.pop() - (int) stringStack.pop());
				break;
			}
		} 
		System.out.println(stringStack.pop());
	}

}
