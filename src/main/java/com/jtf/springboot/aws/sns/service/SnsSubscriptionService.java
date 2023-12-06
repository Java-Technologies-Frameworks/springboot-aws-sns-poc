package com.jtf.springboot.aws.sns.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SnsSubscriptionService {

    @Autowired
    private AmazonSNS amazonSNS;

    @Value("${aws.sns.topic.arn}")
    private String topicARN;
//    @Value("${aws.sns.topic.arn.subscription.endpoint}")
//    private String subscriptionEndpoint;
//    @Value("${aws.emailId}")
//    private String emailId;

    public String subscribeToEmail(String emailAddress) {
        SubscribeRequest subscribeRequest = new SubscribeRequest()
                .withTopicArn(topicARN)
                .withProtocol("email")
                .withEndpoint(emailAddress);

        SubscribeResult subscribeResult = amazonSNS.subscribe(subscribeRequest);
        return subscribeResult.getSubscriptionArn();
    }
}
