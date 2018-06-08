# ChocoOcho
Team # 8 Repository

MEMBERS:
- David Bartges
- Marko Bozic
- Daniel Connelly
- Thong Nguyen
- Phuong Pham
- Angelic Phan

THE ENVIRONMENT WE ARE WORKING ON:
- We implemented our program in Java using Intellij IDE CE (Version 2018.1.2).
- We utilized Junit 5 for our unit tests. You may be prompted to import Junit 5 into your system if you see that the test
  classes are highlighted in red indicating an error. 
- Our program works best on Macs I believe. One member who was a Windows user couldn't get the .txt files from our write
  to file functions to show up.  All Mac users had no issues. However, another member tested it on a separate Windows system
  and it was working fine. It might just be issues with the particular computer and not with the Windows operatoring system.

THE STEPS YOU NEED TO RUN THE PROGRAM LOCALLY:
- Keep the project folder name "May 30 - CS300Project2" as is when downloading, as our read from file functions
  are dependant on the name. Download both src and testsrc.
- Compile and run the java class "ChocAn." It is our main.
- Once the program is running, in order to access the Interactive/Manger mode, you will
  be prompted for a manger's ID. Please use the ManagerList.txt file to copy any of the valid
  manager IDs into the input. Similarly, in order to access the Provider mode, you will need to
  refer to the ProviderList.txt file to copy a valid provider ID. Finally, in order to alter a member's information, you will need to       consult the MemberList.txt file.
  
OTHER THINGS TO KNOW:
- When requesting reports (i.e. Summary Reports, Provider History, Member History),
  they will only appear on the side bar where all the .txt files are after the program has ended.
- The Member/Provider service history reports will appear titled as the respective Member/Provider name.
- Provider and Summary Reports will only show services of the week. Therefore, when testing, please refer
  to the ServiceHistory.txt files for appropriate dates. The first date a line is the service date.
