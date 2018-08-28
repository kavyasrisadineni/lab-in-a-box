package com.sigsci.dwiz;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.servlet.*;
import java.util.EnumSet;

import com.signalsciences.servlet.filter.SigSciFilter;

public class DwizExampleApplication extends Application<DwizExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DwizExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "DwizExample";
    }

    @Override
    public void initialize(final Bootstrap<DwizExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DwizExampleConfiguration configuration,
                    final Environment environment) {
         environment.servlets().addFilter("SigSciFilter", new SigSciFilter())
                                          .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");           
        // TODO: implement application
        final HelloWorldResource resource = new HelloWorldResource(
                "%s",
                "=^="
            );
            environment.jersey().register(resource);
    }

}
