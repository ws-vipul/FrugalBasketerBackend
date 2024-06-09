package com.frugalbasketer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admin_logs")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class AdminLogsEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int adminId;
    @Column
    private String action;
    @Column
    private String log;
    @Column
    private String reason;
    @Column
    private String logDateTime;

}
