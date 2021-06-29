package by.st.model;

import by.st.model.id.QueryTypesParamId;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "query_types_params")
public class QueryTypesParam {

    @EmbeddedId
    private QueryTypesParamId queryTypesParamId;

    @Column(name = "type_param")
    private String typeParam;

    @Column(name = "name_param")
    private String nameParam;

    @Column(name = "is_obligatory")
    private int isObligatory;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @MapsId("queryType")
    @JoinColumn(name = "query_type")
    private QueryType queryType;
}

