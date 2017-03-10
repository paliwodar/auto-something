class Integration {

    static void main(String[] args) {
        if (args.size() > 0) {
            def automaker = new Automaker()
            def binding = new Binding([
                    automaker: automaker,
                    system   : automaker.&system,
                    jq       : automaker.&jq])
            new GroovyShell(binding).evaluate(new File(args[0]))
        } else {
            println "no input file given"
        }
    }

}
