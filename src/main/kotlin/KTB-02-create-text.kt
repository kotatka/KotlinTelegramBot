import java.io.File

fun main() {
    val wordsFile: File = File("words.txt")
    wordsFile.forEachLine { line -> println(line) }
}