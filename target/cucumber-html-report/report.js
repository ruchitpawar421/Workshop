$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/sample.feature");
formatter.feature({
  "line": 1,
  "name": "Perform arithematic operations using 2 numbers",
  "description": "",
  "id": "perform-arithematic-operations-using-2-numbers",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Adding 2 numbers",
  "description": "",
  "id": "perform-arithematic-operations-using-2-numbers;adding-2-numbers",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "The values of first and second numbers are 3 and 5 respectively",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Adding first and second numbers",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Sum of 2 numbers is greater then 0",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 43
    },
    {
      "val": "5",
      "offset": 49
    }
  ],
  "location": "CucumberTest.given(int,int)"
});
formatter.result({
  "duration": 385585778,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.whenAdd()"
});
formatter.result({
  "duration": 51556,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 7
    },
    {
      "val": "0",
      "offset": 33
    }
  ],
  "location": "CucumberTest.thenSum(int,int)"
});
formatter.result({
  "duration": 3260889,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Multiplying 2 numbers",
  "description": "",
  "id": "perform-arithematic-operations-using-2-numbers;multiplying-2-numbers",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "The values of first and second numbers are 3 and 5 respectively",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Multiplying first and second numbers",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Product of 2 numbers is greater then 10",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 43
    },
    {
      "val": "5",
      "offset": 49
    }
  ],
  "location": "CucumberTest.given(int,int)"
});
formatter.result({
  "duration": 545334,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.whenMultiply()"
});
formatter.result({
  "duration": 48000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 11
    },
    {
      "val": "10",
      "offset": 37
    }
  ],
  "location": "CucumberTest.thenProduct(int,int)"
});
formatter.result({
  "duration": 1066222,
  "error_message": "java.lang.AssertionError: Product is not greater than 10\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.qait.training.ExampleProject.CucumberTest.thenProduct(CucumberTest.java:38)\r\n\tat ✽.Then Product of 2 numbers is greater then 10(src/main/resources/sample.feature:11)\r\n",
  "status": "failed"
});
});