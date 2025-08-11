//package com.example.demo.enities;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Question {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@NotBlank(message = "Question title is required")
//	private String questionTitle;
//	@NotBlank(message = "Option1 is required")
//	private String option1;
//	@NotBlank(message = "Option2 is required")
//	private String option2;
//	@NotBlank(message = "Option3 is required")
//	private String option3;
//	@NotBlank(message = "Option4 is required")
//	private String option4;
//	@NotBlank(message = "Correct answer is required")
//	private String correctAnswer;
//
//	@Enumerated(EnumType.STRING)
//	@NotNull(message = "Difficulty level is required")
//	private DifficultyLevel difficultyLevel;
//
//	@Enumerated(EnumType.STRING)
//	@NotNull(message = "Category is required")
//	private Category category;
//
//	public enum DifficultyLevel {
//		EASY, MEDIUM, HARD
//	}
//
//	public enum Category {
//		JAVA, SPRING, GIT, SPRINGBOOT
//
//	}
//

//}

package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Question title is required")
    private String questionTitle;

    @NotBlank(message = "Option1 is required")
    private String option1;

    @NotBlank(message = "Option2 is required")
    private String option2;

    @NotBlank(message = "Option3 is required")
    private String option3;

    @NotBlank(message = "Option4 is required")
    private String option4;

    @NotBlank(message = "Correct answer is required")
    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Difficulty level is required")
    private DifficultyLevel difficultyLevel;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Category is required")
    private Category category;

    // Enums
    public enum DifficultyLevel {
        EASY, MEDIUM, HARD
    }

    public enum Category {
        JAVA, SPRING, GIT, SPRINGBOOT
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQuestionTitle() { return questionTitle; }
    public void setQuestionTitle(String questionTitle) { this.questionTitle = questionTitle; }

    public String getOption1() { return option1; }
    public void setOption1(String option1) { this.option1 = option1; }

    public String getOption2() { return option2; }
    public void setOption2(String option2) { this.option2 = option2; }

    public String getOption3() { return option3; }
    public void setOption3(String option3) { this.option3 = option3; }

    public String getOption4() { return option4; }
    public void setOption4(String option4) { this.option4 = option4; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public DifficultyLevel getDifficultyLevel() { return difficultyLevel; }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) { this.difficultyLevel = difficultyLevel; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}

