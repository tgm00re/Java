package com.codingdojo.overflow.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.overflow.mvc.models.AddQuestion;
import com.codingdojo.overflow.mvc.models.Answer;
import com.codingdojo.overflow.mvc.models.Question;
import com.codingdojo.overflow.mvc.models.Tag;
import com.codingdojo.overflow.mvc.services.AnswerService;
import com.codingdojo.overflow.mvc.services.QuestionService;
import com.codingdojo.overflow.mvc.services.TagService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService qServ;
	
	@Autowired
	private TagService tagServ;
	
	@Autowired
	private AnswerService ansServ;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<Question> questionList = qServ.findAll();	
		model.addAttribute("questionList",questionList);
			
		return "index.jsp";
	}
	
	@RequestMapping("/create/question")
	public String createQuestion(@ModelAttribute("addQuestion") AddQuestion addQuestion) {
		return "createquestion.jsp";
	}
	
	@PostMapping("/question/processcreate")
	public String processQuestionCreate(@Valid @ModelAttribute("addQuestion") AddQuestion addQuestion, BindingResult result) {
		String[] tagSubArr = qServ.validateQuestion(addQuestion, result);
		System.out.println("MARKER UNO");
		if(result.hasErrors()) {
			System.out.println("errors were found!");
			return "createquestion.jsp";
		}
		System.out.println("We got to this point.");
		List<Tag> tagList = new ArrayList<Tag>();
		for(String sub : tagSubArr) {
			Tag potentialTag = tagServ.findOneBySubject(sub);
			if(potentialTag == null) {
				Tag tag = new Tag(sub);
				tagServ.createTag(tag);
				tagList.add(tag);
			} else {
				tagList.add(potentialTag);
			}
		}
		Question question = new Question(addQuestion.getQuestion(), tagList);
		qServ.createQuestion(question);
		return "redirect:/";
	}
	
	@RequestMapping("/view/question/{id}")
	public String viewQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("myAnswer") Answer answer) {
		Question question = qServ.findOneById(id);
		if(question == null) {
			return "redirect:/";
		}
		model.addAttribute(question);
		return "displayquestion.jsp";
	}
	
	@PostMapping("/answer/processcreate/{questionId}")
	public String processAnswerCreate(Model model, @PathVariable("questionId") Long id, @Valid @ModelAttribute("myAnswer") Answer answer, BindingResult result) {
		Question q = qServ.findOneById(id);
		if(result.hasErrors()) {
			model.addAttribute("question", q);
			return "displayquestion.jsp";
		}
		answer.setQuestion(q);
		ansServ.createAnswer(answer);
		return "redirect:/view/question/" + id;
	}
}
