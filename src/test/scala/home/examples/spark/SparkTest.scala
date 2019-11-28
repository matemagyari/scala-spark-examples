package home.examples.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.Seq

class SparkTest extends FlatSpec with Matchers {

  val conf: SparkConf = new SparkConf()
    .setAppName("Spark Count")
    .setMaster("local[2]")
    .set("spark.executor.memory", "1g")

  val sc = new SparkContext(conf)

  "World count" should "work" in {

    // read in text file and split each document into words
    val tokenized: RDD[String] = {
      val path = getClass.getResource("/input.txt").getFile
      sc.textFile(path).flatMap(_.split(" "))
    }

    // count the occurrence of each word
    val wordCounts: RDD[(String, Int)] = tokenized.map((_, 1)).reduceByKey(_ + _).sortBy(_._2)

    val result: Seq[(String, Int)] = wordCounts.collect().toList

    println("Result")
    result.foreach(println)
  }
}
