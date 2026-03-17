package com.javadayistanbul.patterns.classic.factory;

public class NotificationClassicFactory {
    public static NotificationClassicService create(NotificationClassicType type) {
        return switch (type) {
            case EMAIL -> new EmailNotificationClassicService();
            case SMS -> new SmsNotificationClassicService();
            case PUSH -> new PushNotificationClassicService();
        };
    }
}
