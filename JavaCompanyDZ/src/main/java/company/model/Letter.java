package company.model;

/**
 * Класс для представления сущности "Письмо"
 */

public class Letter extends AbstractDocument {

    private final String from;
    private final String to;

    public Letter(String title, String number, String from, String to) {
        super(title, number);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Письмо: " + "\n    " + this.getDocument() +
                "От кого: " + from + "\n    " +
                "Кому: " + to + "\n    ";
    }
}
