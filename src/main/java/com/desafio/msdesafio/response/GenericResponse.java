package com.desafio.msdesafio.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {

   private HttpStatus httpStatus;
   private String     message;

}
