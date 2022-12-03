package by.st.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "settings")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "setting_seq")
    @SequenceGenerator(name = "setting_seq",
            sequenceName = "settingseq", allocationSize = 1)
    private Long id;
    @Column(name = "setting_code")
    private long settingCode;
    @Column(name = "setting_name")
    private String settingName;
    @Column(name = "setting_date")
    private Date settingDate;
    @Column(name = "is_open")
    private int isOpen;
    @Column(name = "value")
    private String value;
}
