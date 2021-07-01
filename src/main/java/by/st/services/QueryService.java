package by.st.services;

import by.st.model.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryService {

    List<Query> getAll(Pageable pageable);

    List<Query> getByQueryTypeSortedByDate(int queryType, Pageable pageable);

    /**
     * Найти все 46ые документы с заданным параметром AgencyName
     * Наименование органа Фонда, согласовавшего справку
     *
     * @return список
     */
    List<Query> getZPProjectWithSpecialAgencyName(String agencyName, Pageable pageable);

    // TODO статистика по месяцам сколько за каждый месяц создано допустим 9ок
    // TODO вставка документов
    // TODO update document
}
