package com.srikanth.fullstackjava;

public class Test {

	private String testId;
	private String testTitle;
	private int testMarks;

	public Test() {
		super();
	}

	public Test(String testId, String testTitle, int testMarks) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testMarks = testMarks;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public int getTestMarks() {
		return testMarks;
	}

	public void setTestMarks(int testMarks) {
		this.testMarks = testMarks;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testMarks=" + testMarks + "]";
	}

}
