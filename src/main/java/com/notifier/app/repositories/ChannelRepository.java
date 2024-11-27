package com.notifier.app.repositories;

import com.notifier.app.models.Channel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel,Integer> {
}
