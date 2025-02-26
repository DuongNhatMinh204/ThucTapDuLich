package com.nminh.thuctapdulich.entity;

public class UserTour {
    private Long userId;
    private Long tourId;
    UserTour() {}

    public UserTour(Long userId, Long tourId) {
        this.userId = userId;
        this.tourId = tourId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }
}
