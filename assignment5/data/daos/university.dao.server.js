const mongoose = require('mongoose');
const studentModel = require('../models/student.model.server');
const questionModel = require('../models/question.model.server');
const answerModel = require('../models/answer.model.server');
const quizWidgetModel = require('../models/quiz-widget.model.server');


/*Function to remove all the records from the database.*/
truncateDatabase = () => {
	
	return answerModel.deleteMany({}).
	then(() => questionModel.deleteMany({})).
	then(() => studentModel.deleteMany({})).
	then(() => 	console.log("deleted Database"));;
	
};


/*Function to insert all the records from the database.*/
populateDatabase = () => {
	
	/*
	 * Inserting Students
	*/
	
	console.log("started populated Database");
	var alice = { _id: 123,username: 'alice', password: 'alice', firstName: 'Alice', lastName: 'Wonderland', gradYear: 2020, scholarship: 15000}
	
	var bob = { _id: 234,username: 'bob', password: 'bob', firstName: 'Bob', lastName: 'Hope', gradYear: 2021, scholarship: 12000}
	
	/*
	 * Inserting questions 
	 */
	
	var questionSchemaValid = {_id: 321,question: 'Is the following schema valid?', points: 10,questionType: 'TRUE_FALSE',
			trueFalse: {isTrue: false}}
	var questionDao = {_id: 432,question: 'DAO stands for Dynamic Access Object.', points: 10,questionType: 'TRUE_FALSE',
			trueFalse: {isTrue: false}}
	
	var questionJPA = {_id: 543,question: 'What does JPA stand for?', points: 10,questionType: 'MULTIPLE_CHOICE',
			multipleChoice: {choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
				correct: 1}
			}
	var questionORM = {_id: 654,question: 'What does ORM stand for?', points: 10,questionType: 'MULTIPLE_CHOICE',
			multipleChoice: {choices: 'Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
				correct: 4}
			}
	
	/*
	 * Inserting Answers
	 * */
	
	var ans_alice_questionSchemaValid = {_id: 123,trueFalseAnswer: true,student: 123,question: 321};
	var ans_alice_questionDao = {_id: 234,trueFalseAnswer: false,student: 123,question: 432};
	var ans_alice_questionJPA = {_id: 345,multipleChoiceAnswer: 1,student: 123,question: 543};
	var ans_alice_questionORM = {_id: 456,multipleChoiceAnswer: 2,student: 123,question: 654};
	
	var ans_bob_questionSchemaValid = {_id: 567,trueFalseAnswer: false,student: 234,question: 321};
	var ans_bob_questionDao = {_id: 678,trueFalseAnswer: true,student: 234,question: 432};
	var ans_bob_questionJPA = {_id: 789,multipleChoiceAnswer: 3,student: 234,question: 543};
	var ans_bob_questionORM = {_id: 890,multipleChoiceAnswer: 4,student: 234,question: 654};
			
	return createStudent(alice).
	then(() => createStudent(bob)).
	then(() => createQuestion(questionSchemaValid)).
	then(() => createQuestion(questionDao)).
	then(() => createQuestion(questionJPA)).
	then(() => createQuestion(questionORM)).
	then(() => answerModel.create(ans_alice_questionSchemaValid)).
	then(() => answerModel.create(ans_alice_questionDao)).
	then(() => answerModel.create(ans_alice_questionJPA)).
	then(() => answerModel.create(ans_alice_questionORM)).
	then(() => answerModel.create(ans_bob_questionSchemaValid)).
	then(() => answerModel.create(ans_bob_questionDao)).
	then(() => answerModel.create(ans_bob_questionJPA)).
	then(() => answerModel.create(ans_bob_questionORM)).
	then(() => 	console.log("done populated Database"))
};


//3.function to insert a student in to the database
createStudent = student => { return studentModel.create(student);};

//4.function to delete a student from the db
deleteStudent = id => {
	return studentModel.remove({_id: id});
};

//5.function to insert a question in to the database
createQuestion = question => {return questionModel.create(question);};

//6.function to delete a question
deleteQuestion = id => {
	return questionModel.remove({_id: id});
};

//7.function to insert an answer by Student student for Question question
answerQuestion = (studentId, questionId, answer) => {
	return answerModel.create({_id: answer},{student: studentId, question: questionId} );
};

//8.function to delete an answer from the database.
deleteAnswer = id => {
	return answerModel.remove({_id: id});
};


module.exports = {
	truncateDatabase, populateDatabase ,createStudent, deleteStudent, 
	createQuestion, deleteQuestion, answerQuestion, deleteAnswer	
}