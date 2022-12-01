import java.io.File

data class Message(val address: String?, val topic: String?, val message:String?, val htmlFile: File) {}

fun Message.toHTML() {
    var template = "<head>\n" +
            "    <style>\n" +
            "        body {\n" +
            "            background: rgb(175, 238, 238);\n" +
            "            font-size: 15px;\n" +
            "            font-family: 'Courier New', Courier, monospace;\n" +
            "        }\n" +
            "\n" +
            "        table {\n" +
            "            margin: auto;\n" +
            "            margin-top: 120px;\n" +
            "            background: rgb(30, 144, 255);\n" +
            "            width: 400px;\n" +
            "            border: 3px solid #4B0082;\n" +
            "        }\n" +
            "\n" +
            "        td {\n" +
            "            background: #DEB887;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <table cellpadding=\"10\" cellspacing=\"6\">"
    with(address) {
        if (!address.isNullOrBlank()) {
            template+="<tr><td>address</td><td>$address</td></tr>\n"
        }
    }
    with(topic) {
        if (!topic.isNullOrBlank()) {
            template+="<tr><td>topic</td><td>$topic</td></tr>\n"
        }
    }
    with(message) {
        if (!topic.isNullOrBlank()) {
            template+="<tr><td>message</td><td>$message</td></tr>\n"
        }
    }
    template+="    </table>\n" +
            "</body>"
    htmlFile.writeText(template)
}
fun main() {

    var file = File("file.html")

    file.writeText("created new file fro program")

    val m = Message("irishka-selenia@yandex.ru", "topic", "Hello World",file)
    println(m.toHTML())

}