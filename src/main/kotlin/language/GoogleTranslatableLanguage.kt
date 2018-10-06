package language

import java.util.*

enum class GoogleTranslatableLanguage(val googleTranslatorLanguageId: String) : ITranslatableLanguage<GoogleTranslatableLanguage> {
    AUTO_DETECT(""),
    AFRIKAANS("af"),
    ALBANIAN("sq"),
    //AMHARIC("am"),
    ARABIC("ar"),
    ARMENIAN("hy"),
    AZERBAIJANI("az"),
    BASQUE("eu"),
    BELARUSIAN("be"),
    BENGALI("bn"),
    //BIHARI("bh"),
    BULGARIAN("bg"),
    BURMESE("my"),
    CATALAN("ca"),
    //CHEROKEE("chr"),
    CHINESE("zh"),
    CHINESE_SIMPLIFIED("zh-CN"),
    CHINESE_TRADITIONAL("zh-TW"),
    CROATIAN("hr"),
    CZECH("cs"),
    DANISH("da"),
    //DHIVEHI("dv"),
    DUTCH("nl"),
    ENGLISH("en"),
    ESPERANTO("eo"),
    ESTONIAN("et"),
    FILIPINO("tl"),
    FINNISH("fi"),
    FRENCH("fr"),
    GALICIAN("gl"),
    GEORGIAN("ka"),
    GERMAN("de"),
    GREEK("el"),
    //GUARANI("gn"),
    GUJARATI("gu"),
    HEBREW("iw"),
    HINDI("hi"),
    HUNGARIAN("hu"),
    ICELANDIC("is"),
    INDONESIAN("id"),
    //INUKTITUT("iu"),
    IRISH("ga"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KANNADA("kn"),
    KAZAKH("kk"),
    KHMER("km"),
    KOREAN("ko"),
    //KURDISH("ku"),
    //KYRGYZ("ky"),
    LAOTHIAN("lo"),
    LATVIAN("lv"),
    LITHUANIAN("lt"),
    MACEDONIAN("mk"),
    MALAY("ms"),
    MALAYALAM("ml"),
    MALTESE("mt"),
    MARATHI("mr"),
    MONGOLIAN("mn"),
    NEPALI("ne"),
    NORWEGIAN("no"),
    //ORIYA("or"),
    //PASHTO("ps"),
    PERSIAN("fa"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PUNJABI("pa"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    //SANSKRIT("sa"),
    SERBIAN("sr"),
    //SINDHI("sd"),
    SINHALESE("si"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SPANISH("es"),
    SWAHILI("sw"),
    SWEDISH("sv"),
    TAJIK("tg"),
    TAMIL("ta"),
    TAGALOG("tl"),
    TELUGU("te"),
    THAI("th"),
    //TIBETAN("bo"),
    TURKISH("tr"),
    UKRANIAN("uk"),
    URDU("ur"),
    UZBEK("uz"),
    //UIGHUR("ug"),
    VIETNAMESE("vi"),
    WELSH("cy"),
    YIDDISH("yi");


    override val androidResourceLanguages: List<AndroidResourceLanguage<GoogleTranslatableLanguage>>
        get() = AndroidResourceLanguage.fromLanguage(this)

    override val googlePlaystoreLanguages: List<GooglePlaystoreLanguage<GoogleTranslatableLanguage>>
        get() = GooglePlaystoreLanguage.fromLanguage(this)


    companion object {
        fun fromId(googleTranslatorLanguageId: String): GoogleTranslatableLanguage? {
            for (l in values()) {
                if (l.googleTranslatorLanguageId == googleTranslatorLanguageId) {
                    return l
                }
            }
            return null
        }

        fun all(): List<GoogleTranslatableLanguage> {
            val languageList = ArrayList<GoogleTranslatableLanguage>()
            val possibleValues = GoogleTranslatableLanguage.values()
            for (possibleValue in possibleValues) {
                if (!possibleValue.googleTranslatorLanguageId.isEmpty()) {
                    languageList.add(possibleValue)
                }
            }
            return languageList
        }
    }

}