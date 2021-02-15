package tech.init.ubot;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CommonsCSVApp {

	public static void main(String[] args) throws IOException {
		Reader in = new FileReader("files/movies.csv");

		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').withTrim().parse(in);

		int i = 0;

		for (CSVRecord record : records) {
			System.out.println("Title: " + record.get(0));
			System.out.println("Tagline: " + record.get(1));
			System.out.println("Overview: " + record.get(2));
			System.out.println();

			i++;
		}

		System.out.println("Total: " + i);
	}

}
