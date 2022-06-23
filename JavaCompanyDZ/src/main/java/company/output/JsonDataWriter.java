package company.output;

import com.google.gson.Gson;
import company.log.Logger;
import company.log.LoggerFactory;
import company.model.DocumentData;
import java.io.FileWriter;

/**
 * Класс реализации интерфейса DataWriter для JSON формата
 */
public class JsonDataWriter implements DataWriter {

    private final static Logger LOGGER = LoggerFactory.getLogger();
    @Override
    public void writeData(DocumentData documentData) {

        Gson gson = new Gson();

        try(FileWriter writer = new FileWriter("json_data_source.json", false))
        {
            String documentDataJson = gson.toJson(documentData);
            writer.write(documentDataJson);
            writer.flush();
        }
        catch(Exception e){

            LOGGER.error("Ошибка записи в JSON " , e);
        }
    }
}

   
