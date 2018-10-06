package job

import language.GooglePlaystoreLanguage
import language.ITranslatableLanguage
import translator.ITranslator
import utils.LFiles
import utils.LPaths
import java.io.File
import java.util.*


class GooglePlaystoreTranslationJob<Language : ITranslatableLanguage<Language>>(
        val playFolderPath: String,
        var parseTitle: Boolean = false,
        var parseWhatsnew: Boolean = false,
        var parseFullDescription: Boolean = false,
        var parseShortDescription: Boolean = false
) {

    companion object {
        private const val TAG_TITLE = "[TITLE]"
        private const val TAG_WHATS_NEW = "[WHATS_NEW]"
        private const val TAG_SHORT_DESCRIPTION = "[SHORT_DESCRIPTION]"

        private const val PATH_TITLE = "/listing/title"
        private const val PATH_WHATS_NEW = "/whatsnew"
        private const val PATH_FULL_DESCRIPTION = "/listing/fulldescription"
        private const val PATH_SHORT_DESCRIPTION = "/listing/shortdescription"
    }


    fun translate(translator: ITranslator<Language>, languageFrom: GooglePlaystoreLanguage<Language>, languageTo: GooglePlaystoreLanguage<Language>) {
        val input = readInput(languageFrom)
        val translated = translator.translate(input, languageFrom.translatableLanguage, languageTo.translatableLanguage)
        writeTranslated(translated, languageTo)
    }

    private fun readInput(languageFrom: GooglePlaystoreLanguage<Language>): Map<String, String> {
        val result = TreeMap<String, String>()
        if (parseTitle) {
            result["title"] = readFromFile(PATH_TITLE, languageFrom)
        }
        if (parseWhatsnew) {
            result["whatsnew"] = readFromFile(PATH_WHATS_NEW, languageFrom)
        }
        if (parseFullDescription) {
            result["fulldesc"] = readFromFile(PATH_FULL_DESCRIPTION, languageFrom)
        }
        if (parseShortDescription) {
            result["shortdesc"] = readFromFile(PATH_SHORT_DESCRIPTION, languageFrom)
        }
        return result
    }


    private fun writeTranslated(output: Map<String, String>, languageTo: GooglePlaystoreLanguage<Language>) {
        var value: String? = output["title"]
        if (value != null) {
            writeToFile(PATH_TITLE, languageTo, value)
        }
        value = output["whatsnew"]
        if (value != null) {
            writeToFile(PATH_WHATS_NEW, languageTo, value)
        }
        value = output["fulldesc"]
        if (value != null) {
            writeToFile(PATH_FULL_DESCRIPTION, languageTo, value)
        }
        value = output["shortdesc"]
        if (value != null) {
            writeToFile(PATH_SHORT_DESCRIPTION, languageTo, value)
        }
    }


    private fun readFromFile(filePath: String, language: GooglePlaystoreLanguage<Language>): String {
        var result = LFiles.read(File(LPaths.getGooglePlaystoreBaseFolder(playFolderPath, language), filePath))

        assertInputTagsValidity(filePath, result!!)

        result = result.replace(TAG_TITLE, "Xavier")
        result = result.replace(TAG_WHATS_NEW, "Albert")
        result = result.replace(TAG_SHORT_DESCRIPTION, "Alfred")
        return result
    }

    private fun writeToFile(filePath: String, language: GooglePlaystoreLanguage<Language>, value: String) {
        var value = value
        if (value.contains("Xavier")) {
            val title = readFromFile(PATH_TITLE, language)
            value = value.replace("Xavier", title.trim { it <= ' ' })
        }
        if (value.contains("Albert")) {
            val whatsnew = readFromFile(PATH_WHATS_NEW, language)
        }
        LFiles.write(File(LPaths.getGooglePlaystoreBaseFolder(playFolderPath, language), filePath), value)
    }

    private fun assertInputTagsValidity(filePath: String, input: String) {
        assertInputTagNotIn(filePath, input, PATH_TITLE, TAG_TITLE)
        assertInputTagNotIn(filePath, input, PATH_TITLE, TAG_WHATS_NEW)
        assertInputTagNotIn(filePath, input, PATH_TITLE, TAG_SHORT_DESCRIPTION)
        assertInputTagNotIn(filePath, input, PATH_WHATS_NEW, TAG_WHATS_NEW)
        assertInputTagNotIn(filePath, input, PATH_WHATS_NEW, TAG_SHORT_DESCRIPTION)
        assertInputTagNotIn(filePath, input, PATH_SHORT_DESCRIPTION, TAG_SHORT_DESCRIPTION)
    }

    private fun assertInputTagNotIn(filePath: String, input: String, checkFilePath: String, checkTag: String) {
        if (filePath == checkFilePath && input.contains(checkTag))
            throw IllegalStateException("You cannot use $checkTag in the $checkFilePath file !")
    }


}