


video-26-----------------------------------
in this video we are going to learn that how to upload a images by using spring-Boot in statically
---------
step-1: for that we have to configure some details in appliation.propeties file
example--
        #enable the multipart data..
        spring.servlet.multipart.enabled=true

        #max file size 
        spring.servlet.multipart.max-file-size=500MB

        #threadshold after which file are written to desk
        spring.servlet.multipart.file-size-threshold=1KB

step-2: create a container class in container name as UploadFile.java
step-3: create a folder name as image to store all the images
step-4: run the project and goto to postman
step-5: select the Body bar then after select the body bar select the form-data
step-6: after select the form-data there is there is key table is from that table select the file from drop down
step-7: then select the image from local and request the poccess.

-----------------video-27---------------------------------------
