// Responsabilite 3 : prevenir quelqu'un (email, SMS, Slack...)
public interface Notificateur {
    void notifier(String message);
}