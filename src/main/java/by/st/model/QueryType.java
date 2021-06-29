package by.st.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "query_types")
public class QueryType {

    @Id
    @Column(name = "query_type")
    private int queryType;

    @Column(name = "name_query")
    private String nameQuery;

    @Column(name = "print_file")
    private String printFile;

    @OneToMany(mappedBy = "queryType")
    private Set<Query> queries;

    @OneToMany(mappedBy = "queryType")
    private Set<QueryTypesParam> queryTypesParams;
}
