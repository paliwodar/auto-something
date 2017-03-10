class Automaker {

    static {
        String.metaClass.jq = { command ->
            jq delegate, command
        }
    }

    def system(String arg1, String arg2 = null) {
        def proc
        if (arg2 == null) {
            proc = arg1.execute()
        } else {
            proc = "echo ${arg1}".execute() | arg2.execute()
        }

        def outputStream = new StringBuffer();
        proc.waitForProcessOutput outputStream, System.err

        outputStream.toString()
    }

    def jq(String source, String command) {
        def proc = "echo ${source}".execute() | "jq ${command}".execute()

        def outputStream = new StringBuffer();
        proc.waitForProcessOutput outputStream, System.err

        outputStream.toString()
    }



}
