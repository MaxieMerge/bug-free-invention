CREATE TABLE Capability(
    Capability_ID TINYINT PRIMARY KEY AUTO_INCREMENT, 
    Capability_Name varchar (40) NOT NULL
);

CREATE TABLE Job_Family(
    Job_Family_ID TINYINT PRIMARY KEY AUTO_INCREMENT,
    Job_Family_Title varchar (40) NOT NULL,
    Capability_ID TINYINT,
    FOREIGN KEY (`Capability_ID`) REFERENCES `Capability`(`Capability_ID`)
);

CREATE TABLE Band(
    Band_ID TINYINT PRIMARY KEY AUTO_INCREMENT,
    Band_Name varchar (40), 
    Band_Level TINYINT NOT NULL, 
    Band_Training text, 
    Band_Competencies text, 
    Band_Responsibilites text
);

CREATE TABLE Job(
    Job_ID SMALLINT PRIMARY KEY AUTO_INCREMENT,
    Job_Title varchar (50) NOT NULL,
    Job_Spec text NOT NULL,
    Band_ID TINYINT,
    Job_Family_ID TINYINT,
    Capability_ID TINYINT,
    FOREIGN KEY (`Band_ID`) REFERENCES `Band`(`Band_ID`),
    FOREIGN KEY (`Job_Family_ID`) REFERENCES `Job_Family`(`Job_Family_ID`),
    FOREIGN KEY (`Capability_ID`) REFERENCES `Capability`(`Capability_ID`)
);

CREATE TABLE JobSummary(
	Summary_ID int NOT NULL,
    Summary_Text text(200) NOT NULL,
    Job_ID smallint NOT NULL,
    PRIMARY KEY (Summary_ID),
    FOREIGN KEY (Job_ID) REFERENCES Job(Job_ID)
    );


CREATE TABLE Employee(
    Employee_ID SMALLINT PRIMARY KEY AUTO_INCREMENT,
    F_Name varchar (40) NOT NULL,
    L_Name varchar (40) NOT NULL,
    Username varchar (40) NOT NULL,
    User_Password varchar (60) NOT NULL,
    is_Admin boolean NOT NULL, 
    Job_ID SMALLINT NOT NULL, 
    FOREIGN KEY (`Job_ID`) REFERENCES `Job`(`Job_ID`)
);

