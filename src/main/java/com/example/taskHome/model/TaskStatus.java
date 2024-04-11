package com.example.taskHome.model;

public enum TaskStatus {
    NOT_STARTED{
        @Override
        public String toString() {
            return "Not being executed";
        }
    }, IN_PROGRESS{
        @Override
        public String toString() {
            return "In progress";
        }
    }, COMPLETED{
        @Override
        public String toString() {
            return "Completed";
        }
    };
}
