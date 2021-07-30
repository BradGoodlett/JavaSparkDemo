package Spark;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.hadoop.fs.FileSystem;

public class SparkFileScanner {

	public static long keywordExists(JavaSparkContext sc, String keyword, String file) {
		long res = 0;
		try {
			JavaRDD<String> lines = sc.textFile(file);
			res = lines.filter(s -> s.contains(keyword)).count();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
