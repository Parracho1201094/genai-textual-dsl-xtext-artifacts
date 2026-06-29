package org.example.lts.cli;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.example.lts.LtsStandaloneSetup;

import com.google.inject.Injector;

public final class LtsCli {
    private LtsCli() {
    }

    public static void main(String[] arguments) throws Exception {
        if (arguments.length < 2) {
            System.err.println("Usage: LtsCli <output-directory> <model.lts>...");
            System.exit(2);
        }

        Path output = Path.of(arguments[0]).toAbsolutePath().normalize();
        Injector injector = new LtsStandaloneSetup().createInjectorAndDoEMFRegistration();
        ResourceSet resources = injector.getInstance(XtextResourceSet.class);
        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        GeneratorDelegate generator = injector.getInstance(GeneratorDelegate.class);
        JavaIoFileSystemAccess files = injector.getInstance(JavaIoFileSystemAccess.class);
        files.setOutputPath(output.toString());

        boolean failed = false;
        for (int i = 1; i < arguments.length; i++) {
            Path model = Path.of(arguments[i]).toAbsolutePath().normalize();
            Resource resource = resources.getResource(
                    URI.createFileURI(model.toString()), true);
            List<Issue> issues = validator.validate(
                    resource, CheckMode.ALL, CancelIndicator.NullImpl);
            for (Issue issue : issues) {
                System.out.printf("%s:%s:%s: %s: %s%n",
                        model,
                        issue.getLineNumber() == null ? "?" : issue.getLineNumber(),
                        issue.getColumn() == null ? "?" : issue.getColumn(),
                        issue.getSeverity(),
                        issue.getMessage());
            }
            boolean hasErrors = issues.stream()
                    .anyMatch(issue -> issue.getSeverity()
                            == org.eclipse.xtext.diagnostics.Severity.ERROR);
            if (hasErrors) {
                failed = true;
                continue;
            }
            GeneratorContext context = new GeneratorContext();
            context.setCancelIndicator(CancelIndicator.NullImpl);
            generator.generate(resource, files, context);
            System.out.println("Generated " + model.getFileName());
        }
        if (failed) {
            System.exit(1);
        }
    }
}
