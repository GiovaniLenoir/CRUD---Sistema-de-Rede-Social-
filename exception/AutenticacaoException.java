package exception;

    public class AutenticacaoException extends Exception {
        public AutenticacaoException(String message) {
            super(message);
        }
        public AutenticacaoException(String message, Throwable causa) {
            super(message, causa);
        }
    }


