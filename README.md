Assumptions
===========

* java is installed
* gradle is installed (mac: brew install gradle)
* tomcat is installed (mac: brew install tomcat)
* intellij is the IDE of choice

Getting Started
===============
1. `git clone`
2. cd PairStairs
3. `gradle idea`
4. `open PairStairs.ipr`
5. `gradle tomcatRun`
6. go to `http://localhost:8080/PairStairs/api/developers` to see the json
7. go to `http://localhost:8080/PairStairs/static/index.html` to see static files
8. tinker, expand, enjoy

To Run the version till Steven last commit
==========================================
1. Run gradle clean
2. Run gradle tomcatRun
3. Shut the tomcat down(CTRL+C)
4. Run gradle cucumber for all the tests to pass

License
=======
Apache 2
