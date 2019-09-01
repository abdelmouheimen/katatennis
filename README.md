# katatennis
-KataTennis is an application to show the score of two players  match and determine the winner.  
-this application is composed of four main classes:  
   &nbsp;&nbsp;&nbsp;   * "Player" : a player of tennis match.  
   &nbsp;&nbsp;&nbsp;   * "Match"  : composed of many Sets.  
   &nbsp;&nbsp;&nbsp;   * "Set"    : Composed of many games.  
   &nbsp;&nbsp;&nbsp;   * "Game"   : the little part of a Set.  
        
  Below is the class diagram of the application:  
  ![Alt text](/src/main/resources/diagrammeclasse.PNG?raw=true "class diagram")  
    
      
  -The ExampleKataTennis is a simulation of tennis match with random values.  
    
 -I Have used the TDD(Test Driven Development) methodology to develop this application. The test classes are:  
   &nbsp;&nbsp;&nbsp;   * PlayerTest to test Player class.  
   &nbsp;&nbsp;&nbsp;   * GameTest to test Game class.  
   &nbsp;&nbsp;&nbsp;   * SetTest to test Set class.  
   &nbsp;&nbsp;&nbsp;   * MatchTest to test Match class.  
   &nbsp;&nbsp;&nbsp;   * TestSomeScenarios to test some real tennis scenarios.  
   
  -I have integrated the EclEmma plugin into eclipse to calculate the test coverage which is 87,1% for this application.  
  ![Alt text](/src/main/resources/testcoverage.PNG)  
