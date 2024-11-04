import java.io.File

const val LEARNED_COUNT = 3

data class Word(
    val original: String,
    val translate: String,
    var correctAnswersCount: Int,
)

fun loadDictionary(file: File): MutableList<Word> {
    val dictionary: MutableList<Word> = mutableListOf()
    val lines: List<String> = file.readLines()
    for (line in lines) {
        val wordsLine = line.split("|")
        val newWord = Word(
            original = wordsLine[0],
            translate = wordsLine[1],
            correctAnswersCount = wordsLine[2]?.toIntOrNull() ?: 0
        )
        dictionary.add(newWord)
    }
    return dictionary
}

fun main() {
    val wordsFile: File = File("words.txt")
    val dictionary: MutableList<Word> = loadDictionary(wordsFile)

    while (true) {
        println(
            """Меню:
            |1 - Учить слова
            |2 - Статистика
            |0 - выход
        """.trimMargin()
        )

        val userChoice = readln().toInt()
        when (userChoice) {
            1 -> println("Вы выбрали пункт - Учить слова")
            2 -> {
                val totalCount = dictionary.size
                val learnedCount = dictionary.filter { it.correctAnswersCount >= LEARNED_COUNT }
                val totalLearnedCount = learnedCount.size
                val percent = (totalLearnedCount.toDouble() / totalCount) * 100
                println("Выучено $totalLearnedCount из $totalCount | $percent%")
                println()
            }

            0 -> return
            else -> println("Вы выбрали некорректное число. Введите число 1, 2 или 0")
        }
    }
}