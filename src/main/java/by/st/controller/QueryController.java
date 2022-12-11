package by.st.controller;

import by.st.model.Query;
import by.st.services.QueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/query")
@AllArgsConstructor
public class QueryController {

    @Autowired
    private final QueryService queryService;

    @GetMapping("/getQuery/{queryId}")
    @PreAuthorize("hasAuthority('queries:read')")
    public ResponseEntity<Query> getQuery(@PathVariable("queryId") long queryId) {
        return ResponseEntity.ok(queryService.getQueryRecord(queryId, 1));
    }

    @PostMapping("/saveQuery")
    @PreAuthorize("hasAuthority('queries:write')")
    public ResponseEntity<Long> saveQuery(@RequestBody Query query) {
        return ResponseEntity.ok(queryService.saveQuery(query));
    }
}
