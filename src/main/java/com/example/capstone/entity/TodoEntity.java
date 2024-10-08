package com.example.capstone.entity;

import jakarta.persistence.*;

@Table(name="todo_table")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column(unique = true)
    private String TodoTitle;

    @Column()
    private String getTodoCategory;

    @Column(unique = true)
    private String todoStart;

    @Column(unique = true)
    private String todoEnd;

    @Column(unique = true)
    private String todoContent;


}
