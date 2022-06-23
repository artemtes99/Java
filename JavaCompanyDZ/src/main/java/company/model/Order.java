package company.model;

/**
 * Класс для представления сущности "Приказ"
 */
public abstract class Order extends AbstractDocument {

    protected final String employee;
    protected String text;
    protected String status;

    public Order(String title, String number, String employee, String text) {
        super(title, number);
        this.employee = employee;
        this.text = text;
        this.status = "Создан";
    }

    public void changeStatus(){
        status = "Исполнен";
    }

    public String getEmployee() {
        return employee;
    }

    public String getOrder(){
        return this.getDocument() +
                ("Сотрудник: " + employee + "\n    " +
                 "Текст приказа: " + text + "\n    " +
                 "Статус: " + status + "\n    ");
    }
    @Override
    public String toString() {
        return "Приказ:" + "\n    " + this.getDocument() +
                ("Сотрудник: " + employee + "\n    " +
                 "Текст приказа: " + text + "\n    " +
                 "Статус: " + status + "\n    ");
    }
}
