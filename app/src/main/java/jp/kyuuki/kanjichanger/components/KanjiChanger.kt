package jp.kyuuki.kanjichanger.components

/**
 * 数字を漢字に変換
 *
 * - 1234 → 千弐百参拾四
 */
fun numberToKanji(number: Int): String {
    if (number >= 100) return "3 桁以上の数字にはまだ未対応です。"

    val x = number / 10  // 10 の位
    val y = number % 10  // 1 の位

    var str = ""   // 変換結果を入れる変数

    // 10 の位も 1 の位も 0 の時は無条件で "零" に
    if (x == 0 && y == 0) return "零"

    // 10 の位を漢字に
    if (x == 0) {
        // 10 の位が 0 のときは何もつけない
    } else if (x == 1) {
        // 10 の位が 1 のときは "壱拾" のように "壱" はつけない
        str += "拾"
    } else {
        str += number1DigitToKanji(x) + "拾"
    }

    // 1 の位を漢字に
    if (y == 0) {
        // 1 の位が 0 のときは何もつけない
    } else {
        str += number1DigitToKanji(y)
    }

    return str
}

/**
 * 1 桁の数字を漢字に変換
 *
 * - 0 → 零, 1 → 壱, ... 9 → 九
 */
fun number1DigitToKanji(number: Int): String {
    val kanjis = arrayListOf("零", "壱", "弐", "参", "四", "五", "六", "七", "八", "九")
    return kanjis[number]
}
