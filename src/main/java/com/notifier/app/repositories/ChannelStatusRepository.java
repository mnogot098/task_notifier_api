package com.notifier.app.repositories;

import com.notifier.app.models.ChannelStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelStatusRepository extends JpaRepository<ChannelStatus,Integer> {
}
