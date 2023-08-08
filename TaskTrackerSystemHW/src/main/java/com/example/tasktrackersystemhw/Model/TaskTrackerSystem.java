package com.example.tasktrackersystemhw.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskTrackerSystem {

    private String id;

    private String title;

    private String description;

    private String status;

}
