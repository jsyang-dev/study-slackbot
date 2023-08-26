package me.study.slackbot;

import com.slack.api.bolt.App;
import com.slack.api.methods.MethodsClient;
import com.slack.api.model.event.AppMentionEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackApp {
    @Bean
    public App initSlackApp() {
        App app = new App();

        app.event(AppMentionEvent.class, (payload, ctx) -> {
            final AppMentionEvent event = payload.getEvent();
            final MethodsClient client = ctx.client();

            client.chatPostMessage(chatPostMessageRequestBuilder -> chatPostMessageRequestBuilder
                    .channel(event.getChannel())
                    .text(String.format("<@%s> 님이 '%s' 라고 말했습니다.", event.getUser(), event.getText())));

            return ctx.ack();
        });

        return app;
    }
}
