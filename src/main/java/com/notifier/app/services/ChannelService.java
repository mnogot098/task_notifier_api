package com.notifier.app.services;

import com.notifier.app.models.Channel;
import com.notifier.app.models.ChannelStatus;
import com.notifier.app.repositories.ChannelRepository;
import com.notifier.app.repositories.ChannelStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private ChannelStatusRepository channelStatusRepository;

    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }
    public List<Channel> getActiveChannels() {
        return channelRepository.findByChannelStatus_StatusId(1);
    }

    public Optional<Channel> getChannelById(Integer id) {
        return this.channelRepository.findById(id);
    }

    public void createChannel(Channel channel) {
        channelRepository.save(channel);
    }

    public void deleteChannel(Integer id) {
        channelRepository.deleteById(id);
    }

    public List<ChannelStatus> getAllStatus() {
        return channelStatusRepository.findAll();
    }

    public ChannelStatus findStatusById(Integer statusId) {
        return channelStatusRepository.findById(statusId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid status ID: " + statusId));
    }

    public void updateChannel(Integer id, Channel channel) {
        Channel existingChannel = channelRepository.findById(id).orElseThrow(() -> new RuntimeException("Channel not found"));
        existingChannel.setName(channel.getName());
        existingChannel.setDescription(channel.getDescription());
        existingChannel.setChannelStatus(channel.getChannelStatus());
        channelRepository.save(existingChannel);
    }
}
