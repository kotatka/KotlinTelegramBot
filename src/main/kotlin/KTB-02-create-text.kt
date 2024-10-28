import java.io.File

fun main() {
    val wordsFile: File = File("words.txt")
    wordsFile.createNewFile()
    val wordsStrings = wordsFile.readLines()
    for (i in 0..wordsStrings.size - 1) {
        println(wordsStrings[i])
    }
}