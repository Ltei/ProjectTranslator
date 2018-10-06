package language

class AndroidResourceLanguage<Language: ITranslatableLanguage<Language>>  internal constructor(val translatableLanguage: Language, val id: String) {

    companion object {
        fun fromLanguage(language: GoogleTranslatableLanguage): List<AndroidResourceLanguage<GoogleTranslatableLanguage>> {
            val result = language.googleTranslatorLanguageId
            return when {
                result.equals(GoogleTranslatableLanguage.CHINESE_SIMPLIFIED.googleTranslatorLanguageId, ignoreCase = true) -> listOf(AndroidResourceLanguage(language, "zh-rCN"))
                result.equals(GoogleTranslatableLanguage.CHINESE_TRADITIONAL.googleTranslatorLanguageId, ignoreCase = true) -> listOf(AndroidResourceLanguage(language, "zh-rTW"))
                else -> listOf(AndroidResourceLanguage(language, result))
            }
        }
    }

}