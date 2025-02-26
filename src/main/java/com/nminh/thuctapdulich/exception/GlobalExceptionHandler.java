package com.nminh.thuctapdulich.exception;

import com.nminh.thuctapdulich.enums.ErrorCode;
import com.nminh.thuctapdulich.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> runtimeExceptionHandler(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = AppException.class) // xử lý các exception của appException
    ResponseEntity<ApiResponse> appExceptionHandler(AppException e) {
        ErrorCode errorCode = e.getErrorCode(); // lấy lỗi từ error code

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class) //xử lý các exception valid từ các request body
    ResponseEntity<ApiResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError(); // lấy lỗi đầu tiên trong danh sách
        if(fieldError != null){
            switch (fieldError.getField()){
                case "email":
                    return ResponseEntity.status(ErrorCode.EMAIL_INVALID_FORMAT.getStatusCode())
                            .body(new ApiResponse(ErrorCode.EMAIL_INVALID_FORMAT.getCode(),
                                    ErrorCode.EMAIL_INVALID_FORMAT.getMessage()));
                case "phone":
                    return ResponseEntity.status(ErrorCode.PHONE_INVALID_FORMAT.getStatusCode())
                            .body(new ApiResponse(ErrorCode.PHONE_INVALID_FORMAT.getCode(),
                                    ErrorCode.PHONE_INVALID_FORMAT.getMessage()));
            }
        }
        return ResponseEntity.badRequest().body(new ApiResponse<>(400,"Validator"));
    }
}
