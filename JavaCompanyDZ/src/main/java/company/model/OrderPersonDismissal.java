package company.model;

/**
 * Класс для представления сущности "Приказ о увольнении"
 *
 * @see Order
 */

public class OrderPersonDismissal extends Order{

    private final String reasonDismissal;

    public OrderPersonDismissal(String title, String number, String employee, String text, String reasonDismissal) {
        super(title, number, employee, text);
        this.reasonDismissal = reasonDismissal;
    }

    @Override
    public String toString() {
        return "Приказ об увольнении" + "\n    " + this.getOrder() +
                "Причина увольнения: " + reasonDismissal + "\n    ";
    }
}
