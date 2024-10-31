import java.io.File

data class Word(
    val original: String,
    val translate: String,
    var correctAnswersCount: Int?,
)

fun main() {
    val wordsFile: File = File("words.txt")
    val dictionary: MutableList<Word> = mutableListOf()

    val lines: List<String> = wordsFile.readLines()
    for (line in lines) {
        val wordsLine = line.split("|")
        val newWord = Word(
            original = wordsLine[0],
            translate = wordsLine[1],
            correctAnswersCount = wordsLine[2].toIntOrNull() ?: 0
        )
        dictionary.add(newWord)
    }
    println(dictionary)
}