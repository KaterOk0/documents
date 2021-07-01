package by.st.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "queries")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "query_seq")
    @SequenceGenerator(name = "query_seq",
            sequenceName = "queryseq", allocationSize = 1)
    @Column(name = "query_id")
    private Long queryId;

    @Column(name = "last_status")
    private int lastStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "query_type")
    private QueryType queryType;

    @Column(name = "query_date")
    private Date queryDate;

    @OneToMany(mappedBy = "query",
            cascade = CascadeType.REMOVE// «Дочерняя» сущность удаляется только тогда, когда ее «Родитель» удаляется.
    )
    Set<QueryInputParam> inputParams;
}
