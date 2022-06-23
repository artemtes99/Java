package company.model;

/**
 * Абстрактный класс документа с общими атрибутами для наследников
 * @author Тесленко Артём
 * @version 1.0
 */
public abstract class AbstractDocument implements Document {

    private final String number;

    private final String title;

    public AbstractDocument(String title, String number) {
        this.title = title;
        this.number = number;

    }

    public String getNumber() {return number;}

    public String getDocument() {
        return "Номер документа: " + number + "\n    " +
               "Название: " + title + "\n    ";
    }
    @Override
    public String toString() {
        return "Документ:" + "\n    "+
               "Номер доумента: " + number + "\n    " +
               "Название: " + title + "\n    ";
    }
}
