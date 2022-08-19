package com.flock.listener;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener("This is only a demo listener")
public class TestListener implements ServletContextListener {
	// ...
}
