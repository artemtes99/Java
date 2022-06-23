package company.analysis;

import company.log.Logger;
import company.log.LoggerFactory;
import company.model.Document;
import company.model.Order;
import java.util.HashSet;
import java.util.List;

/**
 * Класс анализа данных в разрезе типов документов и анализа в разрезе сотрудников
 */
public class DataAnalyzer implements StatisticProcessor{
    private final static Logger LOGGER = LoggerFactory.getLogger();

    @Override
    public StatResult countStatByDoc(List<Document> sourceData) {

        LOGGER.info("Расчет статистики документов...");

        int letterCount = 0, orderAcceptanceCount = 0, orderDismissalCount = 0;

        for (Document document: sourceData) {

            String docType = document.getClass().getSimpleName();
            switch (docType){
                case "Letter":
                    letterCount++;
                    break;
                case "OrderPersonAcceptance":
                    orderAcceptanceCount++;
                    break;
                case "OrderPersonDismissal":
                    orderDismissalCount++;
                    break;
            }
        }

        LOGGER.info("Расчет статистики документов закончен.");

        String docsAnalyzeResult = "Анализ документов:\n    Писем: " + letterCount +
                "\n    Приказов на прием: " + orderAcceptanceCount +
                "\n    Приказов на увольнение: " + orderDismissalCount;

        StatResult statResultByDoc = new StatResult();
        statResultByDoc.setStatisticByDocType(docsAnalyzeResult);
        return statResultByDoc;
    }

    @Override
    public StatResult countStatByEmployee(List<Document> sourceData) {

        LOGGER.info("Расчет статистики сотрудников...");
        HashSet<String> employees = new HashSet<>();

        for(Document document: sourceData){

            String docType = document.getClass().getSimpleName();
            if(docType.equals("OrderPersonAcceptance")){
                employees.add(((Order) document).getEmployee());
            }
            if(docType.equals("OrderPersonDismissal")){
                employees.remove(((Order) document).getEmployee());
            }
        }

        LOGGER.info("Расчет статистики сотрудников закончен.");

        StringBuilder employeesAnalyzeResult = new StringBuilder("Актуальный список сотрудников:");
        for (String str : employees){
            employeesAnalyzeResult.append("\n    ").append(str);
        }

        StatResult statResultByEmployee = new StatResult();
        statResultByEmployee.setStatisticByEmployee(String.valueOf(employeesAnalyzeResult));
        return statResultByEmployee;

    }


}
