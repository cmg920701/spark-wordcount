import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object SparkWordCount {

  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf()
      .setAppName("Spark Word Count")
      .setMaster("local[*]"))

    val lines = sc.textFile(path="../shakespeare.txt") /** Please define your path **/

    val words = lines.flatMap(_.split("\\s+"))

    val wordCounts = words.map((_,1)).reduceByKey(_+_)

    wordCounts.saveAsTextFile("../WordCountOutput") /** Please define your path **/

  }

}
