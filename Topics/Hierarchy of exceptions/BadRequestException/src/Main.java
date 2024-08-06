// update the class
class BadRequestException extends Exception{
    // Constructor that takes a String message as an argument
        public BadRequestException(String message) {
        // Pass the message to the superclass (Exception) constructor
            super(message);
        }
}