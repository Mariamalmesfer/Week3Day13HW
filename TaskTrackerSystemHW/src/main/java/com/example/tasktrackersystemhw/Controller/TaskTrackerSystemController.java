package com.example.tasktrackersystemhw.Controller;

import com.example.tasktrackersystemhw.Model.TaskTrackerSystem;
import com.example.tasktrackersystemhw.TaskTrackerSystemHwApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tasktracker")
public class TaskTrackerSystemController {

    ArrayList<TaskTrackerSystem> TaskTrackers = new ArrayList<>();



    // Create a new taks (id ,title , description , status)

    @PostMapping("/add")
    public String addTask(@RequestBody TaskTrackerSystem taskTrackerSystem) {
        TaskTrackers.add(taskTrackerSystem);
        return"added successfully";
    }

//    Display all tasks .
    @GetMapping("/get")
    public ArrayList<TaskTrackerSystem> getTaskTrackers(){
        return TaskTrackers;
    }

//    Update a task
    @PutMapping("/update/{index}") // must be the same name
    public String updateTaskTrackers(@PathVariable int index,@RequestBody TaskTrackerSystem taskTrackerSystem ){
            TaskTrackers.set(index,taskTrackerSystem);
         return"Updated successfully";
    }

//    Delete a task
@DeleteMapping("/delete/{index}")
public String deleteTaskTrackers(@PathVariable int index){
    TaskTrackers.remove(index);
    return "deleted successfully" ;

}

//    Change the task status as done or not done

    @PutMapping("/updatestatus/{index}/{status}") // must be the same name
    public String updateStatus(@PathVariable int index,@PathVariable String status){
        TaskTrackerSystem taskTrackerSystem= TaskTrackers.get(index);
        taskTrackerSystem.setStatus(status);
        return"The Status is updated successfully" ;
    }


   //    Search for a task by given title

    @GetMapping("/search/{title}")
    public String Search(@PathVariable String title){
        for(TaskTrackerSystem i: TaskTrackers){
            if(i.getTitle().equals(title)){
                return "exists" ;
            }

        }
        return "not exists";
    }










}
