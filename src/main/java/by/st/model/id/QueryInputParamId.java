package by.st.model.id;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class QueryInputParamId implements Serializable {
    @Column(name = "query_id")
    private long queryId;
    @Column(name = "num_param")
    private long numParam;
}
