package by.st.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "settings")
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

    public Setting(long settingCode, String settingName, Date settingDate, int isOpen, String value) {
        this.settingCode = settingCode;
        this.settingName = settingName;
        this.settingDate = settingDate;
        this.isOpen = isOpen;
        this.value = value;
    }
}
