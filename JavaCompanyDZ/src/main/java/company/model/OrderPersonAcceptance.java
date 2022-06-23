package company.model;

/**
 * Класс для представления сущности "Приказ о приеме на работу"
 *
 * @see Order
 */

public class OrderPersonAcceptance extends Order{
    public OrderPersonAcceptance(String title, String number, String employee, String text) {
        super(title, number, employee, text);
    }


}
