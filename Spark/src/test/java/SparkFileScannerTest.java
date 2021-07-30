import static org.junit.jupiter.api.Assertions.*;

import org.apache.hadoop.fs.Path;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Spark.SparkFileScanner;

class SparkFileScannerTest {
	private static SparkConf conf;
	private static JavaSparkContext sc;
	private static String file = "data.txt";
	private static JavaRDD<String> lines;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		SparkFileScannerTest.conf = new SparkConf().setAppName("Spark File Scanner App").setMaster("local");
		SparkFileScannerTest.sc = new JavaSparkContext(conf);
		
		SparkFileScannerTest.lines = SparkFileScannerTest.sc.textFile(SparkFileScannerTest.file);
	}

	@Test
	void keywordExists() {
		String keyword = "christmas";
		assertEquals(5, SparkFileScanner.keywordExists(SparkFileScannerTest.sc, keyword, SparkFileScannerTest.file));
	}
	
	@Test
	void keywordNotExists() {
		String keyword = "not_here";
		assertEquals(SparkFileScanner.keywordExists(SparkFileScannerTest.sc, keyword, SparkFileScannerTest.file), 0);
	}

	@Test
	void fileNotExists() {
		String keyword = "christmas";
		assertEquals(0, SparkFileScanner.keywordExists(SparkFileScannerTest.sc, keyword, "not_found.txt"));
	}
}
