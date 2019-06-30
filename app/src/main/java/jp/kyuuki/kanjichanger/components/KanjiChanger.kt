package jp.kyuuki.kanjichanger.components

/**
 * 数字を漢字に変換.
 *
 * - 56781234 → 五千六百七十八万千弐百参拾四
 */
fun numberToKanji(number: Int): String {
    if (number >= 10000) return "5 桁以上の数字にはまだ未対応です。"

    return number4DigitToKanji(number)
}

/**
 * 4 桁の数字を漢字に変換
 *
 * - 1234 → 千弐百参拾四
 */
fun number4DigitToKanji(number: Int): String {
    // 0 の時だけ特別
    if (number == 0) {
        return number1DigitToKanji(0)
    }

    var str = ""   // 変換結果を入れる変数
    var x : Int  // 大きな位から一文字ずつ数字を取り出して入れる
    var y = number  // 取り出した残り

    // 千の位
    x = y / 1000  // 千の位
    y = y % 1000  // 残り

    if (x != 0) {
        str += number1DigitToKanji(x) + "千"
    }

    // 百の位
    x = y / 100  // 百の位
    y = y % 100  // 残り

    if (x != 0) {
        str += number1DigitToKanji(x) + "百"
    }

    // 十の位
    x = y / 10  // 十の位
    y = y % 10  // 残り (一の位)

    if (x != 0) {
        if (x == 1) {
            // 十の位が 1 のときは "壱拾" のように "壱" はつけない
            str += "拾"
        } else {
            str += number1DigitToKanji(x) + "拾"
        }
    }

    // 一の位
    if (y != 0) {
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
    // TODO: 0 ～ 9 以外が入力されたとき
    // TODO: 定数がよさげ
    val kanjis = arrayListOf("零", "壱", "弐", "参", "四", "五", "六", "七", "八", "九")
    return kanjis[number]
}
