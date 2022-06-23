package company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения списков разных данных
 */
public class DocumentData {

     List<Letter> lettersList;
     List<OrderPersonAcceptance> acceptanceList;
     List<OrderPersonDismissal> dismissalList;

     public ArrayList<Document> getDocumentsArray(){ //возвращает единый список

          ArrayList<Document> allDocumentsList = new ArrayList<>();

          allDocumentsList.addAll(lettersList);
          allDocumentsList.addAll(acceptanceList);
          allDocumentsList.addAll(dismissalList);
          return allDocumentsList;
     }

     //Перегрузка метода для каждого из трёх типов документов
     public void addDoc(Letter letterDocument){
          lettersList.add(letterDocument);
     }
     public void addDoc(OrderPersonAcceptance orderPersonAcceptanceDocument){
          acceptanceList.add(orderPersonAcceptanceDocument);
     }
     public void addDoc(OrderPersonDismissal orderPersonDismissalDocument){
          dismissalList.add(orderPersonDismissalDocument);
     }

}
