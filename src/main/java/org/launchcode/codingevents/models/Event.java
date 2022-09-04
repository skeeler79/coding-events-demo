package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message="Please enter a location.")
    @NotNull(message="Please enter a location.")
    private String location;

    @AssertTrue(message="The attendee must be registered.")
    private boolean registration = true; //when set to true, automatically checks the checkbox in the create form

    @Positive(message="Please enter at least 1 attendee.")
    @NotNull
    private Integer numOfAttendees;

    @NotNull(message= "Please serve food")
    @Min(value =1, message= "courses must be between 1 and 3")
    @Max(value = 3, message= "courses must be between 1 and 3")
    private Integer numOfCourses;

    public Event(String name, String description, String contactEmail, String location, Integer numOfAttendees, Integer numOfCourses) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.numOfAttendees= numOfAttendees;
        this.numOfCourses = numOfCourses;

    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Integer getNumOfAttendees() {
        return numOfAttendees;
    }

    public void setNumOfAttendees(Integer numOfAttendees) {
        this.numOfAttendees = numOfAttendees;
    }

    public Integer getNumOfCourses() {
        return numOfCourses;
    }

    public void setNumOfCourses(Integer numOfCourses) {
        this.numOfCourses = numOfCourses;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
