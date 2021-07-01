package by.st.service;

import by.st.config.TestDataBaseConfig;
import by.st.model.Query;
import by.st.services.QueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
public class QueryServiceImplTest {
    @Autowired
    private QueryService service;

    final Pageable firstPageWithTwoElements = PageRequest.of(0, 10,
            Sort.by("queryDate").descending().and(Sort.by("queryId")));

    @Test
    public void getAllTest() {
        List<Query> all = service.getAll(firstPageWithTwoElements);
        assertEquals(10, all.size());
    }

    @Test
    // without index 149 ms
    public void getByQueryTypeSortedByDateTest() {
        long startTime = System.nanoTime();
        List<Query> all = service.getByQueryTypeSortedByDate(158, firstPageWithTwoElements);
        assertEquals(10, all.size());
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);
    }

    @Test
    public void getByAgencyNameTest() {
        long startTime = System.nanoTime();
        List<Query> all = service.getZPProjectWithSpecialAgencyName("МОСКОВСКИЙ РАЙОННЫЙ ОТДЕЛ ФСЗН Г.МИНСКА", firstPageWithTwoElements);
        assertEquals(5, all.size());
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);
    }
}
