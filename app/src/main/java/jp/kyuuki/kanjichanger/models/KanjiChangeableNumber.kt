package jp.kyuuki.kanjichanger.models

import jp.kyuuki.kanjichanger.components.numberToKanji
import java.math.BigInteger

/**
 * 漢字変換可能数値.
 */
class KanjiChangeableNumber(val value: BigInteger) {
    fun getKanji() : String {
        return numberToKanji(value)
    }
}