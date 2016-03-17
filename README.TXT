===========================================
CONFIGURATION DESCRIPTION
===========================================
First of all you have to configure the application. For this purpose you have to go into Config Tab.
Next we will describe each properties grouped by they purpose:
The first group of properties is for the DB connection.
		- server= --> DB server
		- sid=    --> DB SID
		- port=   --> DB connection port
		- user=   --> User for DB access
		- pass=   --> User pass for DB connection
The second group purpose is for query definition, the columns which we will take into account for the report, query table
and where clause if it is needed. 
		- columns= --> You put columns which you will want to take into account in audit report. All columns you will put
					   separated by comma and without spaces between commas and columns names. MAX 8. 
					   If you need more columns put in contact with David Gutierrez.
		- table= --> Here put the table where we will take all report information
		- where= --> Query where clause if it's needed.
===========================================
HOW TO USE
===========================================
For execution of application we will open a terminal in our computer --> Start --> CMD.
We will put in $CViewAuditorHOME.
Here we are going to execute de .jar file with the next command:
		java -jar CViewAuditor.jar

A little window will appear. Here we choose the directory where the audit report will be saved and after we'll click on Launch 
button.
NOTE --> Save directories should be local directories, not share/net Units.
===========================================
SYSTEM REQUIREMENTS
===========================================
The only requirement for correct execution is that Your computer should have jre installed for execution of this program.
All libraries and dependencies are included into application package.
===========================================
CONTACT
===========================================
If you have any question put in contact with next directions:
	- david.gutierrez.otero@gmail.com (Out of office Hours)
	- david.gutierrezotero@bnpparibas.com (For office hours)