package utils

import language.AndroidResourceLanguage
import language.GooglePlaystoreLanguage
import language.ITranslatableLanguage
import java.io.File

object LPaths {

    fun <Language : ITranslatableLanguage<Language>> getGooglePlaystoreBaseFolder(playFolderPath: String, language: GooglePlaystoreLanguage<Language>): File {
        return File("$playFolderPath/listings/${language.id}/graphics")
    }

    fun <Language : ITranslatableLanguage<Language>> getGooglePlaystoreGraphicsFolder(playFolderPath: String, language: GooglePlaystoreLanguage<Language>): File {
        return File("$playFolderPath/listings/${language.id}/graphics")
    }

    fun getAndroidResourceValuesFolder(resourcesPath: String): File {
        return File("$resourcesPath/values")
    }

    fun <Language : ITranslatableLanguage<Language>> getAndroidResourceValuesFolder(resourcesPath: String, language: AndroidResourceLanguage<Language>): File {
        return File("$resourcesPath/values-${language.id}")
    }

}