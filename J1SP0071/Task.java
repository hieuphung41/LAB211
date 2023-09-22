package J1SP0071;

import java.util.Date;

public class Task {
    private int id;
    private int taskTypeID;
    private String name;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, int taskTypeID, String name, Date date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.name = name;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    private Validation validation = new Validation();

    public Task createTask() {
        System.out.print("Input id: ");
        this.setId(validation.getInt());
        System.out.print("Input task type id: ");
        this.setTaskTypeID(validation.getIntInRange(1, 4));
        System.out.print("Input name: ");
        this.setName(validation.getString());
        System.out.print("Input date: ");
        this.setDate(validation.getValidDate());
        System.out.print("Input plan from: ");
        this.setPlanFrom(validation.getDouble());
        System.out.print("Input plan to: ");
        this.setPlanTo(validation.getDouble());
        System.out.print("Input assignee: ");
        this.setAssignee(validation.getString());
        System.out.print("Input reviewer: ");
        this.setReviewer(validation.getString());
        return this;
    }
}
