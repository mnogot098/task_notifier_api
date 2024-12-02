package com.notifier.app.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "channel_status")
public class ChannelStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;

    @Column(nullable = false, length = 100)
    private String name;

}