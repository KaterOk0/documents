package by.st.service;

import by.st.config.TestDataBaseConfig;
import by.st.model.Setting;
import by.st.services.SettingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class for testing Setting Service
 */

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
public class SettingServiceTest {

    @Autowired
    private SettingService settingService;

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getAllSettingsTest() {
        List<Setting> all = settingService.getAll();
        assertNotNull(all);
        assertTrue(all.size() > 0);
    }

    @Test
    public void addSettingTest() {
        Setting setting = settingService.addSetting(getSettingForTest());
        assertNotNull(setting.getId());
    }

    @Test
    @Transactional
    public void updateSettingTest() {
        Setting settingForTest = new Setting(12001,
                "Максимально допустимый размер прикрепляемого файла для документа №26 (Кб)",
                new Date(),
                1,
                "5003030902");
        Setting setting = settingService.updateSetting(settingForTest);
        assertNotNull(setting.getId());
        Setting openSettingBySettingCode = settingService.getOpenSettingBySettingCode(12001);
        assertEquals("5003030902", openSettingBySettingCode.getValue());
    }

    @Test
    @Transactional
    public void deleteSettingTest() {
        settingService.deleteSetting(100);
        assertNull(settingService.getById(100));
    }

    @Test
    public void getSettingBySettingCodeTest() throws ParseException {
        Setting openSettingBySettingCode = settingService.getOpenSettingBySettingCode(141);
        assertEquals("3", openSettingBySettingCode.getValue());
        assertEquals(DATE_FORMAT.parse("2018-11-09"), openSettingBySettingCode.getSettingDate());
        assertEquals(1, openSettingBySettingCode.getIsOpen());
    }

    private Setting getSettingForTest() {
        return new Setting(5000,
                "Количество допустимых валют в заявке на зачем взаимных требований",
                new Date(),
                1,
                "5");
    }

}
