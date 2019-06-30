package jp.kyuuki.kanjichanger.models

import jp.kyuuki.kanjichanger.components.numberToKanji

/**
 * 漢字変換可能数値.
 */
class KanjiChangeableNumber(val value: Long) {
    fun getKanji() : String {
        return numberToKanji(value)
    }
}