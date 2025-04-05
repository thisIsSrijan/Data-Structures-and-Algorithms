
public class CoR {
    // 1. Abstract Handler

    abstract class Logger {

        public static int INFO = 1;
        public static int DEBUG = 2;
        public static int ERROR = 3;

        protected int level;
        protected Logger nextLogger;

        public void setNextLogger(Logger nextLogger) {
            this.nextLogger = nextLogger;
        }

        public void logMessage(int level, String message) {
            if (this.level <= level) {
                write(message);
            }
            if (nextLogger != null) {
                nextLogger.logMessage(level, message);
            }
        }

        protected abstract void write(String message);
    }

// 2. Concrete Handlers
    static class InfoLogger extends Logger {

        public InfoLogger(int level) {
            this.level = level;
        }

        protected void write(String message) {
            System.out.println("INFO: " + message);
        }
    }

    static class DebugLogger extends Logger {

        public DebugLogger(int level) {
            this.level = level;
        }

        protected void write(String message) {
            System.out.println("DEBUG: " + message);
        }
    }

    static class ErrorLogger extends Logger {

        public ErrorLogger(int level) {
            this.level = level;
        }

        protected void write(String message) {
            System.out.println("ERROR: " + message);
        }
    }

// 3. Client
    public class ChainPatternDemo {

        private static Logger getChainOfLoggers() {
            Logger errorLogger = new ErrorLogger(Logger.ERROR);
            Logger debugLogger = new DebugLogger(Logger.DEBUG);
            Logger infoLogger = new InfoLogger(Logger.INFO);

            // Setting up chain: info -> debug -> error
            infoLogger.setNextLogger(debugLogger);
            debugLogger.setNextLogger(errorLogger);

            return infoLogger;
        }

        public static void main(String[] args) {
            Logger loggerChain = getChainOfLoggers();

            loggerChain.logMessage(Logger.INFO, "This is an info message.");
            loggerChain.logMessage(Logger.DEBUG, "This is a debug message.");
            loggerChain.logMessage(Logger.ERROR, "This is an error message.");
        }
    }
}
