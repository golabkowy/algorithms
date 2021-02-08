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
            // EX4.2 hearth
            .filter { fieldsValidation(it) }
            .count()
            .toInt()
}

fun fieldsValidation(passportData: String): Boolean {
    var map = mutableMapOf<String, String>()

    passportData.dropLast(2).split(" ").forEach {
        val kv: List<String> = it.split(":")
        map[kv[0]] = kv[1]
    }

    val isByrValid: Boolean = map.get("byr")!!.length == 4 && map.get("byr")!!.toInt() in 1920..2002
    val isIyrVal: Boolean = map.get("iyr")!!.length == 4 && map.get("iyr")!!.toInt() in 2010..2020
    val isEyrVal: Boolean = map.get("eyr")!!.length == 4 && map.get("eyr")!!.toInt() in 2020..2030


    val hgtVal: String = map.get("hgt")!!
    val hgtUnit: String = hgtVal.takeLast(2)
    val isHgtUnitValid = (hgtUnit == "cm").or(hgtUnit == "in")
    var isHgtIndexValid = false

    if (hgtUnit == "cm") {
        isHgtIndexValid = hgtVal.removeSuffix("cm").toInt() in 150..193
    } else if (hgtUnit == "in") {
        isHgtIndexValid = hgtVal.removeSuffix("in").toInt() in 59..76
    }

    val isHgtVal: Boolean = isHgtUnitValid.and(isHgtIndexValid)


    val hclVal = map.get("hcl")
    val (digitsHcl, notDigitsHcl) = hclVal!!.partition { it.isDigit() }
    val allowedChars = charArrayOf('a', 'b', 'c', 'd', 'e', 'f')//dac te do lowercase w razie w
    val intArrDigits = digitsHcl.toCharArray().map { it.toString().toInt() }
    val isHclVal: Boolean = hclVal.get(0) == '#' && hclVal.length == 7 && intArrDigits.all { it in 0..9 } && notDigitsHcl.removePrefix("#").all { allowedChars.contains(it) }


    val eclOptions = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    val isEclVal: Boolean = eclOptions.contains(map.get("ecl"))


    val (digits, noDigits) = map.get("pid")!!.toCharArray().partition { it.isDigit() }
    val isPidVal: Boolean = map.get("pid")!!.length == 9 && noDigits.isEmpty()


    return isByrValid
            .and(isIyrVal)
            .and(isEyrVal)
            .and(isHgtVal)
            .and(isHclVal)
            .and(isEclVal)
            .and(isPidVal)
}

fun main() {
    val akfo = AOCKotlinFileOperator();
    val data: List<String> = akfo.readLines("C:\\Projects\\algorithms\\algorithms-kotlin\\src\\main\\kotlin\\AOC\\adv.txt")
    val result: Int = checkAllPassportsValidity(data, listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))
    print(result)
}

