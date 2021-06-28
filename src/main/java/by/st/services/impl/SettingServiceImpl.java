package by.st.services.impl;

import by.st.model.Setting;
import by.st.repository.SettingRepository;
import by.st.services.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {

    @Autowired
    private final SettingRepository settingRepository;

    @Override
    public List<Setting> getAll() {
        return settingRepository.findAll();
    }

    @Override
    public Setting addSetting(Setting setting) {
        // используя просто save() мы сохраняем запись но после вызова flush данные попадают в БД
        return settingRepository.save(setting);
    }

    @Override
    public void deleteSetting(long id) {
        settingRepository.deleteById(id);
    }

    @Override
    public Setting updateSetting(Setting setting) {
        // найти последнюю настройку, установить is_open = 0
        closeLastSetting(setting);
        // вставка новой настройки с is_open = 1
        return settingRepository.saveAndFlush(setting);
    }

    private void closeLastSetting(Setting setting) {
        Setting openSetting = getOpenSettingBySettingCode(setting.getSettingCode());
        openSetting.setIsOpen(0);
        settingRepository.saveAndFlush(openSetting);
    }

    @Override
    public Setting getOpenSettingBySettingCode(long settingCode) {
        return settingRepository.findOpenSettingBySettingCode(settingCode);
    }

}
