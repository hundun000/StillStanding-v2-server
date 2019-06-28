package com.zaca.stillstanding.domain;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.bind.annotation.InitBinder;

import com.zaca.stillstanding.domain.question.Question;
import com.zaca.stillstanding.domain.question.TagManager;
import com.zaca.stillstanding.domain.team.Team;
import com.zaca.stillstanding.exception.ConflictException;
import com.zaca.stillstanding.exception.NotFoundException;
import com.zaca.stillstanding.exception.QuestionFormatException;
import com.zaca.stillstanding.service.QuestionService;
import com.zaca.stillstanding.service.TeamService;
import com.zaca.stillstanding.tool.QuestionTool;

/**
 *
 * @author hundun
 * Created on 2019/03/19
 */
public class SimpleQuestionTest {
	
	QuestionService questionService = new QuestionService();
	TeamService teamService = new TeamService();

	@Test
	public void test() throws IOException, QuestionFormatException, ConflictException, NotFoundException {
		
		questionService.initQuestions();
		teamService.creatTeam("砍口垒同好组");
		
		List<String> pickUpTagNames = new ArrayList<>();
		pickUpTagNames.add("单机游戏");
		teamService.setPickUpTagsForTeam("砍口垒同好组", pickUpTagNames);
		
		List<String> banTagNames = new ArrayList<>();
		banTagNames.add("动画");
		teamService.setBanTagsForTeam("砍口垒同好组", banTagNames);
		
		questionService.initQuestions();
		
		Team team = teamService.getTeam("砍口垒同好组");
		for (int i = 1; i < 20; i++) {
			Question question = questionService.getNewQuestionForTeam(team);
			System.out.println("第"+i+"题"+question.getTags()+"："+question.getStem());
		}
	}


}
