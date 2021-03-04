package com.agorasystems.ubot;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Robot {

	private static final String FILENAME = "files/movies.csv";

	private static final String URL = "http://localhost:8080/jatv";

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver browser = new ChromeDriver();

		try (Reader reader = new FileReader(FILENAME)) {
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').parse(reader);

			for (CSVRecord record : records) {
				browser.navigate().to(URL);

				browser.findElement(By.id("title")).sendKeys(record.get(0));
				browser.findElement(By.id("tagline")).sendKeys(record.get(1));
				browser.findElement(By.id("overview")).sendKeys(record.get(2));

				browser.findElement(By.id("movie-form")).submit();
			}
		}

		browser.quit();
	}

}
