package company.view;

import company.analysis.StatResult;
import company.analysis.StatisticProcessor;
import company.log.Logger;
import company.log.LoggerFactory;
import company.model.*;
import company.output.DataWriter;
import company.output.JsonDataWriter;
import company.source.DataCollector;
import company.source.JsonDataCollector;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс интерфейса приложения, связывает ввод с логикой программы
 */
public class UI {
    private final static Logger LOGGER = LoggerFactory.getLogger();
    private DocumentData documentData; //Единый файл с тремя списками документов разного типа
    private final StatisticProcessor analyzer;

    public UI(DocumentData documentData, StatisticProcessor analyzer){
        this.documentData = documentData;
        this.analyzer = analyzer;
    }

    public void Run(){
        Scanner input = new Scanner(System.in);
        boolean sessionIsRunning = true;

        while (sessionIsRunning){
            ArrayList<Document> documentList = documentData.getDocumentsArray(); //Преобразование для работы с единым массивом
            LOGGER.info("help - Помощь");
            LOGGER.info("Введите команду: ");
            String userInput = input.nextLine();
            switch (userInput){ //Обработка пользовательского ввода
                case "help":
                    HelpCommand();
                    break;

                case "loadSource":
                    LoadFromSourceToDataCommand(documentData);
                    break;

                case "showAll":
                    for(Document document : documentList) {
                        LOGGER.info( document.toString());
                    }
                    break;

                case "docAnalis":
                    DocumentsAnalyzeCommand(documentList);
                    break;

                case "empAnalis":
                    EmployeesAnalyzeCommand(documentList);
                    break;

                case "creatLetter":
                    CreateLetterCommand(input);
                    break;

                case "creatOrderAccept":
                    CreateOrderAcceptanceCommand(input);
                    break;

                case "creatOrderDissmis":
                    CreateOrderDismissalCommand(input);
                    break;

                case "changOrderStatus":
                    ChangeOrderStatusCommand(input,documentList);
                    break;

                case "writeData":
                    WriteToFileCommand();
                    break;

                case "exit":
                    LOGGER.info("Завершение работы");
                    sessionIsRunning = false;
                    break;

                default:
                    LOGGER.info("Команда не распознана");
                    break;
            }
        }
    }

    public void HelpCommand(){
        LOGGER.info("Команды:\n" +
                "docAnalis - Анализ документов\n" +
                "empAnalis - Анализ сотрудников\n" +
                "loadSource - Выгрузить данные из файла\n" +
                "creatLetter - Создать письмо\n" +
                "creatOrderAccept - Создать приказ о принятии на работу\n" +
                "creatOrderDissmis - Создать приказ об увольнении\n" +
                "changOrderStatus - Изменить статус приказа\n" +
                "writeData - Записать данные в файл\n" +
                "exit - Остановить выполнение программы\n");

    }
    public void LoadFromSourceToDataCommand(DocumentData documentData){
        DataCollector source =new JsonDataCollector();
        documentData = source.fetchData();
        LOGGER.info("Загрузка завершена");
    }
    public void DocumentsAnalyzeCommand(ArrayList<Document> documentList){
        StatResult resultByDocs = analyzer.countStatByDoc(documentList);

        LOGGER.info(resultByDocs.getStatisticByDocType());
    }
    public void EmployeesAnalyzeCommand(ArrayList<Document> documentList){
        StatResult resultByEmployees = analyzer.countStatByEmployee(documentList);
        LOGGER.info(resultByEmployees.getStatisticByEmployee());
    }
    public void CreateLetterCommand(Scanner input){

        String tittle, number, from, to;
        LOGGER.info("Введите название письма: ");
        tittle = input.nextLine();
        LOGGER.info("Введите № письма: ");
        number = input.nextLine();
        LOGGER.info("Введите от кого письмо: ");
        from = input.nextLine();
        LOGGER.info("Введите кому письмо: ");
        to = input.nextLine();

        documentData.addDoc(new Letter(tittle, number, from, to));

        LOGGER.info("Документ создан, для сохранения, запишите данные в файл");
    }
    public void CreateOrderAcceptanceCommand(Scanner input){

        String tittle, number, employee, textOrder;
        LOGGER.info("Введите название приказа: ");
        tittle = input.nextLine();
        LOGGER.info("Введите № приказа: ");
        number = input.nextLine();
        LOGGER.info("Введите ФИО сотрудника: ");
        employee = input.nextLine();
        LOGGER.info("Введите текст приказа: ");
        textOrder = input.nextLine();

        documentData.addDoc(new OrderPersonAcceptance(tittle,number,employee,textOrder));
        LOGGER.info("Документ создан, для сохранения, запишите данные в файл");
    }
    public void CreateOrderDismissalCommand(Scanner input){

        String tittle, number, employee, textOrder, textReasonDismissal;
        LOGGER.info("Введите название приказа на увольнение: ");
        tittle = input.nextLine();
        LOGGER.info("Введите № приказа на увольнение: ");
        number = input.nextLine();
        LOGGER.info("Введите ФИО сотрудника: ");
        employee = input.nextLine();
        LOGGER.info("Введите текст приказа: ");
        textOrder = input.nextLine();
        LOGGER.info("Введите причину увольнения: ");
        textReasonDismissal = input.nextLine();

        documentData.addDoc(new OrderPersonDismissal(tittle,number,employee,textOrder, textReasonDismissal));
        LOGGER.info("Документ создан, для сохранения, запишите данные в файл");
    }
    public void WriteToFileCommand(){
        DataWriter writer = new JsonDataWriter();
        writer.writeData(documentData);
        LOGGER.info("Запись данных завершена");
    }
    public void ChangeOrderStatusCommand(Scanner input, ArrayList<Document> documentList){
        String userInput;
        LOGGER.info("Введите номер приказа");
        userInput = input.nextLine();

        for (Document document: documentList) {
            if(document.getNumber().equals(userInput)){
                Order personnelDoc = (Order) document;
                personnelDoc.changeStatus();
                LOGGER.info("Приказ изменен, для сохранения изменений запишите данные в файл");
                return;
            }
        }
        LOGGER.info("Приказ не найден");

    }


}
