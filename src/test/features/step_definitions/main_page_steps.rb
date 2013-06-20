Given /^I visit the main page$/ do
  @driver.navigate.to "http://localhost:8080/PairStairs/static/index.html"
end

Then /^I should be greeted with "([^"]*)"$/ do |expected_greeting|
  greeting = @driver.find_element(:tag_name, "h1")
  greeting.text.should eq(expected_greeting)
end