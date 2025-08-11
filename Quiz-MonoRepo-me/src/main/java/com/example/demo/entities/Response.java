//package com.example.demo.entities;
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//@Data
//@RequiredArgsConstructor
//public class Response {
//    private Long id;
//    private String userAnswer;
//}

package com.example.demo.entities;

public class Response {

    private Long id;
    private String userAnswer;

    public Response() {
    }

    public Response(Long id, String userAnswer) {
        this.id = id;
        this.userAnswer = userAnswer;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserAnswer() { return userAnswer; }
    public void setUserAnswer(String userAnswer) { this.userAnswer = userAnswer; }
}
