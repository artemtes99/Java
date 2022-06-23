package company.source;

import com.google.gson.Gson;
import company.log.Logger;
import company.log.LoggerFactory;
import company.model.*;
import java.io.FileReader;

/**
 * Класс реализации DataCollector для JSON источника данных
 */
public class JsonDataCollector implements DataCollector{
    private final static Logger LOGGER = LoggerFactory.getLogger();
    @Override
    public DocumentData fetchData() {

        Gson gson = new Gson();

        try(FileReader reader = new FileReader("json_data_source.json")){

            return gson.fromJson(reader, DocumentData.class);

        } catch (Exception e){
            LOGGER.error("Ошибка парсинга JSON " , e);
        }

        return null;
    }
}
