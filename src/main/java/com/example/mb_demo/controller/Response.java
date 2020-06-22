package com.example.mb_demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Response  {
    String status;
    String reason;
    public Response failure(String reason) {
        Response response=new Response();
        response.setStatus("failed");
        response.setReason(reason);
        return response;
    }
}
