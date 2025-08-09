package com.wipro.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.lang.Long;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question_table")
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Question is required")
	private String question;
	@NotNull(message = "Option1 is required")
	private String option1;
	@NotNull(message = "Option2 is required")
	private String option2;
	@NotNull(message = "Option3 is required")
	private String option3;
	@NotNull(message = "Option4 is required")
	private String option4;
	@NotNull(message = "Correct answer required")
	private String correctAnswer;
	

	
	@Enumerated(EnumType.STRING)
	private DifficultyLevel difficultyLevel;
	
	public enum DifficultyLevel{
		EASY,
		MEDIUM,
		HARD
	}
	@Enumerated(EnumType.STRING)
	private Category category;
	
	public enum Category{
		JAVA,
		GIT,
		SPRINGBOOT
	}
}
