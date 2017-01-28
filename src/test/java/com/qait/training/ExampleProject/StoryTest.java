/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.training.ExampleProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.codehaus.plexus.util.StringUtils;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;

/**
 *
 * @author QAIT
 */
public class StoryTest extends JUnitStories {

	private final CrossReference xref = new CrossReference();

	public StoryTest() {

		configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
				.doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(10000);
	}

	@Override
	public Configuration configuration() {

		Class<? extends Embeddable> embeddableClass = this.getClass();
		Properties viewResources = new Properties();
		viewResources.put("decorateHtml", "true");
		viewResources.put("reports", "ftl/jbehave-reports.ftl");
		viewResources.put("views", "ftl/jbehave-views.ftl");
		viewResources.put("decorated", "ftl/jbehave-report-decorated.ftl");

		ParameterConverters parameterConverters = new ParameterConverters();
		ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(),
				new LoadFromClasspath(embeddableClass), parameterConverters);

		// add custom converters

		parameterConverters.addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
				new ParameterConverters.ExamplesTableConverter(examplesTableFactory));

		URL storyURL = null;
		try {
			storyURL = new URL("file://" + System.getProperty("user.dir") + File.separator + "." + File.separator + "src" + File.separator
					+ "main" + File.separator + "resources" + File.separator + "stories" + File.separator);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return new MostUsefulConfiguration()
				.useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
				.useStoryLoader(
						new LoadFromRelativeFile(storyURL))
				.useStoryParser(
						new RegexStoryParser(
								examplesTableFactory))
				.useStoryPathResolver(new UnderscoredCamelCaseResolver())
				.useStoryReporterBuilder(new StoryReporterBuilder()
						.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass)).withDefaultFormats()
						.withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
						.withViewResources(viewResources).withFormats(Format.CONSOLE, Format.HTML_TEMPLATE, Format.XML)
						.withFailureTrace(true).withFailureTraceCompression(true).withCrossReference(xref))
				.useParameterConverters(parameterConverters).useStepMonitor(xref.getStepMonitor());
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new JbehaveTest(), new JbehaveAssertJTest());
	}

	@Override
	protected List<String> storyPaths() {
		URL codeLocation = CodeLocations.codeLocationFromPath("." + File.separator + "src" + File.separator
				+ "main" + File.separator + "resources" + File.separator + "stories" + File.separator);
		List<String> paths = new ArrayList<String>();
		List<String> stories = new ArrayList<String>();

		String[] storyIdentifier;
		paths = new StoryFinder().findPaths(codeLocation, Arrays.asList("/*.story"), Arrays.asList(""));
		return paths;
	}
}
