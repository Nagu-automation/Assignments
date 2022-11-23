package week3.day1.assign5;

public class Automation extends MultipleLangauge implements Language, TestTool {

	public static void main(String[] args) {

		Automation auto = new Automation();
		auto.Java();
		auto.python();
		auto.ruby();
		auto.Selenium();

	}

	public void Selenium() {
		System.out.println("Selenium from test tool class");

	}

	public void Java() {
		System.out.println("Java from language class");
	}

	@Override
	public void ruby() {
		System.out.println("Ruby from multiple language class");
	}

}
