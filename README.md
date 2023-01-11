Android Development 

The main activity in this application has two buttons, one labeled "InputPage" and the other labeled "ContactsPage." When the app starts, the "MainActivity" class's "onCreate" method is called, and it sets the layout for the activity to "activity_main" and sets the title of the activity to "Main." The code then sets an OnClickListener for the "inputButton" variable, which when clicked, will call the "openSecondActivity" method. The "openSecondActivity" method creates a new Intent that starts the "MainActivity2" class, and the startActivityForResult method starts this new activity. 

Then, the code override the onActivityResult method, which gets called when the "MainActivity2" class finishes and returns a result. The method first checks if the request code is 100 and if the result code is RESULT_OK. If both conditions are true, the code sets an OnClickListener for the "ContactsButton" variable, which when clicked, will create a new Intent with the action of INSERT and the data of "ContactsContract.Contacts.CONTENT_URI". The intent then put extra with key "ContactsContract.Intents.Insert.NAME" and value from the userinput in the previous activity, then start this new activity.

Otherwise, if the result is not OK, it check for invalid input such as empty name or number in the name then shows a Toast message to the user accordingly.


