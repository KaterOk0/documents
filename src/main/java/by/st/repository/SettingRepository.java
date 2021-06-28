package by.st.repository;

import by.st.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SettingRepository extends JpaRepository<Setting, Long> {

    @Query("Select s from Setting s where s.settingCode = :settingCode and s.isOpen = 1")
    Setting findOpenSettingBySettingCode(long settingCode);
}
