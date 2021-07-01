package by.st.model.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueryInputParamId implements Serializable {
    @Column(name = "query_id")
    private long queryId;
    @Column(name = "num_param")
    private long numParam;
}
