package company;

import company.analysis.DataAnalyzer;
import company.analysis.StatisticProcessor;
import company.model.DocumentData;
import company.source.DataCollector;
import company.source.JsonDataCollector;
import company.view.UI;

public class Main {
    public static void main(String[] args) {

        DataCollector source = new JsonDataCollector();
        DocumentData documentData = source.fetchData();
        StatisticProcessor analyzer = new DataAnalyzer();
        UI UI = new UI(documentData, analyzer);
        UI.Run();
    }
}