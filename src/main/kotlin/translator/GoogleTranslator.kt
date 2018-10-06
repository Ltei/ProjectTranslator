package translator

import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import language.GoogleTranslatableLanguage
import utils.HTMLEntities
import java.net.URLEncoder
import java.util.*


class GoogleTranslator(val apiKey: String) : ITranslator<GoogleTranslatableLanguage> {

    private val API_URL = "https://www.googleapis.com/language/translate/v2"


    override fun translate(entries: Map<String, String>, languageFrom: GoogleTranslatableLanguage, languageTo: GoogleTranslatableLanguage): Map<String, String> {
        try {
            val client = OkHttpClient()

            val url = StringBuilder(API_URL)
            url.append("?key=").append(apiKey)
            url.append("&source=").append(languageFrom.googleTranslatorLanguageId)
            url.append("&target=").append(languageTo.googleTranslatorLanguageId)

            for (key in entries.keys) {
                val value = entries.get(key)
                url.append("&q=").append(URLEncoder.encode(value))
                url.append("&cid=").append(URLEncoder.encode(value)) //does not work as intended
            }

            val request = Request.Builder()
                    .url(url.toString())
                    .build()

            val response = client.newCall(request).execute()
            val responseBody = response.body().string()

            return parseResponse(responseBody, entries)
        } catch (e: Exception) {
            throw e
        }

    }

    private fun parseResponse(content: String, defaultEntries: kotlin.collections.Map<String, String>): kotlin.collections.Map<String, String> {
        val translations = TreeMap<String, String>()

        val gson = Gson()
        val payload = gson.fromJson(content, TranslationPayload::class.java)
        if (payload != null) {
            if (payload.data != null) {
                var numTranslation = 0
                for (key in defaultEntries.keys) {
                    val translation = payload.data!!.translations!![numTranslation]

                    var translatedText = translation.translatedText
                    translatedText = HTMLEntities.unhtmlentities(translatedText).trim()
                    translatedText = HTMLEntities.unhtmlAngleBrackets(translatedText)

                    translations[key] = translatedText
                    numTranslation++
                }

            } else {
                throw RuntimeException("[TranslatorGoogle] Parse - payload.data is null ($content)")
            }
        } else {
            throw RuntimeException("[TranslatorGoogle] Parse - payload is null ($content)")
        }

        return translations
    }

}