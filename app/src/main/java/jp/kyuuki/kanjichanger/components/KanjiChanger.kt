package jp.kyuuki.kanjichanger.components

/**
 * 数字を漢字に変換.
 *
 * - 56781234 → 五千六百七十八万千弐百参拾四
 * TODO: 垓以上に対応したい
 */
fun numberToKanji(number: Long): String {
    // 0 の時だけ特別
    if (number == 0L) {
        return number1DigitToKanji(0)
    }

    // 桁の低い方から高い方へ
    // https://ja.wikipedia.org/wiki/%E5%91%BD%E6%95%B0%E6%B3%95#%E5%A4%A7%E6%95%B0
    // TODO: 定数がよさげ
    val tanis = arrayListOf("", "万", "億", "兆", "京",
        "垓", "\uD855\uDF71"/* 𥝱 */, "穣", "溝", "澗", "正", "載", "極", "恒河沙", "阿僧祇", "那由他", "不可思議", "無量大数")

    var str = ""    // 変換結果を入れる変数
    var x : Int     // 小さな位から四文字ずつ数字を取り出して入れる (1234567890 → 7890)
    var y = number  // 取り出した残り (1234567890 → 123456)

    tanis.forEach {
        if (y == 0L) {
            // https://improve-future.com/kotlin-why-while-break-or-continue-cant-be-used-in-foreacn-repeat-which-can-be-used-in-while-and-for.html
            return@forEach
        }

        x = (y % 10000).toInt()
        y = y / 10000

        if (x != 0) {
            val kanji = number4DigitToKanji(x)
            str = "$kanji$it$str"
        }
    }

    return str
}

/**
 * 4 桁の数字を漢字に変換
 *
 * - 1234 → 千弐百参拾四
 * - 0 → 零
 */
fun number4DigitToKanji(number: Int): String {
    // 0 の時だけ特別
    if (number == 0) {
        return number1DigitToKanji(0)
    }

    var str = ""    // 変換結果を入れる変数
    var x : Int     // 大きな位から一文字ずつ数字を取り出して入れる
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
