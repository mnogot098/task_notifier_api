package com.notifier.app.api;


import com.notifier.app.models.Channel;
import com.notifier.app.models.Task;
import com.notifier.app.models.User;
import com.notifier.app.services.ChannelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/channels")
@RestController
@AllArgsConstructor
public class ChannelApiController {

    @Autowired
    ChannelService channelService;

    @GetMapping
    public Map<String, Object> getAllChannels() {
        List<Channel> channels = channelService.getActiveChannels();
        return Map.of("channels", channels);
    }
}