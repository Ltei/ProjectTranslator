package translator

class TranslationPayload(var data: TranslationDataPayload?)
class TranslationDataPayload(var translations: List<TranslationTextPayload>?)
class TranslationTextPayload(var translatedText: String?)