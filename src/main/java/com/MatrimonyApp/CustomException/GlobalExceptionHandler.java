package com.MatrimonyApp.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<UserAlreadyExistException> resourceNotFoundException(UserAlreadyExistException exception) {
		String message = exception.getMessage();
		UserAlreadyExistException userAlreadyExist = new UserAlreadyExistException(message);
		return new ResponseEntity<UserAlreadyExistException>(userAlreadyExist, HttpStatus.CONFLICT);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception) {
//		String message = exception.getMessage();
//		ApiResponse apiResponse = new ApiResponse(message, false);
//		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
//	}
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(
//			MethodArgumentNotValidException exception) {
//		Map<String, String> response = new HashMap<>();
//		exception.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError) error).getField();
//			String message = error.getDefaultMessage();
//			response.put(fieldName, message);
//		});
//
//		return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(ApiException.class)
//	public ResponseEntity<ApiResponse> handleApiException(ApiException exception) {
//		String message = exception.getMessage();
//		ApiResponse apiResponse = new ApiResponse(message, true);
//		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
//	}
}
