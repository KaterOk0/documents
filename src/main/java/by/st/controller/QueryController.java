package by.st.controller;

import by.st.model.Query;
import by.st.services.QueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/query")
@AllArgsConstructor
public class QueryController {

    @Autowired
    QueryService queryService;

    @GetMapping("/getQuery/{queryId}")
    public Query getQuery(@PathVariable("queryId") long queryId) {
        return queryService.getQueryRecord(queryId);
    }
}
