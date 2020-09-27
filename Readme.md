Connect4 API
============================

Deployment steps:

1. Unzip the folder. You will see one jar and one property file.
2. Pre-requisites java 8.
3. To run the program use command:  java -jar connect4-1.0.jar --spring.config.location=application.properties<location of your app prop file>
   Or use any java IDE to import the project as a maven project and add project property --spring.config.location=application.properties<location of your app prop file> and just run it.
   
API Documentation
============================

1. I have used Spring boot and hibernate to make the API's.
2. There are 3 API in the project:
a. Start Game API
URI: http://35.154.232.35:8080/v1/connect4/start
Request method: POST
Request body: 
{
	"username":"sumit",
	"message": "START"
}

Response body:
{
    "status": "READY",
    "token": "7e4b4dc2-1489-439a-a8ff-45c8cd4492bf",
    "turn": "YELLOW Player turn"
}

b. Make a move API
URI: http://35.154.232.35:8080/v1/connect4/game/move
Request method: POST
Request body: 
{
	"player":0,
	"column":4,
	"gameId":"093b12fb-c015-404d-8920-f601c19c7218"
}
Here player 0 means "YELLOW" and 1 means "RED"

Response body:
{
    "result": "No winner",
    "turn": "RED"
}


c. GET  moves API
URI: http://35.154.232.35:8080/v1/connect4/game/move?gameId=7e4b4dc2-1489-439a-a8ff-45c8cd4492bf
Request method: GET
Request parameter: gameId
Response body:
{
    "red_player": "4 ",
    "yellow_player": "4 2 "
}

All errors are also hanndled properly.

3. API are deployed at AWS EC2 instance. And using a in-memory H2 database.

4. Table schema
FIELD  		TYPE  			NULL  	KEY  	DEFAULT  
GAME_ID		VARCHAR(255)	NO		PRI		NULL
GAME_STATE	VARCHAR(255)	YES				NULL
NAME		VARCHAR(255)	YES				NULL
PLAYER1		VARCHAR(255)	YES				NULL
PLAYER2		VARCHAR(255)	YES				NULL
RESULT		INTEGER(10)		YES				NULL
TURN		INTEGER(10)		YES				NULL
