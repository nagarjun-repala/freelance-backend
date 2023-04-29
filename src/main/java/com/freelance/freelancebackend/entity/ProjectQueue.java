package com.freelance.freelancebackend.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_queue")
public class ProjectQueue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  @JsonIgnore
  private User users;

  @ManyToOne(optional = false)
  @JoinColumn(name = "project_id", referencedColumnName = "id")
  @JsonIgnore
  private Project project;

  @NonNull
  @Column(name = "applied_on", nullable = false)
  private LocalDateTime appliedOn;

  @NonNull
  @Column(name = "price_quote", nullable = false)
  private Long priceQuote;

  @NonNull
  @Column(name = "cover_letter", nullable = false)
  private String coverLetter;

  @NonNull
  @Column(name = "status", nullable = false)
  private String status;

  
}
