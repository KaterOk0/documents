package by.st.model;

import by.st.model.id.QueryInputParamId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "query_input_params")
public class QueryInputParam {

    @EmbeddedId
    private QueryInputParamId inputParamId;

    @Column(name = "name_param")
    private String nameParam;

    @Column(name = "value_param")
    private String valueParam;

    @Column(name = "ncycle")
    private int ncycle;

    @ManyToOne
    @MapsId(value = "queryId")
    @JoinColumn(name = "query_id")
    private Query query;
}
