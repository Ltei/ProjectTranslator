package translator

interface ITranslator<Language> {

    /**
     * Translate the entries from languageFrom to languageTo
     *
     * @param entries      The entries to translate
     * @param languageFrom The input language
     * @param languageTo   THe output language
     * @return The translated entries
     */
    fun translate(entries: Map<String, String>, languageFrom: Language, languageTo: Language): Map<String, String>

}