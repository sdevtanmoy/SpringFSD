-- Create User table

CREATE TABLE User (
	user_id INT NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(50) NOT NULL,
	user_added_date DATE NULL,
	user_password VARCHAR(50) NULL,
	user_mobile VARCHAR(15) NULL,
	PRIMARY KEY (user_id)
)
;

-- Create Note Table
CREATE TABLE Note (
	note_id INT NOT NULL AUTO_INCREMENT,
	note_title VARCHAR(50) NOT NULL,
	note_content VARCHAR(500),
	note_status VARCHAR(50) NULL,
	note_creation_date DATETIME,
	PRIMARY KEY (note_id)
)
;

-- Create Category table
CREATE TABLE Category (
	category_id INT NOT NULL AUTO_INCREMENT,
	category_name VARCHAR(50) NOT NULL,
	category_descr VARCHAR(500),
	category_creation_date DATETIME,
	category_creator VARCHAR(50) NULL,
	PRIMARY KEY (category_id)
)
;

-- Create Reminder table
CREATE TABLE Reminder (
	reminder_id INT NOT NULL AUTO_INCREMENT,
	reminder_name VARCHAR(50) NOT NULL,
	reminder_descr VARCHAR(500),
	reminder_type  VARCHAR(20),	
	reminder_creation_date DATETIME,
	reminder_creator VARCHAR(50) NULL,
	PRIMARY KEY (reminder_id)
)
;


-- Create NoteCategory table
CREATE TABLE NoteCategory (
	notecategory_id INT NOT NULL AUTO_INCREMENT,
	note_id INT NULL,
	category_id INT NULL,
	PRIMARY KEY (notecategory_id),
	FOREIGN KEY (note_id) REFERENCES Note(note_id),
	FOREIGN KEY (category_id) REFERENCES Category(category_id)
)
;

-- Create Notereminder table
CREATE TABLE Notereminder (
	notereminder_id INT NOT NULL AUTO_INCREMENT,
	note_id INT NULL,
	reminder_id INT NULL,
	PRIMARY KEY (notereminder_id),
	FOREIGN KEY (note_id) REFERENCES Note(note_id),
	FOREIGN KEY (reminder_id) REFERENCES Reminder(reminder_id)
)
;

-- Create usernote table
CREATE TABLE usernote (
	usernote_id INT NOT NULL AUTO_INCREMENT,
	note_id INT NULL,
	user_id INT NULL,
	PRIMARY KEY (usernote_id),
	FOREIGN KEY (note_id) REFERENCES Note(note_id),
	FOREIGN KEY (user_id) REFERENCES User(user_id)
)
;

------------------------------------------------------------------------------------------------------------------------------------------------
-- ## Insert the rows into the created tables (Note, Category, Reminder, User, UserNote, NoteReminder and NoteCategory).


--- Insert records into note table 
INSERT INTO Note (note_title, note_content, note_status, note_creation_date) VALUES ('Sample-Title', 'sample-Content', 'completed', now());

--- Insert records into Category table 
INSERT INTO Category (category_name, category_descr, category_creation_date, category_creator) VALUES ('Sample-Category', 'Category of sample type', now(), 'ADMIN');

--- Insert records into Reminder table 
INSERT INTO Reminder (reminder_name, reminder_descr, reminder_type, reminder_creation_date, reminder_creator) VALUES ('SAMPLE Reminder', 'sample reminder description', 'High', now(), 'ADMIN');

--- INSERT into user table
INSERT INTO USER (user_name, user_added_date, user_password, user_mobile) VALUES ('sampleuser', CURDATE(), 'samplepaswd', '+91-9999999999');

--- INSERT into usernote table
INSERT INTO usernote (note_id, user_id) VALUES (1, 2);

-- INSERT into NoteReminder
INSERT INTO NoteReminder (note_id, reminder_id) values (1, 1);

-- INSERT into NoteCategory
INSERT INTO NoteCategory(note_id, category_id) values (1, 1);

--------------------------------------------------------------------------------------------------------------------------------------------------

--Fetch the row from User table based on Id and Password.
select u.* from user u where u.user_id=? and u.user_password=?;

--Fetch all the rows from Note table based on the field note_creation_date.
select n.* from note n where n.note_creation_date=?;

--Fetch all the Categories created after the particular Date.
select c.* from category c where c.category_creation_date > CURDATE();

--Fetch all the Note ID from UserNote table for a given User.
select un.note_id from usernote un where un.user_id=?;

--Write Update query to modify particular Note for the given note Id.
update note n set n.note_title=? , n.note_content=? , n.note_status=? where n.note_id=?;

--Fetch all the Notes from the Note table by a particular User.
select n.* from note n, usernote un where un.note_id=n.note_id and un.user_id=?;

--Fetch all the Notes from the Note table for a particular Category.
select * from note n, notecategory nc where nc.note_id=n.note_id and nc.category_id=?;

--Fetch all the reminder details for a given note id.
select * from reminder r, notereminder nr where nr.reminder_id=r.reminder_id and nr.note_id=?;

--Fetch the reminder details for a given reminder id.
select r.* from reminder r where r.reminder_id=?;

--Write a query to create a new Note from particular User (Use Note and UserNote tables - insert statement).
-- @SR-Madhu --did not understant the requirement

--Write a query to create a new Note from particular User to particular Category(Use Note and NoteCategory tables - insert statement) 
-- @SR-Madhu --did not understant the requirement

--Write a query to set a reminder for a particular note (Use Reminder and NoteReminder tables - insert statement)
-- @SR-Madhu --did not understant the requirement

--Write a query to delete particular Note added by a User(Note and UserNote tables - delete statement)
delete n from note n, notecategory nc, category c where nc.note_id=n.note_id and nc.category_id=c.category_id and c.category_name='Sample-Category1'; 
 
--Write a query to delete particular Note from particular Category(Note and NoteCategory tables - delete statement)
delete n from note n, usernote un, user u where un.note_id=n.note_id and un.user_id=u.user_id and u.user_name=?; 


-- trigger 1, on delete note table row UserNote, NoteReminder and NoteCategory records will be deleted also

--Create a trigger to delete all matching records from UserNote, NoteReminder and NoteCategory table when :
-- 1. A particular note is deleted from Note table (all the matching records from UserNote, NoteReminder and NoteCategory should be removed automatically) 
DELIMITER |

CREATE TRIGGER notes_after_delete 
	AFTER DELETE ON note FOR EACH ROW
	
BEGIN
	DECLARE old_note_id INT;
	SET old_note_id = old.note_id;
	DELETE FROM usernote WHERE usernote.note_id=old_note_id;
	DELETE FROM notereminder WHERE notereminder.note_id=old_note_id;
	DELETE FROM notecategory WHERE notecategory.note_id=old_note_id;
	
END; |

DELIMITER ;	 


--2. A particular user is deleted from User table (all the matching notes should be removed automatically)
-- @SR-Madhu --did not understant the requirement
