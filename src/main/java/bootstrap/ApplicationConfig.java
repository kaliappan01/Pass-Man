package bootstrap;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class ApplicationConfig {
    public final String fileName;
    public final String passwd;
    public final String logFilePath;
    public final boolean debug;

    public ApplicationConfig(String[] args) {
        Namespace namespace = buildNameSpace(args);
        this.fileName = namespace.getString("file.name");
        this.passwd = namespace.getString("master.password");
        this.logFilePath = namespace.getString("log.file.path");
        this.debug = namespace.getBoolean("debug.log");
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public boolean isDebug() {
        return debug;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPasswd() {
        return passwd;
    }

    public Namespace buildNameSpace(String[] args) {
        Namespace namespace = null;
        ArgumentParser argumentParser = ArgumentParsers.newFor("KP-passMan")
                .build()
                .defaultHelp(true)
                .description("Stores password safely");
        argumentParser.addArgument("--master.password").type(String.class);
        argumentParser.addArgument("--file.name").type(String.class);
        argumentParser.addArgument("--debug.log").type(Boolean.class);
        argumentParser.addArgument("--log.file.path").type(String.class);
        try {
            namespace = argumentParser.parseArgs(args);
        } catch (ArgumentParserException e) {
            e.printStackTrace();
        }
        return namespace;
    }
}
