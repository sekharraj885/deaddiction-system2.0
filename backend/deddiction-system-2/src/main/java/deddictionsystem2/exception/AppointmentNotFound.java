package deddictionsystem2.exception;

public class AppointmentNotFound extends RuntimeException{
    public AppointmentNotFound() {
    }

    public AppointmentNotFound(String message) {
        super(message);
    }
}
