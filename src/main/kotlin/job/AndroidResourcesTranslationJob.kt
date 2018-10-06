package job

import language.AndroidResourceLanguage
import language.ITranslatableLanguage
import org.w3c.dom.Element
import translator.ITranslator
import utils.LFiles
import utils.LPaths
import utils.TagCodec
import java.io.File
import java.io.StringWriter
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


class AndroidResourcesTranslationJob<Language : ITranslatableLanguage<Language>>(
        val resourcesPath: String
) {

    private val tagCodec = TagCodec(arrayOf(
            TagCodec.Entry("%1\$s", "456287121"),
            TagCodec.Entry("%2\$s", "456287122"),
            TagCodec.Entry("%3\$s", "456287123"),
            TagCodec.Entry("%4\$s", "456287124"),
            TagCodec.Entry("%5\$s", "456287125"),
            TagCodec.Entry("%1\$d", "456287126"),
            TagCodec.Entry("%2\$d", "456287127"),
            TagCodec.Entry("%3\$d", "456287128"),
            TagCodec.Entry("%4\$d", "456287129"),
            TagCodec.Entry("%5\$d", "456287130")
    ))


    fun translate(translator: ITranslator<Language>, inputFileName: String, languageFrom: AndroidResourceLanguage<Language>, languageTo: AndroidResourceLanguage<Language>) {
        val input = readInput(resourcesPath, inputFileName)
        val translated = translator.translate(input, languageFrom.translatableLanguage, languageTo.translatableLanguage)
        writeTranslated(resourcesPath, inputFileName, translated, languageTo)
    }

    //

    private fun readInput(resourcesPath: String, inputFileName: String): Map<String, String> {
        val input = readResourceFile(resourcesPath, inputFileName)

        val translatable = TreeMap<String, String>()
        for ((key, value) in input) {
            translatable[key] = inputToTranslatable(value)
        }

        return translatable
    }

    private fun writeTranslated(resourcesPath: String, inputFileName: String, translated: Map<String, String>, languageTo: AndroidResourceLanguage<Language>) {
        val output = TreeMap<String, String>()
        for ((key, value) in translated) {
            output[key] = translatedToOutput(value)
        }

        val content = StringBuilder()
        content.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + LFiles.BR)
        content.append("<resources>" + LFiles.BR)

        for ((key, value) in output) {
            content.append(LFiles.TAB + "<string name=\"").append(key).append("\">").append(value).append("</string>").append(LFiles.BR)
        }

        content.append("</resources>")

        LFiles.write(File(LPaths.getAndroidResourceValuesFolder(resourcesPath, languageTo), inputFileName), tagCodec.translatedToOutput(content.toString()))
    }

    // readInput utils

    private fun readResourceFile(resourcesPath: String, inputFileName: String): Map<String, String> {
        val result = TreeMap<String, String>()

        try {
            val dbf = DocumentBuilderFactory.newInstance()
            val db = dbf.newDocumentBuilder()
            val doc = db.parse(File(LPaths.getAndroidResourceValuesFolder(resourcesPath), inputFileName))
            doc.documentElement.normalize()
            val strings = doc.getElementsByTagName("string")
            if (strings != null) {
                val sw = StringWriter()
                val serializer = TransformerFactory.newInstance().newTransformer()
                serializer.transform(DOMSource(strings.item(0)), StreamResult(sw))
                for (numChild in 0 until strings.length) {
                    val entry = strings.item(numChild) as Element
                    val key = entry.getAttribute("name")
                    var value = ""
                    if (entry.hasChildNodes()) {
                        value = entry.childNodes.item(0).getNodeValue()
                    }
                    result[key] = value
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println("[WARNING] file may not be found : " + File(LPaths.getAndroidResourceValuesFolder(resourcesPath), inputFileName))
            return TreeMap()
        }

        return result
    }

    private fun inputToTranslatable(input: String): String {
        var input = input
        input = input.replace("\\'", "'")
        return tagCodec.inputToTranslatable(input)
    }

    // writeOutput utils

    private fun translatedToOutput(translated: String): String {
        var translated = translated
        translated = translated.replace("'", "\\'")
        return tagCodec.translatedToOutput(translated)
    }

}