package org.main.cucumber;

//import runner.RunTest;

public class MainRunner {

	public static void main(String[] args) {
		
		String[] argv= {"-g", "steps", "-t", "@tamilnadu", System.getProperty("user.dir")+"/gherkin_new.feature"};
		ClassLoader c= Thread.currentThread().getContextClassLoader();
		cucumber.api.cli.Main.run(argv, c);
	}

}
