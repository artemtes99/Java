package company.analysis;

/**
 * Класс для работы с результатами анализа
 */
public class StatResult {

    private String statisticByDocType;
    private String StatisticByEmployee;

    public String getStatisticByDocType() {
        return statisticByDocType;
    }

    public void setStatisticByDocType(String statisticByDocType) {
        this.statisticByDocType = statisticByDocType;
    }

    public String getStatisticByEmployee() {
        return StatisticByEmployee;
    }

    public void setStatisticByEmployee(String statisticByEmployee) {
        StatisticByEmployee = statisticByEmployee;
    }
}
