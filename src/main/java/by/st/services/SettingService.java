package by.st.services;

import by.st.model.Setting;

import java.util.List;

public interface SettingService {

    List<Setting> getAll();

    Setting getById(long id);

    Setting addSetting(Setting setting);

    void deleteSetting(long id);

    Setting updateSetting(Setting setting);

    Setting getOpenSettingBySettingCode(long settingCode);

}
