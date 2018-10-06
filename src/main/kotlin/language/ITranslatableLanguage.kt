package language

interface ITranslatableLanguage<This: ITranslatableLanguage<This>> {
    val androidResourceLanguages: List<AndroidResourceLanguage<This>>
    val googlePlaystoreLanguages: List<GooglePlaystoreLanguage<This>>
}