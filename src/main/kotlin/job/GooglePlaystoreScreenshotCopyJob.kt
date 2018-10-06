package job

import language.GooglePlaystoreLanguage
import language.ITranslatableLanguage
import utils.LPaths
import java.io.File
import java.nio.file.Files

class GooglePlaystoreScreenshotCopyJob<Language : ITranslatableLanguage<Language>>(val playFolderPath: String) {

    fun copy(fileName: String?, languageFrom: GooglePlaystoreLanguage<Language>, languageTo: GooglePlaystoreLanguage<Language>) {
        val folderFrom = LPaths.getGooglePlaystoreGraphicsFolder(playFolderPath, languageFrom)
        val folderTo = LPaths.getGooglePlaystoreGraphicsFolder(playFolderPath, languageTo)
        if (fileName == null) {
            for (file in folderFrom.listFiles()) {
                Files.copy(file.toPath(), File(folderTo, file.name).toPath())
            }
        } else {
            Files.copy(File(folderFrom, fileName).toPath(), File(folderTo, fileName).toPath())
        }
    }

}