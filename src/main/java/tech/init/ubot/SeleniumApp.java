package tech.init.ubot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumApp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:8080/jatv");

		browser.findElement(By.id("title")).sendKeys("Mission: Impossible");
		browser.findElement(By.id("tagline")).sendKeys("Fallout");
		browser.findElement(By.id("overview")).sendKeys("Ethan Hunt chooses to save his team over completing a mission, allowing stolen plutonium to fall into the wrong hands.");

		browser.findElement(By.id("movie-form")).submit();

		browser.quit();
	}

}
