# CRUD Application developed using springboot and mongoDB.
## Hit the APIs of the application using Postman.

<h3>User can create journals. According to the user the journals are stored. User can get ,update, delete and create the journals</h3>

<br>
<h4>User APIs</h4>
<h5>getAllUser  ---> GET--->(/user)</h5>
<h5>createUser  ---> POST--->(/user)</h5>
<h5>updateUserByUserName  ---> PUT--->(/user/{username})</h5>
<br>
<h4>Journal APIs</h4>
<h5>getAllJournalEntriesOfUser  ---> GET--->(/{userName})</h5>
<h5>createEntry  ---> POST--->(/{userName})</h5>
<h5>deleteEntryById  ---> DELETE--->(/id/{userName}/{id})</h5>
<h5>changeEntryById  ---> PUT>(/id/{userName}/{id})</h5>
