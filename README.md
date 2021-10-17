#Spring Cloud Stream With Kafka Binder

### Consumer Example

    This is the example of spring cloud streams using kafka as binder . It demonstrate 
    the pub sub model in event-driven form.
    Spring cloud stream works as middleware to send and recieve data with help of some
    binder and does abstraction on it , so that we can replace the binder any time.

    We need to add the following dependency in both publisher and consumer

            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-stream</artifactId>
            </dependency>

            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-stream-binder-kafka</artifactId>
            </dependency>

            <dependency>
                <groupId>org.springframework.kafka</groupId>
                <artifactId>spring-kafka</artifactId>
            </dependency>


###Note: 
    Spring cloud stream above 2.1 works with functional programming model .

##Steps: 
    1. first we need to create a consumer function of type Function or Supplier or Consumer ( as needed )
    2. add the following properties
            spring:
                cloud:
                    function:
                        definition: consumeBookEvent  // consumer function name
                        scan:
                            functions: com.app.publisher.eventPublisher
                stream:
                    bindings:
                        consumeBookEvent-in-0:  // will consume events from this binding
                            destination: stream-cloud-test  // topic name
                            binder: kafka

    4. now when even we will generate event it will consume them and do buisness logic as needed