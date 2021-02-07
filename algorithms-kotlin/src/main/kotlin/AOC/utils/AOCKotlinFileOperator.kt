package AOC.utils

import java.io.File

class AOCKotlinFileOperator {
    // EX4 - specific
    // read to Array of strings, strings separated by empty line in adv.txt file
    //UBER important! With this solution, last line in .txt file has to be empty!
    fun readLines(path: String): List<String> {
        var list = mutableListOf<String>()
        var i = 0
        var str = ""
        File(path).forEachLine {
            str += "$it "
            if (it.isEmpty()) {
                list.add(i, str)
                i++
                str = ""
            }
        }
        return list;
    }
}