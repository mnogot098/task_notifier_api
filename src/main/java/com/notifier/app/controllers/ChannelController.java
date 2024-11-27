package com.notifier.app.controllers;

import com.notifier.app.models.Channel;
import com.notifier.app.models.ChannelStatus;
import com.notifier.app.repositories.ChannelRepository;
import com.notifier.app.services.ChannelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @GetMapping("/channels")
    public String index(Model model) {
        List<Channel> channels = channelService.getAllChannels();
        model.addAttribute("channels",channels);
        return "channels/index";
    }

    @GetMapping("/channels/add")
    public String addChannelForm(Model model) {
        model.addAttribute("channel", new Channel());
        model.addAttribute("statuses", channelService.getAllStatus());
        return "channels/add";
    }

    @PostMapping("/channels/add")
    public String addChannel(@ModelAttribute Channel channel) {
        Integer statusId = channel.getChannelStatus().getStatusId();
        ChannelStatus status = channelService.findStatusById(statusId);
        channel.setChannelStatus(status);

        channelService.createChannel(channel);
        return "redirect:/channels";
    }

    @GetMapping("/channels/edit/{id}")
    public String editChannelForm(@PathVariable("id") Integer id, Model model) {
        Optional<Channel> channelWrraper = channelService.getChannelById(id);
        if(channelWrraper.isPresent()) {
            Channel channel = channelWrraper.get();
            model.addAttribute("channel",channel);
            model.addAttribute("status",channelService.getAllStatus());
            return "channels/edit";
        }

        else {
            return "redirect:/channels";
        }
    }

    @PostMapping("/channels/edit/{id}")
    public String editChannel(@PathVariable("id") Integer id, @ModelAttribute @Valid Channel channel, BindingResult result) {
        if (result.hasErrors()) {
            return "channels/edit";
        }
        ChannelStatus status = channelService.findStatusById(channel.getChannelStatus().getStatusId());
        channel.setChannelStatus(status);

        channelService.updateChannel(id, channel);

        return "redirect:/channels";
    }

    @GetMapping("/channels/delete/{channelId}")
    public String deleteChannel(@PathVariable("channelId") Integer channelId) {
        channelService.deleteChannel(channelId);

        return "redirect:/channels";
    }
}
