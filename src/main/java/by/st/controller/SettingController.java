package by.st.controller;

import by.st.model.Setting;
import by.st.services.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/settings")
    List<Setting> all() {
        return settingService.getAll();
    }

    @GetMapping("/settings/{settingId}")
    Setting getSetting(@PathVariable Long settingId) {
        return settingService.getOpenSettingBySettingCode(settingId);
    }

    @PutMapping("/settings/{settingId}")
    Setting replaceSetting(@RequestBody Setting newSetting) {
        return settingService.updateSetting(newSetting);
    }

}
