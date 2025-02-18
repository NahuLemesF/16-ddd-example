package com.buildingblocks.appointments.domain.appointment.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PatientModified extends DomainEvent {
  private final String id;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final Integer age;
  private final String reason;

  protected PatientModified(String id, String firstName, String lastName, String email, Integer age, String reason) {
    super(EventsEnum.PATIENT_MODIFIED.name());
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    this.reason = reason;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public Integer getAge() {
    return age;
  }

  public String getReason() {
    return reason;
  }
}
