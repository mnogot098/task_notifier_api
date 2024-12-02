package com.notifier.app.repositories;

import com.notifier.app.models.Channel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    // Custom query method to find all channels with status_id equal to 1
    List<Channel> findByChannelStatus_StatusId(Integer statusId);
}
