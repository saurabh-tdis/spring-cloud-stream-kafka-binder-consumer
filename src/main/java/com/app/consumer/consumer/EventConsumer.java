package com.app.consumer.consumer;

import com.app.consumer.model.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @author Saurabh Vaish
 * @Date 17-10-2021
 *
 *  Implementing cloud functions for supplier
 *
 */

@Configuration
@Log4j2
public class EventConsumer {

    /****
     *  It's the same as defining the controller and then trigger publish event
     *  instead we can define functions and publish events to consumer
     *
     *  to publish and trigger this function use post to  /consumeBookEvent  with data
     *
     * @return
     */
    @Bean
    public Consumer<Book> consumeBookEvent(){
        return (book)->{
            log.info("event consumed with data :: "+ book.toString());

            // do some other action on data
        };
    }
}
