package com.chlcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * start class - comment project
 *
 * @author chl
 */
@SpringBootApplication

public class CommentApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CommentApplication.class, args);
    }
}
