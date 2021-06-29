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
@NoArgsConstructor
@AllArgsConstructor
public class QueryTypesParamId implements Serializable {
    @Column(name = "query_type")
    private int queryType;
    @Column(name = "id_param")
    private String idParam;
    @Column(name = "parent_id_param")
    private String parentIdParam;

}
