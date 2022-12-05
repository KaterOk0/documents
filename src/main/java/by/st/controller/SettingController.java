package by.st.controller;

import by.st.model.Setting;
import by.st.services.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/settings")
@RequiredArgsConstructor
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/getSettings")
    @PreAuthorize("hasAuthority('settings:read')")
    ResponseEntity<List<Setting>> all() {
        return ResponseEntity.ok(settingService.getAll());
    }

    @GetMapping("/getSetting/{settingId}")
    @PreAuthorize("hasAuthority('settings:read')")
    ResponseEntity<Setting> getSetting(@PathVariable Long settingId) {
        return ResponseEntity.ok(settingService.getById(settingId));
    }

    @PutMapping("/updateSetting/{settingId}")
    @PreAuthorize("hasAuthority('settings:write')")
    ResponseEntity<Setting> replaceSetting(@RequestBody Setting newSetting, @PathVariable String settingId) {
        return ResponseEntity.ok(settingService.updateSetting(newSetting));
    }
}
