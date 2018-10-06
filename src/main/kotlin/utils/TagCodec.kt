package utils

class TagCodec(val entries: Array<Entry>) {

    class Entry(internal var fileValue: String, internal var translateValue: String)


    fun inputToTranslatable(input: String): String {
        var input = input
        for (e in entries) {
            input = input.replace(e.fileValue, e.translateValue)
        }
        return input
    }

    fun translatedToOutput(translate: String): String {
        var translate = translate
        for (e in entries) {
            translate = translate.replace(e.translateValue, e.fileValue)
        }
        return translate
    }

}