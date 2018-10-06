package language

import java.util.*

class GooglePlaystoreLanguage<Language : ITranslatableLanguage<Language>> internal constructor(val translatableLanguage: Language, val id: String) {
    companion object {
        fun getCompliantLanguages(): List<GoogleTranslatableLanguage> {
            val languageList = ArrayList<GoogleTranslatableLanguage>()

            languageList.add(GoogleTranslatableLanguage.AFRIKAANS)
            languageList.add(GoogleTranslatableLanguage.GERMAN)
            languageList.add(GoogleTranslatableLanguage.ENGLISH)
            languageList.add(GoogleTranslatableLanguage.BELARUSIAN)
            languageList.add(GoogleTranslatableLanguage.BULGARIAN)
            languageList.add(GoogleTranslatableLanguage.CATALAN)
            languageList.add(GoogleTranslatableLanguage.CHINESE_SIMPLIFIED)
            languageList.add(GoogleTranslatableLanguage.CHINESE_TRADITIONAL)
            languageList.add(GoogleTranslatableLanguage.KOREAN)
            languageList.add(GoogleTranslatableLanguage.CROATIAN)
            languageList.add(GoogleTranslatableLanguage.DANISH)
            languageList.add(GoogleTranslatableLanguage.SPANISH)
            languageList.add(GoogleTranslatableLanguage.ESTONIAN)
            languageList.add(GoogleTranslatableLanguage.FILIPINO)
            languageList.add(GoogleTranslatableLanguage.FINNISH)
            languageList.add(GoogleTranslatableLanguage.FRENCH)
            languageList.add(GoogleTranslatableLanguage.GREEK)
            languageList.add(GoogleTranslatableLanguage.HEBREW)
            languageList.add(GoogleTranslatableLanguage.HINDI)
            languageList.add(GoogleTranslatableLanguage.HUNGARIAN)
            languageList.add(GoogleTranslatableLanguage.INDONESIAN)
            languageList.add(GoogleTranslatableLanguage.ITALIAN)
            languageList.add(GoogleTranslatableLanguage.JAPANESE)
            languageList.add(GoogleTranslatableLanguage.LITHUANIAN)
            languageList.add(GoogleTranslatableLanguage.MALAY)
            languageList.add(GoogleTranslatableLanguage.NORWEGIAN)
            languageList.add(GoogleTranslatableLanguage.PERSIAN)
            languageList.add(GoogleTranslatableLanguage.POLISH)
            languageList.add(GoogleTranslatableLanguage.PORTUGUESE)
            //languageList.add(ILanguage.ROMANIAN);
            languageList.add(GoogleTranslatableLanguage.SERBIAN)
            languageList.add(GoogleTranslatableLanguage.SLOVAK)
            languageList.add(GoogleTranslatableLanguage.SLOVENIAN)
            languageList.add(GoogleTranslatableLanguage.SWEDISH)
            languageList.add(GoogleTranslatableLanguage.SWAHILI)
            languageList.add(GoogleTranslatableLanguage.CZECH)
            languageList.add(GoogleTranslatableLanguage.THAI)
            languageList.add(GoogleTranslatableLanguage.TURKISH)
            languageList.add(GoogleTranslatableLanguage.UKRANIAN)
            languageList.add(GoogleTranslatableLanguage.VIETNAMESE)

            return languageList
        }

        fun fromLanguage(language: GoogleTranslatableLanguage): List<GooglePlaystoreLanguage<GoogleTranslatableLanguage>> {
            val result = ArrayList<GooglePlaystoreLanguage<GoogleTranslatableLanguage>>()

            if (language === GoogleTranslatableLanguage.AFRIKAANS) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.ARABIC) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.BELARUSIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.BULGARIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.CATALAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.CHINESE_SIMPLIFIED) {
                result.add(GooglePlaystoreLanguage(language, "zh-CN"))
            } else if (language === GoogleTranslatableLanguage.CHINESE_TRADITIONAL) {
                result.add(GooglePlaystoreLanguage(language, "zh-TW"))
            } else if (language === GoogleTranslatableLanguage.CROATIAN) {
                result.add(GooglePlaystoreLanguage(language, "cs-CZ"))
            } else if (language === GoogleTranslatableLanguage.CZECH) {
                result.add(GooglePlaystoreLanguage(language, "es-419"))
            } else if (language === GoogleTranslatableLanguage.DANISH) {
                result.add(GooglePlaystoreLanguage(language, "da-DK"))
            } else if (language === GoogleTranslatableLanguage.DUTCH) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.ENGLISH) {
                result.add(GooglePlaystoreLanguage(language, "en-US"))
                result.add(GooglePlaystoreLanguage(language, "en-GB"))
            } else if (language === GoogleTranslatableLanguage.ESTONIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.FRENCH) {
                GooglePlaystoreLanguage.addDuo(result, language)
                result.add(GooglePlaystoreLanguage(language, "fr-CA"))
            } else if (language === GoogleTranslatableLanguage.FILIPINO) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.FINNISH) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.GERMAN) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.GREEK) {
                result.add(GooglePlaystoreLanguage(language, "el-GR"))
            } else if (language === GoogleTranslatableLanguage.HEBREW) {
                result.add(GooglePlaystoreLanguage(language, "iw-IL"))
            } else if (language === GoogleTranslatableLanguage.HINDI) {
                result.add(GooglePlaystoreLanguage(language, "hi-IN"))
            } else if (language === GoogleTranslatableLanguage.HUNGARIAN) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.INDONESIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.ITALIAN) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.JAPANESE) {
                result.add(GooglePlaystoreLanguage(language, "ja-JP"))
            } else if (language === GoogleTranslatableLanguage.KOREAN) {
                result.add(GooglePlaystoreLanguage(language, "ko-KR"))
            } else if (language === GoogleTranslatableLanguage.LATVIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.LITHUANIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.MALAY) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.NORWEGIAN) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.PERSIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.POLISH) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.PORTUGUESE) {
                GooglePlaystoreLanguage.addDuo(result, language)
                result.add(GooglePlaystoreLanguage(language, "pt-BR"))
            } else if (language === GoogleTranslatableLanguage.RUSSIAN) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.ROMANIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.SERBIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.SLOVAK) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.SLOVENIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.SPANISH) {
                GooglePlaystoreLanguage.addDuo(result, language)
                result.add(GooglePlaystoreLanguage(language, "es-US"))
                result.add(GooglePlaystoreLanguage(language, "es-419"))
            } else if (language === GoogleTranslatableLanguage.SWAHILI) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.SWEDISH) {
                result.add(GooglePlaystoreLanguage(language, "sv-SE"))
            } else if (language === GoogleTranslatableLanguage.THAI) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.TURKISH) {
                GooglePlaystoreLanguage.addDuo(result, language)
            } else if (language === GoogleTranslatableLanguage.UKRANIAN) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else if (language === GoogleTranslatableLanguage.VIETNAMESE) {
                GooglePlaystoreLanguage.addSingle(result, language)
            } else {
                val playStoreLanguage = language.googleTranslatorLanguageId + "-" + language.googleTranslatorLanguageId.toUpperCase()
                result.add(GooglePlaystoreLanguage(language, playStoreLanguage))
            }

            return result
        }

        private fun addSingle(languages: MutableList<GooglePlaystoreLanguage<GoogleTranslatableLanguage>>, language: GoogleTranslatableLanguage) {
            languages.add(GooglePlaystoreLanguage(language, language.googleTranslatorLanguageId))
        }

        private fun addDuo(languages: MutableList<GooglePlaystoreLanguage<GoogleTranslatableLanguage>>, language: GoogleTranslatableLanguage) {
            val playStoreLanguage = language.googleTranslatorLanguageId + "-" + language.googleTranslatorLanguageId.toUpperCase()
            languages.add(GooglePlaystoreLanguage(language, playStoreLanguage))
        }
    }
}