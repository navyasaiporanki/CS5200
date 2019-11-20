const mongoose = require('mongoose');
const studentModel = require('../models/student.model.server');
const questionModel = require('../models/question.model.server');
const answerModel = require('../models/answer.model.server');



//1. find all Students.
findAllStudents = () => {
	return studentModel.find();
};

//2. find student by id.
findStudentById = id => {
	return studentModel.find({_id: id});
};

//3. find all questions
findAllQuestions = () => {
	return questionModel.find();
};

//4. find question by id.
findQuestionById = id => {
	return questionModel.find({_id: id});
};

//5. find all answers.
findAllAnswers = () => {
	return answerModel.find();
};

//6. find answers by id.
findAnswerById = id => {
	return answerModel.find({_id: id});
};

//7. retrieves all the answers for a student whose ID is studentId
findAnswersByStudent = studentId => {
	return answerModel.find({student: studentId});
};


//8.retrieves all the answers for a question whose ID is questionId
findAnswersByQuestion = questionId => {
	return answerModel.find({question: questionId});	
};


module.exports = {
		findAllStudents, findStudentById, findAllQuestions, findQuestionById, 
		findAllAnswers, findAnswerById, findAnswersByStudent, findAnswersByQuestion
}

