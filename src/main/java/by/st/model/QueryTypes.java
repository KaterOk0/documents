package by.st.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "query_types")
public class QueryTypes {

    @Id
    @Column(name = "query_type")
    private int queryType;

    @Column(name = "name_query")
    private String nameQuery;

    @Column(name = "print_file")
    private String printFile;
}
