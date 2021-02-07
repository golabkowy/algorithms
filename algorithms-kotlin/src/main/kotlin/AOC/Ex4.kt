package AOC

import AOC.utils.AOCKotlinFileOperator
import java.util.stream.Collectors

fun checkPassportValidity(passportData: String, pattern: List<String>): Boolean {
    return passportData.dropLast(2).split(" ").stream()
            .map { kv -> kv.split(":")[0] }
            .filter { k -> k != "cid" }
            .collect(Collectors.toList())
            .sorted() == pattern.sorted()
}

fun checkAllPassportsValidity(passports: List<String>, pattern: List<String>): Int {
    return passports.stream()
            .filter { checkPassportValidity(it, pattern) }
            .count()
            .toInt()
}

fun main() {
    val akfo = AOCKotlinFileOperator();
    val data: List<String> = akfo.readLines("C:\\Projects\\algorithms\\algorithms-kotlin\\src\\main\\kotlin\\AOC\\adv.txt")
    val result: Int = checkAllPassportsValidity(data, listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))
    print(result)
}
