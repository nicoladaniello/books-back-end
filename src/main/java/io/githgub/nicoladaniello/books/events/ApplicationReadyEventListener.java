package io.githgub.nicoladaniello.books.events;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("Application started... launching browser now.");
        browse("http://localhost:8080");
    }

    private static void browse(String url) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            String cmd;

            if (SystemUtils.IS_OS_WINDOWS) cmd = "rundll32 url.dll,FileProtocolHandler " + url;
            else if (SystemUtils.IS_OS_MAC) cmd = "open " + url;
            else {
                System.out.println("OS not supported, open page manually.");
                return;
            }

            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        System.out.println("Using System Property: " + os);
        return os;
    }
}
