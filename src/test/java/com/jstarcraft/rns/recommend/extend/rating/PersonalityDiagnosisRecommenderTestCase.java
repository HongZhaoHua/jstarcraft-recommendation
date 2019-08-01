package com.jstarcraft.rns.recommend.extend.rating;

import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.ai.evaluate.rating.MAEEvaluator;
import com.jstarcraft.ai.evaluate.rating.MPEEvaluator;
import com.jstarcraft.ai.evaluate.rating.MSEEvaluator;
import com.jstarcraft.rns.configure.Configurator;
import com.jstarcraft.rns.recommend.extend.rating.PersonalityDiagnosisRecommender;
import com.jstarcraft.rns.task.RatingTask;

public class PersonalityDiagnosisRecommenderTestCase {

	@Test
	public void testRecommender() throws Exception {
		Configurator configuration = Configurator.valueOf("recommend/extend/personalitydiagnosis-test.properties");
		RatingTask job = new RatingTask(PersonalityDiagnosisRecommender.class, configuration);
		Map<String, Float> measures = job.execute();
		Assert.assertThat(measures.get(MAEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.71429574F));
		Assert.assertThat(measures.get(MPEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.76422536F));
		Assert.assertThat(measures.get(MSEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(1.0038381F));
	}

}