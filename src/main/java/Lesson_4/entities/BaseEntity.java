package Lesson_4.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract public class BaseEntity {

    protected final Logger logger;
    private String loggerName;

    public BaseEntity(String loggerName) {
        this.logger = LogManager.getLogger(loggerName);
    }

}
