package company.analysis;

import company.model.Document;

import java.util.List;

public interface StatisticProcessor {

    /**
     * Метод для подсчета количества документов для каждого типа
     * @param sourceData список документов
     * @return строка со статистикой
     */
    StatResult countStatByDoc(List<Document> sourceData);

    /**
     * Метод для подсчета количества документов для каждого сотрудника
     * @param sourceData
     * @return
     */
    StatResult countStatByEmployee(List<Document> sourceData);
}
