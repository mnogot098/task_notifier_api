package com.notifier.app.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer channelId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private ChannelStatus channelStatus;
}