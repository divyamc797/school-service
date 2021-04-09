# school-service

Postman automation
var jsonData = JSON.parse(responseBody);

pm.globals.set("token", jsonData.token);

--header 'Authorization: Bearer {{token}}

![Screenshot](PostmanImage.PNG)

