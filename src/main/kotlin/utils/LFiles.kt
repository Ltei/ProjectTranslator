package utils

import java.io.IOException
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.File
import java.io.FileReader
import java.io.BufferedReader



object LFiles {

    val BR = "\n"
    val TAB = "\t"

    fun read(fileName: String): String? {
        return read(File(fileName))
    }

    fun read(file: File): String? {
        var br: BufferedReader? = null
        val sb = StringBuilder()

        try {
            br = BufferedReader(FileReader(file))
            var line: String? = br.readLine()
            while (line != null) {
                sb.append(line)
                sb.append(System.lineSeparator())
                line = br.readLine()
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } finally {
            try {
                br!!.close()
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }

        }

        return sb.toString()
    }

    fun write(fileNames: List<String>, content: String) {
        for (fileName in fileNames) {
            println("Writing to file : $fileName")
            write(fileName, content)
        }
    }

    fun write(fileName: String, content: String) {
        write(File(fileName), content)
    }

    fun write(file: File, content: String) {
        var bw: BufferedWriter? = null

        try {
            file.parentFile.mkdirs()

            val fwLang = FileWriter(file)
            bw = BufferedWriter(fwLang)
            bw.write(content)

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                bw!!.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

}